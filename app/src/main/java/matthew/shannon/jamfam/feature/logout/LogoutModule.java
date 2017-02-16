package matthew.shannon.jamfam.feature.logout;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.network.NetworkService;

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
    LogoutContract.Presenter logoutPresenter(LogoutContract.View view, CacheService cache, NetworkService network) {
        return new LogoutPresenter(view, cache, network);

    }

}