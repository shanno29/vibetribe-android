package matthew.shannon.jamfam.feature.Intro.access;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.R;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class AccessViewTest {

    private AccessView accessView;

    @Before
    public void setUp() {
        accessView = Robolectric.setupActivity(AccessView.class);
        accessView.presenter = () -> {};
    }

    @Test
    public void accessViewTests() {
        accessView.findViewById(R.id.button_right).performClick();
        accessView.showToast("Hello World");
        accessView.onBackPressed();
    }

    @After
    public void tearDown() {
        accessView.onDestroy();
    }

}
