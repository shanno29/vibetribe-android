package matthew.shannon.jamfam.feature.search;

import matthew.shannon.jamfam.base.BaseView;

public interface SearchContract {
    public interface View extends BaseView {

    }

    public interface Presenter {


        void unsubscribe();
    }
}
