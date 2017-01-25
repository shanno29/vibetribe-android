package matthew.shannon.jamfam.feature.settings;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import matthew.shannon.jamfam.MockApp;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class SettingsViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<SettingsView> activityRule = new ActivityTestRule<>(SettingsView.class, true, false);

    @Mock
    CacheService cache;

    @Mock
    FlowService flow;

    @Mock
    NetworkService network;

    @Mock
    SettingsComponent.Builder builder;

    private SettingsComponent settingsComponent = new SettingsComponent() {
        @Override
        public void injectMembers(SettingsView instance) {
            instance.presenter = new SettingsPresenter(instance, network, cache, flow);
        }
    };

    @Before
    public void setUp() {
        when(builder.build()).thenReturn(settingsComponent);
        when(builder.activityModule(any(SettingsComponent.SettingsModule.class))).thenReturn(builder);

        MockApp app = (MockApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.putActivityComponentBuilder(builder, SettingsView.class);
    }

    @Test
    public void init() {
        activityRule.launchActivity(new Intent());
    }

}