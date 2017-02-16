package matthew.shannon.jamfam.feature.logout;

import matthew.shannon.jamfam.app.Utils;
import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.network.NetworkService;

public class LogoutPresenter extends BasePresenter implements LogoutContract.Presenter {
    private final LogoutContract.View view;
    private final NetworkService network;
    private final CacheService cache;

    public LogoutPresenter(LogoutContract.View view, CacheService cache, NetworkService network) {
        this.view = view;
        this.cache = cache;
        this.network = network;
    }

    @Override
    public void logoutUser() {
        add(network.logoutUser(cache.getOwner())
            .compose(Utils.applySchedulers())
            .subscribe(
                res -> view.exitApp(),
                e -> view.showToast("Error While Logging Out" + e)
            )
        );
    }

}
