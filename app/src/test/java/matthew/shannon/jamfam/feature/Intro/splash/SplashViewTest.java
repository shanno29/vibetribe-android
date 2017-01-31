package matthew.shannon.jamfam.feature.Intro.splash;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import matthew.shannon.jamfam.BuildConfig;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=21)
public class SplashViewTest {

    private SplashView splashView;

    @Before
    public void setUp() {
        splashView = Robolectric.setupActivity(SplashView.class);
    }

    @Test
    public void splashViewTest() {
        splashView.animationsFinished();
        splashView.onDestroy();
    }

}
