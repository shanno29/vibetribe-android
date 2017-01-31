package matthew.shannon.jamfam.feature.logout;

public interface LogoutContract {
    public interface View {

    }

    public interface Presenter {

        void logoutUser();

        void unsubscribe();
    }
}
