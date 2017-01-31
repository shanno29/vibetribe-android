package matthew.shannon.jamfam.list;

import java.util.List;

import matthew.shannon.jamfam.model.base.BaseView;
import matthew.shannon.jamfam.model.data.Track;

public interface ListContract {
    public interface View extends BaseView {
        void onQuery(String query);

        void onSuccess(List<?> items);

        void onContent(List<?> items);

        void onEmpty();

        void onRefresh();
    }
    public interface Presenter {
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

        void loadDelFriend(String userId, String userTwoId);

        List<?> localQuery(List<?> items, String query);

        abstract void goToUser(String id);
    }

}
