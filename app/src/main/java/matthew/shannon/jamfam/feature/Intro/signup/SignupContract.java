package matthew.shannon.jamfam.feature.Intro.signup;

import matthew.shannon.jamfam.base.BaseView;
import matthew.shannon.jamfam.model.data.User;

public interface SignupContract {

    interface View extends BaseView {

        void toggleSpinner(boolean flag);
    }

    interface Presenter {

        void signup(User user);

        void goToAccess();

        void unsubscribe();
    }

}
