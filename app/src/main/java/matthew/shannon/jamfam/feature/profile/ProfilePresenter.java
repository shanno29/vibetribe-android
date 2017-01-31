package matthew.shannon.jamfam.feature.profile;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.fuck_boilerplate.rx_paparazzo.entities.Response;
import java.io.File;
import javax.inject.Named;
import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.model.User;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;
import matthew.shannon.jamfam.util.RxUtils;
import rx.Observable;

public class ProfilePresenter extends BasePresenter implements ProfileContract.Presenter {
    private final @Named("pictureObservable") Observable<Response<ProfileView, String>> picture;
    private final @Named("bannerObservable") Observable<Response<ProfileView, String>> banner;
    private final ContentResolver resolver;
    private final ProfileContract.View view;
    private final CacheService cache;
    private final FlowService flow;
    private User user;

    public ProfilePresenter(@Named("pictureObservable") Observable<Response<ProfileView, String>> picture, @Named("bannerObservable") Observable<Response<ProfileView, String>> banner, ContentResolver resolver, ProfileContract.View view, CacheService cache, FlowService flow, User user) {
        this.picture = picture;
        this.banner = banner;
        this.resolver = resolver;
        this.view = view;
        this.cache = cache;
        this.flow = flow;
        this.user = user;
    }

    @Override
    public void loadUser(String ID) {
//        add(network.getUser(App.token, ID)
//                .compose(RxUtils.applySchedulers())
//                .subscribe(
//                        res -> {
//                            user = res.get(0);
//                            view.refreshProfile(user);
//                        },
//                        error -> {
//                            view.showToast("Error Getting Profile");
//                        }
//                )
//        );
    }

    @Override
    public void goToTrack(Track track) {
        flow.goToTrack(track);
    }

    @Override
    public void checkForSecondRun() {
        add(cache.getSkipIntro()
                .compose(RxUtils.applySchedulers())
                .subscribe(
                        flag -> {
                            if (!flag) {
                                view.showIntroView();
                            } else {
                                cache.setProfileSecondRun(true);
                            }
                        },
                        error -> {
                            view.showToast("Error Getting Cached User");
                        }
                )
        );
    }

    @Override
    public void loadUpdateUser() {
//        add(network.putUser(App.token, user.get_id(), user)
//                .compose(RxUtils.applySchedulers())
//                .subscribe(
//                        res -> {
//                            user = res;
//                            view.refreshProfile(user);
//                            view.showToast("Profile Updated Successfully");
//                        },
//                        error -> {
//                            view.showToast("Error Updating Profile");
//                        }
//                )
//        );
    }

    @Override
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

    @Override
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
