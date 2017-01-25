package matthew.shannon.jamfam.feature.login;

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
public class LoginViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<LoginView> activityRule = new ActivityTestRule<>(LoginView.class, true, false);

    @Mock
    CacheService cache;

    @Mock
    FlowService flow;

    @Mock
    NetworkService network;

    @Mock
    LoginComponent.Builder builder;

    private LoginComponent loginComponent = new LoginComponent() {
        @Override
        public void injectMembers(LoginView instance) {
            instance.presenter = new LoginPresenter(instance, network, cache, flow);
        }
    };

    @Before
    public void setUp() {
        when(builder.build()).thenReturn(loginComponent);
        when(builder.activityModule(any(LoginComponent.LoginModule.class))).thenReturn(builder);

        MockApp app = (MockApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.putActivityComponentBuilder(builder, LoginView.class);
    }

    @Test
    public void init() {
        activityRule.launchActivity(new Intent());
    }

}