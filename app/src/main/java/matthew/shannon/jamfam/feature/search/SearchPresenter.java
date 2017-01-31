package matthew.shannon.jamfam.feature.search;

import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

public class SearchPresenter extends BasePresenter implements SearchContract.Presenter{
    private final SearchContract.View view;
    private final NetworkService network;
    private final CacheService cache;
    private final FlowService flow;

    public SearchPresenter(SearchContract.View view, NetworkService network, CacheService cache, FlowService flow) {
        this.view = view;
        this.network = network;
        this.cache = cache;
        this.flow = flow;
    }

}
