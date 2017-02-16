package matthew.shannon.jamfam.feature.list;

import java.util.List;

import matthew.shannon.jamfam.base.BaseView;
import matthew.shannon.jamfam.model.Track;

public interface ListContract {
    interface View extends BaseView {

        void onQuery(List<?> items, String string);

        void onContent(List<?> items);

        void onRefresh();

        void toggleSpinner(boolean flag);
    }

    interface Presenter {
        void unsubscribe();

        void loadSettings(String Id);

        void loadAllTracks();

        void loadFriendsTracks(String Id);

        void loadUserTracks(String Id);

        void loadAllUsers();

        void loadUserFriends(String Id);

        void loadUserMatches(String Id);

        void searchTracks(String title, String artist, String limit);

        void loadAddTrack(String Id, Track track);

        void loadDelTrack(String trackId);

        void loadAddFriend(String userId, String userTwoId);

        void loadDelFriend(String friendId);

        List<?> localQuery(List<?> items, String query);

        void goToUser(String id);
    }

}
