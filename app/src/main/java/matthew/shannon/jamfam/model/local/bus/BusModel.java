package matthew.shannon.jamfam.model.local.bus;

import com.hwangjr.rxbus.Bus;

import matthew.shannon.jamfam.model.data.Settings;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.view.utils.constant.Action;
import matthew.shannon.jamfam.model.data.Event;
import matthew.shannon.jamfam.model.data.Track;

public class BusModel implements BusService {
    private final Bus bus;

    public BusModel(Bus bus) {
        this.bus = bus;

    }

    @Override
    public void goToTrack(Track track) {
        bus.post(new Event(Action.GO_TO_TRACK, track));

    }

    @Override
    public void goToApp() {
        bus.post(new Event(Action.GO_TO_APP));

    }

    @Override
    public void sendTrackUpdate(Track track) {
        bus.post(new Event(Action.TRACK_UPDATE, track));

    }

    @Override
    public void goToUser(User user) {
        bus.post(new Event(Action.GO_TO_USER, user));

    }

    @Override
    public void addFriend(User user) {
        bus.post(new Event(Action.ADD_FRIEND, user));

    }

    @Override
    public void delFriend(User user) {
        bus.post(new Event(Action.DEL_FRIEND, user));

    }

    @Override
    public void delTrack(Track track) {
        bus.post(new Event(Action.DEL_TRACK, track));

    }

    @Override
    public void updateUser(Settings settings) {
        bus.post(new Event(Action.UPDATE_USER, settings));
    }

    @Override
    public void controlTrack(int command) {
        bus.post(new Event(Action.CONTROL_TRACK, command));

    }

}