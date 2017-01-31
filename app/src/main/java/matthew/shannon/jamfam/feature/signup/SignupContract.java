package matthew.shannon.jamfam.feature.signup;

import matthew.shannon.jamfam.model.base.BaseView;
import matthew.shannon.jamfam.model.data.User;

public class SignupContract {

    public interface View extends BaseView {

        void toggleSpinner(boolean flag);
    }
    public interface Presenter {

        void signup(User user);

        void goToAccess();

        void unsubscribe();
    }

}
