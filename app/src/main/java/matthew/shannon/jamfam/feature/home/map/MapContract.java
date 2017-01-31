package matthew.shannon.jamfam.feature.home.map;

import java.util.List;

import matthew.shannon.jamfam.model.base.BaseView;
import matthew.shannon.jamfam.model.data.Track;

public class MapContract {

    public interface View extends BaseView {
        void addMarkers(List<Track> tracks);
    }
    public interface Presenter {
        void unsubscribe();

        void getUserTracks();
    }
}
