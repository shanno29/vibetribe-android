package matthew.shannon.jamfam.feature.logout;

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
public class LogoutViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<LogoutView> activityRule = new ActivityTestRule<>(LogoutView.class, true, false);

    @Mock
    CacheService cache;

    @Mock
    FlowService flow;

    @Mock
    NetworkService network;

    @Mock
    LogoutComponent.Builder builder;

    private LogoutComponent logoutComponent = new LogoutComponent() {
        @Override
        public void injectMembers(LogoutView instance) {
            instance.presenter = new LogoutPresenter(instance, network, cache, flow);
        }
    };

    @Before
    public void setUp() {
        when(builder.build()).thenReturn(logoutComponent);
        when(builder.activityModule(any(LogoutComponent.LogoutModule.class))).thenReturn(builder);

        MockApp app = (MockApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.putActivityComponentBuilder(builder, LogoutView.class);
    }

    @Test
    public void init() {
        activityRule.launchActivity(new Intent());

    }

}