package matthew.shannon.jamfam.feature.access;

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
import rx_activity_result.RxActivityResult;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class AccessViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<AccessView> activityRule = new ActivityTestRule<>(AccessView.class, true, false);

    @Mock
    FlowService flow;

    @Mock
    RxActivityResult.Builder<AccessView> settings;

    @Mock
    AccessComponent.Builder builder;

    private AccessComponent accessComponent = new AccessComponent() {
        @Override
        public void injectMembers(AccessView instance) {
            instance.presenter = new AccessPresenter(instance, flow, settings);
        }
    };

    @Before
    public void setUp() {
        when(builder.build()).thenReturn(accessComponent);
        when(builder.activityModule(any(AccessComponent.AccessModule.class))).thenReturn(builder);

        MockApp app = (MockApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.putActivityComponentBuilder(builder, AccessView.class);
    }

    @Test
    public void init() {
        activityRule.launchActivity(new Intent());
    }

}