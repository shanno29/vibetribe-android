package matthew.shannon.jamfam.feature.home;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import matthew.shannon.jamfam.BuildConfig;


@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class HomeViewTest {
    private HomeView home;

    @Before
    public void setUp() {
        home = Robolectric.setupActivity(HomeView.class);
        home.presenter = () -> {};
    }

    @Test
    public void shouldStartNextActivityWhenButtonIsClicked() {
        home.showToast("Hello World");
        home.onDestroy();
    }



}
