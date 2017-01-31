package matthew.shannon.jamfam.feature.Intro.welcome;

import com.google.android.gms.common.GoogleApiAvailability;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.service.flow.FlowService;
import matthew.shannon.jamfam.util.GoogleAPI;

@Module
public class WelcomeModule {

    private WelcomeView activity;

    public WelcomeModule(WelcomeView activity) {
        this.activity = activity;
    }

    @Provides
    @WelcomeScope
    GoogleApiAvailability googleApiAvailability() {
        return GoogleApiAvailability.getInstance();

    }

    @Provides
    @WelcomeScope
    GoogleAPI googleAPI(GoogleApiAvailability api) {
        return new GoogleAPI(activity, api);

    }

    @Provides
    @WelcomeScope
    WelcomeContract.Presenter presenter(GoogleAPI api, FlowService flow) {
        return new WelcomePresenter(api, flow);

    }
}
