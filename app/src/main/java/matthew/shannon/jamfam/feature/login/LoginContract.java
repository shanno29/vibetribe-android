package matthew.shannon.jamfam.feature.login;

import matthew.shannon.jamfam.model.base.BaseView;
import matthew.shannon.jamfam.model.data.User;

public class LoginContract {

    public interface View extends BaseView {
        void updateUI(User user, boolean checked);

        void toggleSpinner(boolean flag);
    }
    public interface Presenter {
        void login(User user);

        void getInitialCheckbox();

        void goToSignup();

        void setCheckBox(boolean b);

        void unsubscribe();
    }
}
