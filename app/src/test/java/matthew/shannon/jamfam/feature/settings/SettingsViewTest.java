package matthew.shannon.jamfam.feature.settings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.feature.list.ListContract;
import matthew.shannon.jamfam.feature.list.ListView;
import matthew.shannon.jamfam.model.Action;
import matthew.shannon.jamfam.model.Event;
import matthew.shannon.jamfam.model.FragType;
import matthew.shannon.jamfam.model.Track;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class SettingsViewTest {
    private List<Object> list = new ArrayList<>();

    private SettingsView settingsView;

    @Before
    public void setUp() {
        settingsView = Robolectric.setupActivity(SettingsView.class);

    }

    @Test
    public void settingsViewTest() {
        settingsView.showToast("Hello World");
    }


    @Test
    public void Settings(){
        ListView settings = ListView.newInstance("testID", FragType.SETTINGS);
        SupportFragmentTestUtil.startVisibleFragment(settings);
        settings.onContent(Collections.emptyList());
        settings.onEvent(new Event(Action.REFRESH));
        settings.toggleSpinner(false);
        settings.onContent(list);
    }

    @After
    public void tearDown(){
        settingsView.onDestroy();
    }
}
