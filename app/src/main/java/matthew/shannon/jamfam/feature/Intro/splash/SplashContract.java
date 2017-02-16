package matthew.shannon.jamfam.feature.Intro.splash;

public interface SplashContract {

    interface View {

        void goToLogin();

        void goToAccess();

        void goToWelcomeActivity();
    }

    interface Presenter {
        void getIntroSecondRun();

        void unsubscribe();
    }

}


