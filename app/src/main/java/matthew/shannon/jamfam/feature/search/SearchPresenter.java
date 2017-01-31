package matthew.shannon.jamfam.feature.search;

import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;

public class SearchPresenter extends BasePresenter implements SearchContract.Presenter {
    private final SearchContract.View view;
    private final CacheService cache;
    private final FlowService flow;

    public SearchPresenter(SearchContract.View view, CacheService cache, FlowService flow) {
        this.view = view;
        this.cache = cache;
        this.flow = flow;
    }

}
