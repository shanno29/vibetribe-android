package matthew.shannon.jamfam.feature;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.feature.splash.SplashView;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 24)
public class SplashViewTest {


    public class MainActivityTest {
        private SplashView splashView;

        @Before
        public void setUp() throws Exception {
            splashView = Robolectric.setupActivity(SplashView.class);
        }

        @Test
        public void shouldInjectMockStringFactory() throws Exception {

        }

    }
}
