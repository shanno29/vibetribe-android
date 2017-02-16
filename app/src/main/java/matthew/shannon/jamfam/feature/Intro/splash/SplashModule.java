package matthew.shannon.jamfam.feature.Intro.splash;


import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;

@Module
public class SplashModule {

    private SplashView activity;

    public SplashModule(SplashView activity) {
        this.activity = activity;
    }

    @Provides
    @SplashScope
    SplashContract.View view() {
        return this.activity;
    }

    @Provides
    @SplashScope
    SplashContract.Presenter presenter(SplashContract.View view, CacheService cache) {
        return new SplashPresenter(view, cache);

    }

}