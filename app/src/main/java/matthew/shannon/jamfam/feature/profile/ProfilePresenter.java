package matthew.shannon.jamfam.feature.profile;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.fuck_boilerplate.rx_paparazzo.entities.Response;
import java.io.File;

import javax.inject.Named;

import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.utils.RxUtils;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import rx.Observable;

public class ProfilePresenter extends BasePresenter {
    private final @Named("pictureObservable") Observable<Response<ProfileView, String>> picture;
    private final @Named("bannerObservable")Observable<Response<ProfileView, String>> banner;
    private final ContentResolver resolver;
    private final NetworkService network;
    private final ProfileView view;
    private final CacheService cache;
    private final BusService bus;
    private User user;

    public ProfilePresenter(@Named("pictureObservable")Observable<Response<ProfileView, String>> picture, @Named("bannerObservable")Observable<Response<ProfileView, String>> banner, ContentResolver resolver, NetworkService network, ProfileView view, CacheService cache, BusService bus, User user) {
        this.picture = picture;
        this.banner = banner;
        this.resolver = resolver;
        this.network = network;
        this.view = view;
        this.cache = cache;
        this.bus = bus;
        this.user = user;
    }

    public void loadUser(String ID) {
        add(network.getUser(App.token, ID)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                res -> {
                    user = res.get(0);
                    view.refreshProfile(user);
                },
                error -> {
                    view.showToast("Error Getting Profile");
                }
            )
        );
    }

    public void goToTrack(Track track) {
        bus.goToTrack(track);
    }

    public void checkForSecondRun() {
        add(cache.getSkipIntro()
            .compose(RxUtils.applySchedulers())
            .subscribe(
                flag -> {
                    if(!flag) {view.showIntroView(); }
                    else {cache.setProfileSecondRun(true);}
                },
                error -> { view.showToast("Error Getting Cached User"); }
            )
        );
    }

    private void loadUpdateUser() {
        add(network.putUser(App.token, user.get_id(), user)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                res -> {
                    user = res;
                    view.refreshProfile(user);
                    view.showToast("Profile Updated Successfully");
                },
                error -> {
                    view.showToast("Error Updating Profile");
                }
            )
        );
    }

    public void selectProfilePicture() {
        add(picture
            .compose(RxUtils.applySchedulers())
            .subscribe(
                res -> {
                    if (res.resultCode() == Activity.RESULT_OK) {
                        RxUtils
                        .uriToBitmap(resolver, Uri.fromFile(new File(res.data())))
                        .doOnNext(bitmap -> loadUpdateUser())
                        .doOnError(throwable -> view.showToast("Error Getting Image"))
                        .subscribe();
                    }
                },
                error -> Log.e("VIBETRIBE", "Error: ", error)
            )
        );
    }

    public void selectBannerPicture() {
        add(banner
            .compose(RxUtils.applySchedulers())
            .subscribe(
                res -> {
                    if (res.resultCode() == Activity.RESULT_OK) {
                        RxUtils
                            .uriToBitmap(resolver, Uri.fromFile(new File(res.data())))
                            .doOnNext(bitmap -> loadUpdateUser())
                            .doOnError(throwable -> view.showToast("Error Getting Image"))
                            .subscribe();
                    }
                },
                error -> Log.e("VIBETRIBE", "Error: ", error)
            )
        );
    }

}
