package matthew.shannon.jamfam.feature.access;

import matthew.shannon.jamfam.model.base.BaseView;

public interface AccessContract {

    public interface View extends BaseView{}
    public interface Presenter{
        void checkAccess();

        void unsubscribe();
    }
}
