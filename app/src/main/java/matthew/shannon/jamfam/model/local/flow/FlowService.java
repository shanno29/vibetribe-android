package matthew.shannon.jamfam.model.local.flow;

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
}
