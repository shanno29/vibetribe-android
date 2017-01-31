package matthew.shannon.jamfam.feature.Intro.login;

import dagger.Subcomponent;

@LoginScope
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {

    LoginView inject(LoginView activity);

}
