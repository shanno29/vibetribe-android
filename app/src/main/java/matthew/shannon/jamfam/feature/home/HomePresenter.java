package matthew.shannon.jamfam.feature.home;

import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;

public class HomePresenter extends BasePresenter implements HomeContract.Presenter {
    private final HomeView view;
    private final CacheService cache;
    private final FlowService flow;

    public HomePresenter(HomeView view, CacheService cache, FlowService flow) {
        this.view = view;
        this.cache = cache;
        this.flow = flow;
    }

}
