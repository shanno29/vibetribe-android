package matthew.shannon.jamfam.feature.settings;

import matthew.shannon.jamfam.feature.search.SearchView;
import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

public class SettingsPresenter extends BasePresenter {
    private final SettingsView view;
    private final NetworkService network;
    private final CacheService cache;
    private final FlowService flow;

    public SettingsPresenter(SettingsView view, NetworkService network, CacheService cache, FlowService flow) {
        this.view = view;
        this.network = network;
        this.cache = cache;
        this.flow = flow;
    }

}
