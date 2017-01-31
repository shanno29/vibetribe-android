package matthew.shannon.jamfam.feature.Intro.login;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;

import com.romainpiel.shimmer.Shimmer;

import javax.inject.Inject;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.databinding.LoginViewBinding;
import matthew.shannon.jamfam.base.BaseActivity;
import matthew.shannon.jamfam.model.User;
import matthew.shannon.jamfam.util.SimpleTextWatcher;
import matthew.shannon.jamfam.util.StringUtils;

public class LoginView extends BaseActivity implements LoginContract.View {

    @Inject LoginContract.Presenter presenter;
    @Inject ProgressDialog dialog;
    @Inject Shimmer shimmer;
    @Inject User user;
    private LoginViewBinding binding;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.login_view);
        binding.setUser(user);
        shimmer.start(binding.title);
    }

    @Override
    protected void setupActivityComponent() {
        ((App) getApplicationContext()).getAppComponent().plus(new LoginModule(this)).inject(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        SimpleTextWatcher loginWatcher = new SimpleTextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable == binding.etEmailLayout.getEditText().getText()) StringUtils.empty(binding.etEmailLayout, "Email Is Blank");
                if (editable == binding.etPasswordLayout.getEditText().getText()) StringUtils.empty(binding.etPasswordLayout, "Username Is Blank");
            }
        };
        binding.etEmail.addTextChangedListener(loginWatcher);
        binding.etPassword.addTextChangedListener(loginWatcher);

        presenter.getInitialCheckbox();
        binding.cbLogin.setOnCheckedChangeListener((cb, b) -> presenter.setCheckBox(b));

        binding.buttonLeft.setOnClickListener(view -> presenter.goToSignup());
        binding.buttonRight.setOnClickListener(view -> {
            int errors = 0;
            errors += !StringUtils.empty(binding.etEmailLayout, "Email Is Blank") ? 1 : 0;
            errors += !StringUtils.empty(binding.etPasswordLayout, "Password Is Blank") ? 1 : 0;
            errors += !StringUtils.email(binding.etEmailLayout, "Email Is Invalid") ? 1 : 0;
            if (errors == 0) presenter.login(binding.getUser());
        });
    }

    @Override
    public void updateUI(User user, boolean checked) {
        binding.cbLogin.setChecked(checked);
        binding.setUser(user);
        binding.executePendingBindings();
    }

    @Override
    public void toggleSpinner(boolean flag) {
        if (flag) dialog.show();
        else dialog.dismiss();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        shimmer.cancel();
        binding.unbind();
        presenter.unsubscribe();
    }

}