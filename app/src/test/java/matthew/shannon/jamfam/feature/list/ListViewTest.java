package matthew.shannon.jamfam.feature.list;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import java.util.ArrayList;
import java.util.List;
import edu.emory.mathcs.backport.java.util.Collections;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.model.Action;
import matthew.shannon.jamfam.model.Event;
import matthew.shannon.jamfam.model.FragType;
import matthew.shannon.jamfam.model.Settings;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.model.User;
import matthew.shannon.jamfam.util.FragmentUtils;
import matthew.shannon.jamfam.feature.test.TestFragmentActivity;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class ListViewTest {

    private TestFragmentActivity activity;
    private List<Object> list = new ArrayList<>();
    private User user = new User();
    private Track track = new Track();
    private Settings setting = new Settings("key", "value");

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(TestFragmentActivity.class);
        user.set_id("testID");
        track.set_id("testId");
        track.setOwner(user);
        list.add(user);
        list.add(track);
        list.add(setting);
        list.add(new Event());
    }

    @Test
    public void UserFriends(){
        ListView userFriends = ListView.newInstance("testID", FragType.USER_FRIENDS);
        FragmentUtils.startFragment(activity, userFriends);

        userFriends.onContent(Collections.emptyList());
        userFriends.onEvent(new Event(Action.REFRESH));
        userFriends.toggleSpinner(false);
        userFriends.onContent(list);
        FragmentUtils.endFragment(activity, userFriends);
    }

    @Test
    public void UserMatches(){
        ListView userMatches = ListView.newInstance("testID", FragType.USER_MATCHES);
        FragmentUtils.startFragment(activity, userMatches);
        userMatches.onContent(Collections.emptyList());
        userMatches.onEvent(new Event(Action.REFRESH));
        userMatches.toggleSpinner(false);
        userMatches.onContent(list);
        FragmentUtils.endFragment(activity, userMatches);
    }

    @Test
    public void UserTracks(){
        ListView userTracks = ListView.newInstance("testID", FragType.USER_TRACKS);
        FragmentUtils.startFragment(activity, userTracks);
        userTracks.onContent(Collections.emptyList());
        userTracks.onEvent(new Event(Action.REFRESH));
        userTracks.toggleSpinner(false);
        userTracks.onContent(list);
        FragmentUtils.endFragment(activity, userTracks);
    }

    @Test
    public void AllTracks(){
        ListView allTracks = ListView.newInstance("testID", FragType.ALL_TRACKS);
        FragmentUtils.startFragment(activity, allTracks);
        allTracks.onContent(Collections.emptyList());
        allTracks.onEvent(new Event(Action.QUERY_CHANGED, "testQuery"));
        allTracks.onEvent(new Event(Action.REFRESH));
        allTracks.toggleSpinner(false);
        allTracks.onContent(list);
        FragmentUtils.endFragment(activity, allTracks);
    }

    @Test
    public void Settings(){
        ListView settings = ListView.newInstance("testID", FragType.SETTINGS);
        FragmentUtils.startFragment(activity, settings);
        settings.onContent(Collections.emptyList());
        settings.onEvent(new Event(Action.REFRESH));
        settings.toggleSpinner(false);
        settings.onContent(list);
        FragmentUtils.endFragment(activity, settings);
    }

    @Test
    public void FriendsTracks(){
        ListView friendsTracks = ListView.newInstance("testID", FragType.FRIENDS_TRACKS);
        FragmentUtils.startFragment(activity, friendsTracks);
        friendsTracks.onContent(Collections.emptyList());
        friendsTracks.onEvent(new Event(Action.REFRESH));
        friendsTracks.toggleSpinner(false);
        friendsTracks.onContent(list);
        FragmentUtils.endFragment(activity, friendsTracks);
    }

    @Test
    public void AllUsers(){
        ListView allUsers = ListView.newInstance("testID", FragType.ALL_USERS);
        FragmentUtils.startFragment(activity, allUsers);
        allUsers.onContent(Collections.emptyList());
        allUsers.onEvent(new Event(Action.REFRESH));
        allUsers.toggleSpinner(false);
        allUsers.onContent(list);
        list.remove(user);
        allUsers.onContent(list);
        allUsers.onEvent(new Event(Action.GO_TO_USER, user));
        allUsers.onEvent(new Event(Action.ADD_FRIEND, user));
        allUsers.onEvent(new Event(Action.DEL_FRIEND, user));
        FragmentUtils.endFragment(activity, allUsers);
    }

    @Test
    public void SearchTracks(){
        ListView searchTracks = ListView.newInstance("testID", FragType.SEARCH_TRACKS);
        FragmentUtils.startFragment(activity, searchTracks);
        searchTracks.onContent(Collections.emptyList());
        searchTracks.onEvent(new Event(Action.QUERY_CHANGED, "testQuery"));
        searchTracks.onEvent(new Event(Action.REFRESH));
        searchTracks.toggleSpinner(false);
        searchTracks.onEvent(new Event(Action.ADD_TRACK, track));
        searchTracks.onEvent(new Event(Action.DEL_TRACK, track));
        searchTracks.onEvent(new Event(Action.GO_TO_USER, track));
        searchTracks.onEvent(new Event(Action.GO_TO_TRACK, track));
        searchTracks.onContent(list);
        FragmentUtils.endFragment(activity, searchTracks);
    }


}
