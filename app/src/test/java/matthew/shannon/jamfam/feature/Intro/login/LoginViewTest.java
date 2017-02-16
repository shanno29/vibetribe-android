package matthew.shannon.jamfam.feature.Intro.login;

import android.support.design.widget.TextInputLayout;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.model.User;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class LoginViewTest {

    private LoginView loginView;

    @Before
    public void setUp() {
        loginView = Robolectric.setupActivity(LoginView.class);
        loginView.presenter = new LoginContract.Presenter() {
            @Override
            public void login(User user) {

            }

            @Override
            public void getInitialCheckbox() {

            }

            @Override
            public void setCheckBox(boolean b) {

            }

            @Override
            public void unsubscribe() {

            }
        };
    }

    @Test
    public void shouldStartNextActivityWhenButtonIsClicked() {
        loginView.toggleSpinner(true);
        loginView.toggleSpinner(false);
        loginView.showToast("Hello World");

        loginView.findViewById(R.id.button_left).performClick();
        loginView.onBackPressed();

        loginView.findViewById(R.id.button_right).performClick();

        TextInputLayout email = (TextInputLayout) loginView.findViewById(R.id.etEmailLayout);
        TextInputLayout password = (TextInputLayout) loginView.findViewById(R.id.etPasswordLayout);

        email.getEditText().setText("test@email.com");
        password.getEditText().setText("testPassword");

        loginView.findViewById(R.id.button_right).performClick();

        email.getEditText().setText("test!email.com");
        password.getEditText().setText("testPassword");

        loginView.goToHomeActivity();
        loginView.onBackPressed();

        loginView.goToStore();
        loginView.onBackPressed();

        loginView.updateUI(new User(), true);

        loginView.onDestroy();
    }



}
