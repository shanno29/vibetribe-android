package matthew.shannon.jamfam.feature.logout;

import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;

public class LogoutPresenter extends BasePresenter implements LogoutContract.Presenter {
    private final LogoutContract.View view;
    private final CacheService cache;
    private final FlowService flow;

    public LogoutPresenter(LogoutContract.View view, CacheService cache, FlowService flow) {
        this.view = view;
        this.cache = cache;
        this.flow = flow;
    }

    @Override
    public void logoutUser() {
//        add(network.logoutUser(cache.getOwner())
//            .compose(RxUtils.applySchedulers())
//            .subscribe(
//                res -> flow.exitApp(),
//                e -> view.showToast("Error While Logging Out" + e)
//            )
//        );
    }

}
