package matthew.shannon.jamfam.feature.about;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenuItem;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.R;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class AboutViewTest {

    private AboutView aboutView;

    @Before
    public void setUp() {
        aboutView = Robolectric.setupActivity(AboutView.class);
    }

    @Test
    public void shouldStartNextActivityWhenButtonIsClicked() {

        aboutView.onOptionsItemSelected(new RoboMenuItem(R.id.settings));
        aboutView.onBackPressed();

        aboutView.onOptionsItemSelected(new RoboMenuItem(R.id.message));
        aboutView.onBackPressed();

        aboutView.onOptionsItemSelected(new RoboMenuItem(R.id.logout));
        aboutView.onBackPressed();

        aboutView.onOptionsItemSelected(new RoboMenuItem(R.id.profile));
        aboutView.onBackPressed();

        aboutView.onOptionsItemSelected(new RoboMenuItem(R.id.search));
        aboutView.onBackPressed();

        aboutView.onOptionsItemSelected(new RoboMenuItem(R.id.home));

        aboutView.onOptionsItemSelected(new RoboMenuItem(R.id.contact));
        aboutView.onBackPressed();

        aboutView.onOptionsItemSelected(new RoboMenuItem(R.id.about));
        aboutView.onBackPressed();
    }

    @After
    public void tearDown() {
        aboutView.onDestroy();
    }


}
