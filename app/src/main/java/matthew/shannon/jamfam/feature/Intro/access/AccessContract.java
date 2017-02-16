package matthew.shannon.jamfam.feature.Intro.access;

import matthew.shannon.jamfam.base.BaseView;

public interface AccessContract {

    interface View extends BaseView {
        void checkAccess();
    }

    interface Presenter {

        void unsubscribe();
    }
}
