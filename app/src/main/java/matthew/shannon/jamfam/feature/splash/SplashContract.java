package matthew.shannon.jamfam.feature.splash;

import matthew.shannon.jamfam.model.base.BaseView;

public class SplashContract {

        public interface View extends BaseView {

        }
        public interface Presenter {
            void getIntroSecondRun();

            void unsubscribe();
        }

}


