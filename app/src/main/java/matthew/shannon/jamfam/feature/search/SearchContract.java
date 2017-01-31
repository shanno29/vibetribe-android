package matthew.shannon.jamfam.feature.search;

import matthew.shannon.jamfam.model.base.BaseView;

public interface SearchContract {
    public interface View extends BaseView{

    }
    public interface Presenter {


        void unsubscribe();
    }
}
