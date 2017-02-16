package matthew.shannon.jamfam.feature.Intro.welcome;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import javax.inject.Inject;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.databinding.WelcomeViewBinding;
import matthew.shannon.jamfam.base.BaseActivity;

public class WelcomeView extends BaseActivity implements WelcomeContract.View {

    @Inject GoogleApiAvailability api;
    private WelcomeViewBinding binding;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.welcome_view);
    }

    @Override
    protected void setupActivityComponent() {
        ((App)getApplicationContext()).getAppComponent().plus(new WelcomeModule(this)).inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkGoogleAPI();
        binding.buttonRight.setOnClickListener(view -> gotoSignup());
    }

    @Override
    public void checkGoogleAPI() {
        int code = api.isGooglePlayServicesAvailable(this);
        if (code != ConnectionResult.SUCCESS && api.isUserResolvableError(code)) {
            api.getErrorDialog(this, code, 900);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.unbind();
    }

    @Override
    public void gotoSignup() {
        flow.goToSignupActivity();
    }

}