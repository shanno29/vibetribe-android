package matthew.shannon.jamfam.feature.meta;

public interface MetaContract {
    public interface Presenter{
        void getLastLocation();

        void getLocationUpdate();

        void lookUpTrack();

        void trackUpdate(String title, String album, String artist);

        void unsubscribe();
    }
}