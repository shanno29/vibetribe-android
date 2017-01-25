package matthew.shannon.jamfam.feature.splash;

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
public class SplashViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<SplashView> activityRule = new ActivityTestRule<>(SplashView.class, true, false);

    @Mock
    CacheService cache;

    @Mock
    FlowService flow;

    @Mock
    NetworkService network;

    @Mock
    SplashComponent.Builder builder;

    private SplashComponent splashComponent = new SplashComponent() {
        @Override
        public void injectMembers(SplashView instance) {
            instance.presenter = new SplashPresenter(cache, flow);
        }
    };

    @Before
    public void setUp() {
        when(builder.build()).thenReturn(splashComponent);
        when(builder.activityModule(any(SplashComponent.SplashModule.class))).thenReturn(builder);

        MockApp app = (MockApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.putActivityComponentBuilder(builder, SplashView.class);
    }

    @Test
    public void init() {
        activityRule.launchActivity(new Intent());
    }

}