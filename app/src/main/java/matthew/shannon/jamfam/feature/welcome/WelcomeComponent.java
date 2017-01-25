package matthew.shannon.jamfam.feature.welcome;

import com.google.android.gms.common.GoogleApiAvailability;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.inject.activity.ActivityComponent;
import matthew.shannon.jamfam.inject.activity.ActivityComponentBuilder;
import matthew.shannon.jamfam.utils.GoogleAPI;
import matthew.shannon.jamfam.model.local.flow.FlowService;

@WelcomeComponent.WelcomeScope
@Subcomponent(modules = WelcomeComponent.WelcomeModule.class)
public interface WelcomeComponent extends ActivityComponent<WelcomeView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<WelcomeModule, WelcomeComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface WelcomeScope {}

    @Module
    class WelcomeModule extends ActivityModule<WelcomeView> {

        public WelcomeModule(WelcomeView activity) {
            super(activity);
        }

        @Provides
        @WelcomeScope
        GoogleApiAvailability googleApiAvailability(){
            return GoogleApiAvailability.getInstance();

        }

        @Provides
        @WelcomeScope
        GoogleAPI googleAPI(GoogleApiAvailability api){
            return new GoogleAPI(activity, api);

        }

        @Provides
        @WelcomeScope
        WelcomePresenter presenter(GoogleAPI api, FlowService flow) {
            return new WelcomePresenter(api, flow, activity);

        }
    }
}

