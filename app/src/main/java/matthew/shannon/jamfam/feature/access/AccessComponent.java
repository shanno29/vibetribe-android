package matthew.shannon.jamfam.feature.access;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.inject.activity.ActivityComponent;
import matthew.shannon.jamfam.inject.activity.ActivityComponentBuilder;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import rx_activity_result.RxActivityResult;

@AccessComponent.AccessScope
@Subcomponent(modules = AccessComponent.AccessModule.class)
public interface AccessComponent extends ActivityComponent<AccessView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<AccessModule, AccessComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface AccessScope {}

    @Module
    class AccessModule extends ActivityModule<AccessView> {

        public AccessModule(AccessView activity) {
            super(activity);
        }

        @Provides
        @AccessScope
        RxActivityResult.Builder<AccessView> settingsObservable(){
            return RxActivityResult.on(activity);
        }

        @Provides
        @AccessScope
        AccessPresenterInterface accessPresenter(FlowService flow, RxActivityResult.Builder<AccessView> settings) {
            return new AccessPresenter(activity, flow, settings);
        }
    }

}
