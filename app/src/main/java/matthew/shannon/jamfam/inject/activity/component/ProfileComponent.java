package matthew.shannon.jamfam.inject.activity.component;

import android.content.ContentResolver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.fuck_boilerplate.rx_paparazzo.RxPaparazzo;
import com.fuck_boilerplate.rx_paparazzo.entities.Options;
import com.fuck_boilerplate.rx_paparazzo.entities.Response;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Scope;
import co.mobiwise.materialintro.shape.Focus;
import co.mobiwise.materialintro.shape.FocusGravity;
import co.mobiwise.materialintro.view.MaterialIntroView;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.view.adapter.FragmentAdapter;
import matthew.shannon.jamfam.view.utils.constant.FragType;
import matthew.shannon.jamfam.presenter.activity.ProfilePresenter;
import matthew.shannon.jamfam.view.activity.ProfileView;
import matthew.shannon.jamfam.view.fragment.UserInfoView;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.view.fragment.ListView;
import rx.Observable;

@ProfileComponent.ProfileScope
@Subcomponent(modules = ProfileComponent.ProfileModule.class)
public interface ProfileComponent extends ActivityComponent<ProfileView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<ProfileModule, ProfileComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface ProfileScope {}

    @Module
    class ProfileModule extends ActivityModule<ProfileView> {
        private String ID;

        public ProfileModule(ProfileView activity, String ID) {
            super(activity);
            this.ID = ID;
        }

        @Provides
        @ProfileScope
        @IntoMap
        @IntKey(FragType.USER_TRACKS)
        Fragment listUserTracks() {
            return ListView.newInstance(ID, FragType.USER_TRACKS);
        }

        @Provides
        @ProfileScope
        @IntoMap
        @IntKey(FragType.USER_FRIENDS)
        Fragment listUserFriends() {
            return ListView.newInstance(ID, FragType.USER_FRIENDS);
        }

        @Provides
        @ProfileScope
        @IntoMap
        @IntKey(FragType.USER_INFO)
        Fragment userInfo() {
            return UserInfoView.newInstance(ID);
        }

        @Provides
        @ProfileScope
        Animation viewPagerAnimation(){
            return AnimationUtils.loadAnimation(activity, R.anim.slide_up);
        }

        @Provides
        @ProfileScope
        FragmentManager fragmentManager(){
            return activity.getSupportFragmentManager();
        }

        @Provides
        @ProfileScope
        FragmentAdapter fragmentAdapter(FragmentManager manager, Map<Integer, Fragment> map){
            FragmentAdapter adapter = new FragmentAdapter(manager);
            adapter.addFragment(map.get(FragType.USER_INFO), "About");
            adapter.addFragment(map.get(FragType.USER_TRACKS), "Tracks");
            adapter.addFragment(map.get(FragType.USER_FRIENDS), "Friends");
            return adapter;
        }

        @Provides
        @ProfileScope
        @Named("picture")
        Options providePictureOptions() {
            Options options = new Options();
            options.setToolbarColor(ContextCompat.getColor(activity, R.color.colorPrimary));
            options.setStatusBarColor(ContextCompat.getColor(activity, R.color.colorPrimaryDark));
            options.setAspectRatio(1, 1);
            options.setCompressionQuality(100);
            options.setMaxResultSize(200, 200);
            return options;
        }

        @Provides
        @ProfileScope
        @Named("banner")
        Options provideBannerOptions() {
            Options options = new Options();
            options.setToolbarColor(ContextCompat.getColor(activity, R.color.colorPrimary));
            options.setStatusBarColor(ContextCompat.getColor(activity, R.color.colorPrimaryDark));
            options.setAspectRatio(16, 9);
            options.setCompressionQuality(100);
            options.setMaxResultSize(640, 360);
            return options;
        }

        @Provides
        @ProfileScope
        @Named("profilePicture")
        MaterialIntroView.Builder provideProfilePictureIntro() {
            return new MaterialIntroView.Builder(activity)
                .enableDotAnimation(true)
                .enableIcon(false)
                .setFocusGravity(FocusGravity.LEFT)
                .setFocusType(Focus.MINIMUM)
                .setDelayMillis(500)
                .enableFadeAnimation(true)
                .performClick(true)
                .setInfoText("Click Here To Set Your Banner Picture")
                .setUsageId("profile_banner_intro_card");
        }

        @Provides
        @ProfileScope
        @Named("profileBanner")
        MaterialIntroView.Builder provideProfileBannerIntro() {
            return new MaterialIntroView.Builder(activity)
                .enableDotAnimation(true)
                .enableIcon(false)
                .setFocusGravity(FocusGravity.CENTER)
                .setFocusType(Focus.MINIMUM)
                .setDelayMillis(500)
                .enableFadeAnimation(true)
                .performClick(true)
                .setInfoText("Click Here To Set Your Profile Picture")
                .setUsageId("profile_picture_intro_card");
        }

        @Provides
        @ProfileScope
        ContentResolver contentResolver(){
            return activity.getContentResolver();
        }

        @Provides
        @ProfileScope
        @Named("pictureObservable")
        Observable<Response<ProfileView, String>> changeProfilePictureObservable(@Named("picture") Options options){
            return RxPaparazzo.takeImage(activity).crop(options).usingGallery();
        }

        @Provides
        @ProfileScope
        @Named("bannerObservable")
        Observable<Response<ProfileView, String>> changeProfileBannerObservable(@Named("banner") Options options){
            return RxPaparazzo.takeImage(activity).crop(options).usingGallery();
        }

        @Provides
        @ProfileScope
        User user(){
            return new User();
        }

        @Provides
        @ProfileScope
        ProfilePresenter profilePresenter(@Named("pictureObservable") Observable<Response<ProfileView, String>> picture, @Named("bannerObservable") Observable<Response<ProfileView, String>> banner, ContentResolver resolver, NetworkService network, CacheService cache, BusService bus, User user) {
            return new ProfilePresenter(picture, banner, resolver, network, activity, cache, bus, user);
        }
    }

}