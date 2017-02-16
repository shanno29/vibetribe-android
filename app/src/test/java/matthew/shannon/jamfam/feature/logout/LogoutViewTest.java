package matthew.shannon.jamfam.feature.logout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import matthew.shannon.jamfam.BuildConfig;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class LogoutViewTest {

    private LogoutView logoutView;

    @Before
    public void setUp() {
        logoutView = Robolectric.setupActivity(LogoutView.class);
        logoutView.presenter = new LogoutContract.Presenter() {
            @Override
            public void logoutUser() {

            }

            @Override
            public void unsubscribe() {

            }
        };
    }

    @Test
    public void shouldStartNextActivityWhenButtonIsClicked() {
        logoutView.showToast("test");
        logoutView.animationsFinished();
        logoutView.exitApp();
        logoutView.onDestroy();
    }



}
