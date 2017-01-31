package matthew.shannon.jamfam.feature.home;

import dagger.Subcomponent;

@HomeScope
@Subcomponent(modules = HomeModule.class)
public interface HomeComponent {

    HomeView inject(HomeView activity);


}