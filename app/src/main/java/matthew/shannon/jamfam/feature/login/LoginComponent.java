package matthew.shannon.jamfam.feature.login;

import dagger.Subcomponent;

@LoginScope
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {

    LoginView inject(LoginView activity);

}
