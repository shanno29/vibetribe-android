package matthew.shannon.jamfam.inject.activity.component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.presenter.activity.LogoutPresenter;
import matthew.shannon.jamfam.view.activity.LogoutView;

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