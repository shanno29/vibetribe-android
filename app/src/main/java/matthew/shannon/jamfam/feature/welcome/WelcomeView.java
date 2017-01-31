package matthew.shannon.jamfam.feature.welcome;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import javax.inject.Inject;

import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.WelcomeViewBinding;
import matthew.shannon.jamfam.model.base.BaseActivity;

public class WelcomeView extends BaseActivity implements WelcomeContract.View {

    @Inject WelcomeContract.Presenter presenter;
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
        presenter.checkGoogleApi();
        binding.buttonRight.setOnClickListener(view -> presenter.gotoSignup());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        binding.unbind();
    }

    @Override
    public void showToast(String text) {

    }
}