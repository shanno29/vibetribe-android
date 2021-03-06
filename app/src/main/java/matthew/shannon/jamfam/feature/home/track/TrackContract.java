package matthew.shannon.jamfam.feature.home.track;


import matthew.shannon.jamfam.base.BaseView;
import matthew.shannon.jamfam.model.Track;

public interface TrackContract {

    public interface View extends BaseView {
        void showIntroView();
    }

    public interface Presenter {
        void unsubscribe();

        void checkForSecondRun();

        void postTrack(Track track);

        void trackSelected(Track track);

        void appSelected();

        void controlUpdate(int command);
    }

}
