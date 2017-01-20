package matthew.shannon.jamfam.model.local.bus;


import matthew.shannon.jamfam.model.data.Settings;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.data.User;

public interface BusService {

    void goToTrack(Track track);

    void goToApp();

    void controlTrack(int command);

    void sendTrackUpdate(Track track);

    void goToUser(User user);

    void addFriend(User user);

    void delFriend(User user);

    void delTrack(Track track);

    void updateUser(Settings settings);
}
