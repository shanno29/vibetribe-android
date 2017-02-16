package matthew.shannon.jamfam.feature.settings;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import matthew.shannon.jamfam.BuildConfig;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class SettingsViewTest {

    private SettingsView settingsView;

    @Before
    public void setUp() {
        settingsView = Robolectric.setupActivity(SettingsView.class);
    }

    @Test
    public void shouldStartNextActivityWhenButtonIsClicked() {
        settingsView.showToast("Hello World");
        settingsView.onDestroy();
    }



}
