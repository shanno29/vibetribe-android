package matthew.shannon.jamfam.feature.about;

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
public class AboutViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<AboutView> activityRule = new ActivityTestRule<>(AboutView.class, true, false);

    @Mock
    FlowService flow;

    @Mock
    RxActivityResult.Builder<AboutView> settings;

    @Mock
    AboutComponent.Builder builder;

    private AboutComponent aboutComponent = instance -> {
    };

    @Before
    public void setUp() {
        when(builder.build()).thenReturn(aboutComponent);
        when(builder.activityModule(any(AboutComponent.AboutModule.class))).thenReturn(builder);

        MockApp app = (MockApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.putActivityComponentBuilder(builder, AboutView.class);
    }

    @Test
    public void init() {
        activityRule.launchActivity(new Intent());
    }

}