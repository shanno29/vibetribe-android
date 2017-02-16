package matthew.shannon.jamfam.feature.Intro.welcome;

import com.google.android.gms.common.GoogleApiAvailability;
import dagger.Module;
import dagger.Provides;

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
    WelcomeContract.View view(){
        return activity;
    }

}
