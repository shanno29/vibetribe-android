package matthew.shannon.jamfam.feature.home;

import org.junit.After;
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
    private HomeView homeView;

    @Before
    public void setUp() {
        homeView = Robolectric.setupActivity(HomeView.class);
        homeView.presenter = () -> {};
    }

    @Test
    public void homeViewTests() {
        homeView.showToast("Hello World");
    }

    @After
    public void tearDown() {
        homeView.onDestroy();
    }


}
