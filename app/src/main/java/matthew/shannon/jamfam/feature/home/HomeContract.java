package matthew.shannon.jamfam.feature.home;


import matthew.shannon.jamfam.model.base.BaseView;

public interface HomeContract {

    public interface View extends BaseView {}
    public interface Presenter {
        void unsubscribe();
    }

}
