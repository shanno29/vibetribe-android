package matthew.shannon.jamfam.feature.splash;

import dagger.Subcomponent;

@SplashScope
@Subcomponent(modules = SplashModule.class)
public interface SplashComponent {

    SplashView inject(SplashView activity);


}
