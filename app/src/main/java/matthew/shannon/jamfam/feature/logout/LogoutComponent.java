package matthew.shannon.jamfam.feature.logout;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.inject.activity.ActivityComponent;
import matthew.shannon.jamfam.inject.activity.ActivityComponentBuilder;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@LogoutComponent.LogoutScope
@Subcomponent(modules = LogoutComponent.LogoutModule.class)
public interface LogoutComponent extends ActivityComponent<LogoutView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<LogoutModule, LogoutComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface LogoutScope {}

    @Module
    class LogoutModule extends ActivityModule<LogoutView> {

        public LogoutModule(LogoutView activity) {
            super(activity);
        }

        @Provides
        @LogoutScope
        LogoutPresenter logoutPresenter(NetworkService network, CacheService cache, FlowService flow) {
            return new LogoutPresenter(activity, network, cache, flow);

        }

    }

}