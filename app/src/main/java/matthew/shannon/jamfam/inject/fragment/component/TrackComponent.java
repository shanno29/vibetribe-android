package matthew.shannon.jamfam.inject.fragment.component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import co.mobiwise.materialintro.shape.Focus;
import co.mobiwise.materialintro.shape.FocusGravity;
import co.mobiwise.materialintro.view.MaterialIntroView;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.presenter.fragment.TrackPresenter;
import matthew.shannon.jamfam.view.fragment.TrackView;

@TrackComponent.TrackScope
@Subcomponent(modules = TrackComponent.TrackModule.class)
public interface TrackComponent extends FragmentComponent<TrackView> {

    @Subcomponent.Builder
    interface Builder extends FragmentComponentBuilder<TrackModule, TrackComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface TrackScope {}

    @Module
    class TrackModule extends FragmentModule<TrackView> {

        public TrackModule(TrackView fragment) {
            super(fragment);
        }

        @Provides
        @TrackScope
        TrackView trackView(){
            return fragment;
        }

        @Provides
        @TrackScope
        TrackPresenter provideTrackFragmentPresenter(NetworkService network, CacheService cache, BusService bus) {
            return new TrackPresenter(network, cache, bus, fragment);
        }

        @Provides
        @TrackScope
        MaterialIntroView.Builder provideHomeTrackIntroView() {
            return new MaterialIntroView.Builder(fragment.getActivity())
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

    }

}
