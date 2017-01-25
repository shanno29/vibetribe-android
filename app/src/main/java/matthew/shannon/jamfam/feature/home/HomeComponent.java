package matthew.shannon.jamfam.feature.home;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import co.mobiwise.materialintro.shape.Focus;
import co.mobiwise.materialintro.shape.FocusGravity;
import co.mobiwise.materialintro.view.MaterialIntroView;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.feature.home.track.TrackView;
import matthew.shannon.jamfam.feature.home.map.MapView;
import matthew.shannon.jamfam.inject.activity.ActivityComponent;
import matthew.shannon.jamfam.inject.activity.ActivityComponentBuilder;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@HomeComponent.HomeScope
@Subcomponent(modules = HomeComponent.HomeModule.class)
public interface HomeComponent extends ActivityComponent<HomeView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<HomeModule, HomeComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface HomeScope {}

    @Module
    class HomeModule extends ActivityModule<HomeView> {

        public HomeModule(HomeView activity) {
            super(activity);
        }

        @Provides
        @HomeScope
        HomePresenter homePresenter(NetworkService network, CacheService cache, FlowService flow) {
            return new HomePresenter(activity, network, cache, flow);

        }

        @Provides
        @HomeScope
        MaterialIntroView.Builder provideHomeTrackIntroView(AppCompatActivity appCompatActivity) {
            return new MaterialIntroView.Builder(appCompatActivity)
                .setInfoText("Click Here To Start Some Music!")
                .setFocusGravity(FocusGravity.CENTER)
                .setFocusType(Focus.MINIMUM)
                .enableFadeAnimation(true)
                .enableDotAnimation(true)
                .setUsageId("intro_card")
                .setDelayMillis(500)
                .performClick(true)
                .enableIcon(false);
        }

        @Provides
        @HomeScope
        Animation viewPagerAnimation(){
            return AnimationUtils.loadAnimation(activity, R.anim.slide_up);
        }

        @Provides
        @HomeScope
        FragmentManager fragmentManager(){
            return activity.getSupportFragmentManager();
        }

        @Provides
        @HomeScope
        TrackView trackView(){
            return new TrackView();
        }

        @Provides
        @HomeScope
        MapView mapView(){
            return new MapView();
        }
    }

}