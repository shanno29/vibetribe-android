package matthew.shannon.jamfam.feature.Intro.access;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.service.flow.FlowService;
import rx_activity_result.RxActivityResult;

@Module
public class AccessModule {

    private AccessView activity;

    public AccessModule(AccessView activity) {
        this.activity = activity;
    }

    @Provides
    @AccessScope
    AccessContract.View accessView() {
        return this.activity;
    }

    @Provides
    @AccessScope
    RxActivityResult.Builder<AccessView> settingsObservable() {
        return RxActivityResult.on(activity);
    }


    @Provides
    @AccessScope
    AccessContract.Presenter accessPresenter(AccessContract.View view, FlowService flow, RxActivityResult.Builder<AccessView> settings) {
        return new AccessPresenter(view, flow, settings);
    }
}