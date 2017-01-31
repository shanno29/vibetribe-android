package matthew.shannon.jamfam.feature.settings;

import matthew.shannon.jamfam.base.BaseView;

public interface SettingsContract {
    interface View extends BaseView {

    }

    interface Presenter {

        void unsubscribe();
    }
}
