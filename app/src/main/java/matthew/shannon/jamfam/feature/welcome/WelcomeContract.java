package matthew.shannon.jamfam.feature.welcome;

import matthew.shannon.jamfam.model.base.BaseView;

public class WelcomeContract {

        public interface View extends BaseView {

        }
        public interface Presenter {

            void unsubscribe();

            void checkGoogleApi();

            void gotoSignup();
        }

}


