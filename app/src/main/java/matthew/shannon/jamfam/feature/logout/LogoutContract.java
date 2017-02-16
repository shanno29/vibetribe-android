package matthew.shannon.jamfam.feature.logout;

import matthew.shannon.jamfam.base.BaseView;

public interface LogoutContract extends BaseView {
    interface View extends BaseView {

        void exitApp();

        void showToast(String s);
    }

     interface Presenter {

        void logoutUser();

        void unsubscribe();
    }
}
