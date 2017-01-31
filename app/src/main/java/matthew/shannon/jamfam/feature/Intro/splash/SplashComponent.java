package matthew.shannon.jamfam.feature.Intro.splash;

import dagger.Subcomponent;

@SplashScope
@Subcomponent(modules = SplashModule.class)
public interface SplashComponent {

    SplashView inject(SplashView activity);


}
