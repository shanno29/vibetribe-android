package matthew.shannon.jamfam.feature.home;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import co.mobiwise.materialintro.shape.Focus;
import co.mobiwise.materialintro.shape.FocusGravity;
import co.mobiwise.materialintro.view.MaterialIntroView;
import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.feature.home.map.MapView;
import matthew.shannon.jamfam.feature.home.track.TrackView;
import matthew.shannon.jamfam.service.cache.CacheService;

@Module
public class HomeModule {

    private HomeView activity;

    public HomeModule(HomeView activity) {
        this.activity = activity;
    }

    @Provides
    @HomeScope
    HomeContract.View homeView() {
        return this.activity;
    }

    @Provides
    @HomeScope
    HomeContract.Presenter homePresenter(HomeContract.View view, CacheService cache) {
        return new HomePresenter(view, cache);

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
    Animation viewPagerAnimation() {
        return AnimationUtils.loadAnimation(activity, R.anim.slide_up);
    }

    @Provides
    @HomeScope
    FragmentManager fragmentManager() {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @HomeScope
    TrackView trackView() {
        return new TrackView();
    }

    @Provides
    @HomeScope
    MapView mapView() {
        return new MapView();
    }
}