package matthew.shannon.jamfam.feature.welcome;

import dagger.Subcomponent;

@WelcomeScope
@Subcomponent(modules = WelcomeModule.class)
public interface WelcomeComponent {


    WelcomeView inject(WelcomeView activity);


}

