package matthew.shannon.jamfam.feature.Intro.login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.feature.Intro.signup.SignupView;

import static junit.framework.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=21)
public class LoginViewTest {

    private LoginView loginView;

    @Before
    public void setUp() {
        loginView = Robolectric.setupActivity(LoginView.class);
    }

    @Test
    public void shouldStartNextActivityWhenButtonIsClicked() {
        loginView.toggleSpinner(true);
        loginView.toggleSpinner(false);
        loginView.showToast("Hello World");

        loginView.findViewById(R.id.button_left).performClick();
        Intent expectedIntent = new Intent(loginView, SignupView.class);
        assertTrue(shadowOf(loginView).getNextStartedActivity().filterEquals(expectedIntent));

        loginView.onBackPressed();


        loginView.findViewById(R.id.button_right).performClick();

        TextInputLayout email = (TextInputLayout) loginView.findViewById(R.id.etEmailLayout);
        TextInputLayout password = (TextInputLayout) loginView.findViewById(R.id.etPasswordLayout);

        email.getEditText().setText("testemail");
        password.getEditText().setText("testPassword");

        loginView.findViewById(R.id.button_right).performClick();

        email.getEditText().setText("test!email.com");
        password.getEditText().setText("testPassword");

        loginView.onDestroy();
    }



}
