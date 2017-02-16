package matthew.shannon.jamfam.feature.Intro.welcome;

import android.content.Intent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.feature.Intro.signup.SignupView;
import static junit.framework.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class WelcomeViewTest {

    private WelcomeView welcomeView;

    @Before
    public void setUp() {
        welcomeView = Robolectric.setupActivity(WelcomeView.class);
    }

    @Test
    public void shouldStartNextActivityWhenButtonIsClicked() {
        welcomeView.findViewById(R.id.button_right).performClick();
        Intent expectedIntent = new Intent(welcomeView, SignupView.class);
        assertTrue(shadowOf(welcomeView).getNextStartedActivity().filterEquals(expectedIntent));
        welcomeView.onBackPressed();
        welcomeView.onDestroy();
    }

}
