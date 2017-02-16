package matthew.shannon.jamfam.feature.Intro.signup;

import matthew.shannon.jamfam.base.BaseView;
import matthew.shannon.jamfam.model.User;

public interface SignupContract {

    interface View extends BaseView {

        void toggleSpinner(boolean flag);

        void goToAccess();
    }

    interface Presenter {

        void signup(User user);
        
        void unsubscribe();
    }

}
