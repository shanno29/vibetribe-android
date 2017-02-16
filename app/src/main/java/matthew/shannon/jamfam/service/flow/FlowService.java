package matthew.shannon.jamfam.service.flow;

import matthew.shannon.jamfam.model.Settings;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.model.User;

public interface FlowService {

    boolean serviceStatus();

    void startService();

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
