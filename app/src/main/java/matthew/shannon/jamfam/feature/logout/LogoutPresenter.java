package matthew.shannon.jamfam.feature.logout;

import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

public class LogoutPresenter extends BasePresenter implements LogoutContract.Presenter {
    private final LogoutContract.View view;
    private final NetworkService network;
    private final CacheService cache;
    private final FlowService flow;

    public LogoutPresenter(LogoutContract.View view, NetworkService network, CacheService cache, FlowService flow) {
        this.view = view;
        this.network = network;
        this.cache = cache;
        this.flow = flow;
    }

    @Override public void logoutUser() {
//        add(network.logoutUser(cache.getOwner())
//            .compose(RxUtils.applySchedulers())
//            .subscribe(
//                res -> flow.exitApp(),
//                e -> view.showToast("Error While Logging Out" + e)
//            )
//        );
    }

}
