package matthew.shannon.jamfam.feature.Intro.login;

import matthew.shannon.jamfam.base.BaseView;
import matthew.shannon.jamfam.model.User;

public interface LoginContract {

    interface View extends BaseView {
        void updateUI(User user, boolean checked);

        void toggleSpinner(boolean flag);

        void goToHomeActivity();

        void goToStore();

        void goToSignup();
    }

    interface Presenter {
        void login(User user);

        void getInitialCheckbox();

        void setCheckBox(boolean b);

        void unsubscribe();
    }
}
