package matthew.shannon.jamfam.feature.splash;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import matthew.shannon.jamfam.MockApp;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SplashViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<SplashView> activityRule = new ActivityTestRule<>(SplashView.class, true, false);

    @Mock
    SplashComponent.Builder builder;

    private SplashComponent splashComponent = instance -> instance.presenter = new SplashPresenterInterface() {
        @Override
        public void getIntroSecondRun() {

        }

        @Override
        public void unsubscribe() {

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
        activityRule.getActivity().animationsFinished();

    }

}