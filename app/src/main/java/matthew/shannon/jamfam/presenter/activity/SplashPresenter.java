package matthew.shannon.jamfam.presenter.activity;

import android.util.Log;
import matthew.shannon.jamfam.presenter.BasePresenter;
import matthew.shannon.jamfam.view.utils.RxUtils;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.local.cache.CacheService;

public class SplashPresenter extends BasePresenter {
    private final CacheService cache;
    private final FlowService flow;

    public SplashPresenter(CacheService cache, FlowService flow) {
        this.cache = cache;
        this.flow = flow;
    }

    public void getIntroSecondRun() {
        add(cache.getSkipIntro()
            .compose(RxUtils.applySchedulers())
            .subscribe(
                flag -> {
                    if(flag) {
                        if(!flow.checkServiceStatus()) flow.goToAccessActivity();
                        else flow.goToLoginActivity();
                    }
                    else {
                        cache.setSkipIntro(true);
                        flow.goToWelcomeActivity();
                    }
                },
                error -> Log.e("VIBETRIBE", "getIntroSecondRun: ", error))
        );
    }

}