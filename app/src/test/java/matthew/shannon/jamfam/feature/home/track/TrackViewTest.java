package matthew.shannon.jamfam.feature.home.track;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.feature.test.TestFragmentActivity;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class TrackViewTest {

    private TestFragmentActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(TestFragmentActivity.class);
    }

    public void startFragment(FragmentActivity parentActivity, Fragment fragment) {
        FragmentManager fragmentManager = parentActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragment, null);
        fragmentTransaction.commit();
    }

    @Test
    public void whenTheFragmentViewIsCreatedThenTheViewShouldBePopulated() {
        TrackView trackView = new TrackView();
        startFragment(activity, trackView);

        trackView.showToast("Hello World");
        trackView.getView().findViewById(R.id.open_app).performClick();
        trackView.getView().findViewById(R.id.album_art).performClick();
        trackView.getView().findViewById(R.id.prev_track).performClick();
        trackView.getView().findViewById(R.id.next_track).performClick();
        trackView.getView().findViewById(R.id.post_track).performClick();

        Track a = new Track();
        trackView.trackUpdate(a);

        a.setTitle("testTitle");
        trackView.trackUpdate(a);


    }

    @After
    public void tearDown() {
        activity.onDestroy();
    }

}