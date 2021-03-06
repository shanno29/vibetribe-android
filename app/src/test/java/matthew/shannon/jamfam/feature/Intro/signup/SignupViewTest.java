package matthew.shannon.jamfam.feature.Intro.signup;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.feature.Intro.access.AccessView;
import matthew.shannon.jamfam.model.User;

import static junit.framework.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class SignupViewTest {

    private SignupView signupView;

    @Before
    public void setUp() {
        signupView = Robolectric.setupActivity(SignupView.class);
        signupView.presenter = new SignupContract.Presenter() {
            @Override
            public void signup(User user) {

            }

            @Override
            public void unsubscribe() {

            }
        };
    }

    @Test
    public void signupViewTests() {
        signupView.toggleSpinner(true);
        signupView.toggleSpinner(false);
        signupView.showToast("Hello World");

        TextInputLayout email = (TextInputLayout) signupView.findViewById(R.id.etEmailLayout);
        TextInputLayout username = (TextInputLayout) signupView.findViewById(R.id.etUsernameLayout);
        TextInputLayout fullname = (TextInputLayout) signupView.findViewById(R.id.etFullNameLayout);
        TextInputLayout city = (TextInputLayout) signupView.findViewById(R.id.etCityLayout);
        TextInputLayout state = (TextInputLayout) signupView.findViewById(R.id.etStateLayout);
        TextInputLayout age = (TextInputLayout) signupView.findViewById(R.id.etAgeLayout);
        TextInputLayout gender = (TextInputLayout) signupView.findViewById(R.id.etGenderLayout);
        TextInputLayout passOne = (TextInputLayout) signupView.findViewById(R.id.etPassOneLayout);
        TextInputLayout passTwo = (TextInputLayout) signupView.findViewById(R.id.etPassTwoLayout);

        email.getEditText().setText("");
        username.getEditText().setText("");
        fullname.getEditText().setText("");
        city.getEditText().setText("");
        state.getEditText().setText("");
        age.getEditText().setText("");
        gender.getEditText().setText("");
        passOne.getEditText().setText("");
        passTwo.getEditText().setText("");

        signupView.findViewById(R.id.button_right).performClick();

        passOne.getEditText().setText("testPasswordOne");
        passTwo.getEditText().setText("testPasswordTwo");

        signupView.findViewById(R.id.button_right).performClick();

        email.getEditText().setText("test@email.com");
        username.getEditText().setText("testUsername");
        fullname.getEditText().setText("testFullName");
        city.getEditText().setText("testCity");
        state.getEditText().setText("testState");
        age.getEditText().setText("testAge");
        gender.getEditText().setText("testGender");
        passOne.getEditText().setText("testPassword");
        passTwo.getEditText().setText("testPassword");

        signupView.findViewById(R.id.button_right).performClick();

        signupView.findViewById(R.id.button_left).performClick();
        Intent expectedIntent = new Intent(signupView, AccessView.class);
        assertTrue(shadowOf(signupView).getNextStartedActivity().filterEquals(expectedIntent));

        signupView.onBackPressed();
    }

    @After
    public void tearDown() {
        signupView.onDestroy();
    }

}
