package matthew.shannon.jamfam.feature.Intro.welcome;

public interface WelcomeContract {

    interface View {}

    interface Presenter {

        void unsubscribe();

        void checkGoogleApi();

        void gotoSignup();
    }

}


