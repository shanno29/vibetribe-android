package matthew.shannon.jamfam.feature.settings;

import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;

public class SettingsPresenter extends BasePresenter implements SettingsContract.Presenter {
    private final SettingsContract.View view;
    private final CacheService cache;
    private final FlowService flow;

    public SettingsPresenter(SettingsContract.View view, CacheService cache, FlowService flow) {
        this.view = view;
        this.cache = cache;
        this.flow = flow;
    }

}
