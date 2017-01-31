package matthew.shannon.jamfam.feature.settings;

import matthew.shannon.jamfam.model.base.BaseView;

public interface SettingsContract {
    public interface View extends BaseView{

    }
    public interface Presenter {


        void unsubscribe();
    }
}
