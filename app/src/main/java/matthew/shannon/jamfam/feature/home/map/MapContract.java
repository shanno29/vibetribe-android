package matthew.shannon.jamfam.feature.home.map;

import java.util.List;

import matthew.shannon.jamfam.base.BaseView;
import matthew.shannon.jamfam.model.data.Track;

public interface MapContract {

    interface View extends BaseView {
        void addMarkers(List<Track> tracks);
    }

    interface Presenter {
        void unsubscribe();

        void getUserTracks();
    }
}
