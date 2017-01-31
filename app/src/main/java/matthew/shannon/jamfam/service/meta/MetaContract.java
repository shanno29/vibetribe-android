package matthew.shannon.jamfam.service.meta;

public interface MetaContract {
    public interface Presenter {
        void getLastLocation();

        void getLocationUpdate();

        void lookUpTrack();

        void trackUpdate(String title, String album, String artist);

        void unsubscribe();
    }
}