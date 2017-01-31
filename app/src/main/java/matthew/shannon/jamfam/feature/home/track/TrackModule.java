package matthew.shannon.jamfam.feature.home.track;

import co.mobiwise.materialintro.shape.Focus;
import co.mobiwise.materialintro.shape.FocusGravity;
import co.mobiwise.materialintro.view.MaterialIntroView;
import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@Module
public class TrackModule {

    private TrackView fragment;

    public TrackModule(TrackView fragment) {
       this.fragment = fragment;
    }

    @Provides
    @TrackScope
    TrackContract.View trackView(){
        return this.fragment;
    }

    @Provides
    @TrackScope
    TrackContract.Presenter provideTrackFragmentPresenter(NetworkService network, CacheService cache, BusService bus, TrackContract.View view) {
        return new TrackPresenter(network, cache, bus, view);
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