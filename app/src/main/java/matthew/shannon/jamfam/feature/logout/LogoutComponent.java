package matthew.shannon.jamfam.feature.logout;


import dagger.Subcomponent;

@LogoutScope
@Subcomponent(modules = LogoutModule.class)
public interface LogoutComponent {

    LogoutView inject(LogoutView activity);



}