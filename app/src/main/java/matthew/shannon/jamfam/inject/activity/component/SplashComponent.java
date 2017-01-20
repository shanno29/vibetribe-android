package matthew.shannon.jamfam.inject.activity.component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.presenter.activity.SplashPresenter;
import matthew.shannon.jamfam.view.activity.SplashView;

@SplashComponent.SplashScope
@Subcomponent(modules = SplashComponent.SplashModule.class)
public interface SplashComponent extends ActivityComponent<SplashView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<SplashModule, SplashComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface SplashScope {}

    @Module
    class SplashModule extends ActivityModule<SplashView> {
        public SplashModule(SplashView activity) {
            super(activity);
        }

        @Provides
        @SplashScope
        SplashPresenter splashPresenter(CacheService cache, FlowService flow) {
            return new SplashPresenter(cache, flow);

        }
    }
}
