package matthew.shannon.jamfam.service.flow;

import matthew.shannon.jamfam.model.data.Settings;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.data.User;

public interface FlowService {

    boolean checkServiceStatus();

    void goToSplashActivity();

    void goToWelcomeActivity();

    void goToAccessActivity();

    void goToSignupActivity();

    void goToLoginActivity();

    void goToOwnerProfile();

    void goToUserProfile(String ID);

    void goToSearchActivity();

    void goToMessageActivity();

    void goToHomeActivity();

    void goToAboutActivity();

    void goToSettingsActivity();

    void goToLogoutActivity();

    void goToEmailApp();

    void goToStore();

    void exitApp();

    void goToTrack(Track track);

    void goToApp();

    void controlTrack(int command);

    void sendTrackUpdate(Track track);

    void goToUser(User user);

    void addFriend(User user);

    void delFriend(User user);

    void delTrack(Track track);

    void updateUser(Settings settings);
}
