package matthew.shannon.jamfam.feature.Intro.splash;

import matthew.shannon.jamfam.app.Utils;
import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.service.cache.CacheService;

public class SplashPresenter extends BasePresenter implements SplashContract.Presenter {
    private final CacheService cache;
    private final SplashContract.View view;

    public SplashPresenter(SplashContract.View view, CacheService cache) {
        this.cache = cache;
        this.view = view;
    }

    @Override
    public void getIntroSecondRun() {
        add(cache.getSkipIntro()
            .compose(Utils.applySchedulers())
            .subscribe(
                flag -> {
                    if (flag) view.checkServiceStatus();
                    else {
                        cache.setSkipIntro(true);
                        view.goToWelcomeActivity();
                    }
                }
            ));
    }

}