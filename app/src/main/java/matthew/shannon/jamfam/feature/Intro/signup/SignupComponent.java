package matthew.shannon.jamfam.feature.Intro.signup;


import dagger.Subcomponent;

@SignupScope
@Subcomponent(modules = SignupModule.class)
public interface SignupComponent {

    SignupView inject(SignupView activity);


}