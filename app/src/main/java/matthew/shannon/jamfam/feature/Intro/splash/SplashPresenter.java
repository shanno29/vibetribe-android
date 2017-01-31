package matthew.shannon.jamfam.feature.Intro.splash;

import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;
import matthew.shannon.jamfam.util.RxUtils;

public class SplashPresenter extends BasePresenter implements SplashContract.Presenter {
    public FlowService flow;
    private CacheService cache;

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
                    if (flag) {
                        if (!flow.checkServiceStatus()) flow.goToAccessActivity();
                        else flow.goToLoginActivity();
                    } else {
                        cache.setSkipIntro(true);
                        flow.goToWelcomeActivity();
                    }
                }
            ));
    }


}