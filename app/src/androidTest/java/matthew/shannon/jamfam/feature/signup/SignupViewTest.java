package matthew.shannon.jamfam.feature.signup;

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
public class SignupViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<SignupView> activityRule = new ActivityTestRule<>(SignupView.class, true, false);

    @Mock
    CacheService cache;

    @Mock
    FlowService flow;

    @Mock
    NetworkService network;

    @Mock
    SignupComponent.Builder builder;

    private SignupComponent signupComponent = new SignupComponent() {
        @Override
        public void injectMembers(SignupView instance) {
            instance.presenter = new SignupPresenter(instance, network, flow);
        }
    };

    @Before
    public void setUp() {
        when(builder.build()).thenReturn(signupComponent);
        when(builder.activityModule(any(SignupComponent.SignupModule.class))).thenReturn(builder);

        MockApp app = (MockApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.putActivityComponentBuilder(builder, SignupView.class);
    }

    @Test
    public void init() {
        activityRule.launchActivity(new Intent());
    }

}