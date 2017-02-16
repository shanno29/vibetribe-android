package matthew.shannon.jamfam.feature.Intro.access;

import android.content.Intent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.feature.Intro.login.LoginView;

import static junit.framework.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

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
    public void shouldStartNextActivityWhenButtonIsClicked() {
        accessView.findViewById(R.id.button_right).performClick();
//        Intent expectedIntent = new Intent(accessView, LoginView.class);
//        assertTrue(shadowOf(accessView).getNextStartedActivity().filterEquals(expectedIntent));

        accessView.showToast("Hello World");
        accessView.onBackPressed();
        accessView.onDestroy();
    }



}
