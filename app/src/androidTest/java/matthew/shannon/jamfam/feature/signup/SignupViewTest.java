package matthew.shannon.jamfam.feature.signup;

import android.app.ProgressDialog;
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
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.model.data.User;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class SignupViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<SignupView> activityRule = new ActivityTestRule<>(SignupView.class, true, false);

    @Mock
    SignupComponent.Builder builder;

    private SignupComponent signupComponent = instance -> {
        instance.presenter = new SignupPresenterInterface() {
            @Override
            public void unsubscribe() {

            }

            @Override
            public void signup(User user) {

            }

            @Override
            public void goToAccess() {

            }
        };
        instance.dialog = new ProgressDialog(instance);
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

        onView(withId(R.id.button_left)).perform(click());

        onView(withId(R.id.button_right)).perform(click());

        onView(withId(R.id.etPassOne)).perform(clearText(), typeText("PasswordOne")); closeSoftKeyboard();
        onView(withId(R.id.etPassTwo)).perform(clearText(), typeText("PasswordTwo")); closeSoftKeyboard();

        onView(withId(R.id.button_right)).perform(click());

        onView(withId(R.id.etUsername)).perform(clearText(), typeText("Some Text")); closeSoftKeyboard();
        onView(withId(R.id.etFullName)).perform(clearText(), typeText("Some Text")); closeSoftKeyboard();
        onView(withId(R.id.etEmail)).perform(clearText(), typeText("test@email.com")); closeSoftKeyboard();
        onView(withId(R.id.etCity)).perform(clearText(), typeText("Some Text")); closeSoftKeyboard();
        onView(withId(R.id.etState)).perform(clearText(), typeText("Some Text")); closeSoftKeyboard();
        onView(withId(R.id.etAge)).perform(clearText(), typeText("Some Text")); closeSoftKeyboard();
        onView(withId(R.id.etGender)).perform(clearText(), typeText("Some Text")); closeSoftKeyboard();
        onView(withId(R.id.etPassOne)).perform(clearText(), typeText("Some Text")); closeSoftKeyboard();
        onView(withId(R.id.etPassTwo)).perform(clearText(), typeText("Some Text")); closeSoftKeyboard();

        onView(withId(R.id.button_right)).perform(click());
        getInstrumentation().runOnMainSync(() -> {
            activityRule.getActivity().toggleSpinner(true);
            activityRule.getActivity().toggleSpinner(false);
        });


    }

}