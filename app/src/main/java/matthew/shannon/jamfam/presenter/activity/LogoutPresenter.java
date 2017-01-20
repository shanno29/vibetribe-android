package matthew.shannon.jamfam.presenter.activity;

import javax.inject.Inject;

import matthew.shannon.jamfam.view.activity.LogoutView;
import matthew.shannon.jamfam.presenter.BasePresenter;
import matthew.shannon.jamfam.view.utils.RxUtils;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

public class LogoutPresenter extends BasePresenter {
    private final LogoutView view;
    private final NetworkService network;
    private final CacheService cache;
    private final FlowService flow;

    public LogoutPresenter(LogoutView view, NetworkService network, CacheService cache, FlowService flow) {
        this.view = view;
        this.network = network;
        this.cache = cache;
        this.flow = flow;
    }

    public void logoutUser() {
        add(network.logoutUser(cache.getOwner())
            .compose(RxUtils.applySchedulers())
            .subscribe(
                res -> flow.exitApp(),
                e -> view.showToast("Error While Logging Out" + e)
            )
        );
    }

}
