package matthew.shannon.jamfam.feature.list;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;
import java.util.ArrayList;
import java.util.List;
import edu.emory.mathcs.backport.java.util.Collections;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.model.Action;
import matthew.shannon.jamfam.model.Event;
import matthew.shannon.jamfam.model.FragType;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.model.User;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class ListViewTest {

    private List<Object> list = new ArrayList<>();
    private User user = new User();
    private Track track = new Track();

    @Before
    public void setUp() {
        user.set_id("testID");
        track.set_id("testId");
        track.setOwner(user);
        list.add(user);
        list.add(track);
    }

    @Test
    public void UserFriends(){
        ListView userFriends = ListView.newInstance("testID", FragType.USER_FRIENDS);
        SupportFragmentTestUtil.startVisibleFragment(userFriends);
        userFriends.onContent(Collections.emptyList());
        userFriends.onEvent(new Event(Action.REFRESH));
        userFriends.toggleSpinner(false);
        userFriends.onContent(list);
    }

    @Test
    public void UserMatches(){
        ListView userMatches = ListView.newInstance("testID", FragType.USER_MATCHES);
        SupportFragmentTestUtil.startVisibleFragment(userMatches);
        userMatches.onContent(Collections.emptyList());
        userMatches.onEvent(new Event(Action.REFRESH));
        userMatches.toggleSpinner(false);
        userMatches.onContent(list);
    }

    @Test
    public void UserTracks(){
        ListView userTracks = ListView.newInstance("testID", FragType.USER_TRACKS);
        SupportFragmentTestUtil.startVisibleFragment(userTracks);
        userTracks.onContent(Collections.emptyList());
        userTracks.onEvent(new Event(Action.REFRESH));
        userTracks.toggleSpinner(false);
        userTracks.onContent(list);
    }

    @Test
    public void AllTracks(){
        ListView allTracks = ListView.newInstance("testID", FragType.ALL_TRACKS);
        SupportFragmentTestUtil.startVisibleFragment(allTracks);
        allTracks.onContent(Collections.emptyList());
        allTracks.onEvent(new Event(Action.QUERY_CHANGED, "testQuery"));
        allTracks.onEvent(new Event(Action.REFRESH));
        allTracks.toggleSpinner(false);
        allTracks.onContent(list);
    }

    @Test
    public void FriendsTracks(){
        ListView friendsTracks = ListView.newInstance("testID", FragType.FRIENDS_TRACKS);
        SupportFragmentTestUtil.startVisibleFragment(friendsTracks);
        friendsTracks.onContent(Collections.emptyList());
        friendsTracks.onEvent(new Event(Action.REFRESH));
        friendsTracks.toggleSpinner(false);
        friendsTracks.onContent(list);
    }

    @Test
    public void AllUsers(){
        ListView allUsers = ListView.newInstance("testID", FragType.ALL_USERS);
        SupportFragmentTestUtil.startVisibleFragment(allUsers);
        allUsers.onContent(Collections.emptyList());
        allUsers.onEvent(new Event(Action.REFRESH));
        allUsers.toggleSpinner(false);
        allUsers.onContent(list);
        list.remove(user);
        allUsers.onContent(list);
        allUsers.onEvent(new Event(Action.GO_TO_USER, user));
        allUsers.onEvent(new Event(Action.ADD_FRIEND, user));
        allUsers.onEvent(new Event(Action.DEL_FRIEND, user));
    }

    @Test
    public void SearchTracks(){
        ListView searchTracks = ListView.newInstance("testID", FragType.SEARCH_TRACKS);
        SupportFragmentTestUtil.startVisibleFragment(searchTracks);
        searchTracks.onContent(Collections.emptyList());
        searchTracks.onEvent(new Event(Action.REFRESH));
        searchTracks.onEvent(new Event(Action.ADD_TRACK, track));
        searchTracks.onEvent(new Event(Action.DEL_TRACK, track));
        searchTracks.onEvent(new Event(Action.GO_TO_USER, track));
        searchTracks.onEvent(new Event(Action.GO_TO_TRACK, track));
        searchTracks.onEvent(new Event(Action.QUERY_CHANGED, "testQuery"));
        searchTracks.toggleSpinner(false);
        searchTracks.onContent(list);
    }


}
