package matthew.shannon.jamfam.feature.welcome;

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
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.utils.GoogleAPI;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class WelcomeViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<WelcomeView> activityRule = new ActivityTestRule<>(WelcomeView.class, true, false);

    @Mock
    FlowService flow;

    @Mock
    GoogleAPI api;

    @Mock
    WelcomeComponent.Builder builder;

    private WelcomeComponent welcomeComponent = new WelcomeComponent() {
        @Override
        public void injectMembers(WelcomeView instance) {
            instance.presenter = new WelcomePresenter(api, flow, instance);
        }
    };

    @Before
    public void setUp() {
        when(builder.build()).thenReturn(welcomeComponent);
        when(builder.activityModule(any(WelcomeComponent.WelcomeModule.class))).thenReturn(builder);

        MockApp app = (MockApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.putActivityComponentBuilder(builder, WelcomeView.class);
    }

    @Test
    public void init() {
        activityRule.launchActivity(new Intent());
    }

}