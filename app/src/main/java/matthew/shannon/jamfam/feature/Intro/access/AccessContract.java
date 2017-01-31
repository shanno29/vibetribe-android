package matthew.shannon.jamfam.feature.Intro.access;

import matthew.shannon.jamfam.base.BaseView;

public interface AccessContract {

    public interface View extends BaseView {
    }

    public interface Presenter {
        void checkAccess();

        void unsubscribe();
    }
}
