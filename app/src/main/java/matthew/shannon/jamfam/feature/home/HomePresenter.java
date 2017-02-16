package matthew.shannon.jamfam.feature.home;

import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;

public class HomePresenter extends BasePresenter implements HomeContract.Presenter {
    private final HomeContract.View view;
    private final CacheService cache;

    public HomePresenter(HomeContract.View view, CacheService cache) {
        this.view = view;
        this.cache = cache;
    }

}
