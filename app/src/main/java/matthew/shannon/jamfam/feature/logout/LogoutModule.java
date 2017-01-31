package matthew.shannon.jamfam.feature.logout;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@Module
public class LogoutModule {

    private final LogoutView activity;

    public LogoutModule(LogoutView activity) {
        this.activity = activity;
    }

    @Provides
    @LogoutScope
    LogoutContract.View logoutView() {
        return activity;
    }

    @Provides
    @LogoutScope
    LogoutContract.Presenter logoutPresenter(LogoutContract.View view, NetworkService network, CacheService cache, FlowService flow) {
        return new LogoutPresenter(view, network, cache, flow);

    }

}