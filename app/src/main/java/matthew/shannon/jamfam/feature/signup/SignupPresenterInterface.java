package matthew.shannon.jamfam.feature.signup;

import matthew.shannon.jamfam.model.data.User;

public interface SignupPresenterInterface {

    void unsubscribe();

    void signup(User user);

    void goToAccess();
}
