package matthew.shannon.jamfam.feature.splash;


import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;

@Module
public class SplashModule  {

    private SplashView activity;

    public SplashModule(SplashView activity) {
        this.activity = activity;
    }

    @Provides
    @SplashScope
    SplashContract.View splashview(){
        return this.activity;
    }

    @Provides
    @SplashScope
    SplashContract.Presenter splashPresenterInterface(CacheService cache, FlowService flow) {
        return new SplashPresenter(cache, flow);

    }

}