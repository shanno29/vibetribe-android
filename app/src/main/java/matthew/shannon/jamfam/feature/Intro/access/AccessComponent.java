package matthew.shannon.jamfam.feature.Intro.access;

import dagger.Subcomponent;

@AccessScope
@Subcomponent(modules = AccessModule.class)
public interface AccessComponent {

    AccessView inject(AccessView splashActivity);

}
