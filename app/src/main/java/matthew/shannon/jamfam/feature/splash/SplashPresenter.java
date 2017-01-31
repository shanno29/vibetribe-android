package matthew.shannon.jamfam.feature.splash;

import android.util.Log;

import javax.inject.Inject;

import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.utils.RxUtils;

public class SplashPresenter extends BasePresenter implements SplashContract.Presenter {
    private CacheService cache;
    public FlowService flow;

    public SplashPresenter(CacheService cache, FlowService flow) {
        this.cache = cache;
        this.flow = flow;
    }

    @Override
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