package matthew.shannon.jamfam.feature.access;

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
import matthew.shannon.jamfam.R;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccessViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<AccessView> activityRule = new ActivityTestRule<>(AccessView.class, true, false);

    @Mock
    AccessComponent.Builder builder;

    private AccessComponent accessComponent = instance -> instance.presenter = new AccessPresenterInterface() {


        @Override
        public void checkAccess() {

        }

        @Override
        public void unsubscribe() {

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
        onView(withId(R.id.button_right)).perform(click());

    }

}