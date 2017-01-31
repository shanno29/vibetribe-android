package matthew.shannon.jamfam.feature.profile;

import matthew.shannon.jamfam.base.BaseView;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.model.User;

public interface ProfileContract {
    public interface View extends BaseView {

        void showIntroView();

        void refreshProfile(User user);
    }

    public interface Presenter {


        void loadUser(String ID);

        void goToTrack(Track track);

        void checkForSecondRun();

        void loadUpdateUser();

        void selectProfilePicture();

        void selectBannerPicture();

        void unsubscribe();
    }
}
