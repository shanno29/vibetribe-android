package matthew.shannon.jamfam.feature.Intro.signup;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;

import javax.inject.Inject;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.databinding.SignupViewBinding;
import matthew.shannon.jamfam.base.BaseActivity;
import matthew.shannon.jamfam.utils.SimpleTextWatcher;
import matthew.shannon.jamfam.utils.StringUtils;

public class SignupView extends BaseActivity implements SignupContract.View {

    @Inject ProgressDialog dialog;
    @Inject SignupContract.Presenter presenter;
    private SignupViewBinding binding;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.signup_view);
    }

    @Override
    public void setupActivityComponent() {
        ((App) getApplicationContext()).getAppComponent().plus(new SignupModule(this)).inject(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        binding.buttonLeft.setOnClickListener(view -> presenter.goToAccess());
        binding.buttonRight.setOnClickListener(view -> {
            int errors = 0;
            errors += !StringUtils.empty(binding.etEmailLayout, "Email Is Blank") ? 1 : 0;
            errors += !StringUtils.empty(binding.etUsernameLayout, "Username Is Blank") ? 1 : 0;
            errors += !StringUtils.empty(binding.etFullNameLayout, "Full Name Is Blank") ? 1 : 0;
            errors += !StringUtils.empty(binding.etCityLayout, "City Is Blank") ? 1 : 0;
            errors += !StringUtils.empty(binding.etStateLayout, "State Is Blank") ? 1 : 0;
            errors += !StringUtils.empty(binding.etAgeLayout, "Age Is Blank") ? 1 : 0;
            errors += !StringUtils.empty(binding.etGenderLayout, "Gender Is Blank") ? 1 : 0;
            errors += !StringUtils.empty(binding.etPassOneLayout, "Password Is Blank") ? 1 : 0;
            errors += !StringUtils.empty(binding.etPassTwoLayout, "Password Is Blank") ? 1 : 0;
            errors += !StringUtils.email(binding.etEmailLayout, "Email Is Invalid") ? 1 : 0;
            errors += !StringUtils.passwords(binding.etPassOneLayout, binding.etPassTwoLayout, "Passwords Do Not Match") ? 1 : 0;

            if (errors == 0) presenter.signup(binding.getUser());
        });

        SimpleTextWatcher signupWatcher = new SimpleTextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable e) {
                if (e == binding.etEmailLayout.getEditText().getText())
                    StringUtils.empty(binding.etEmailLayout, "Email Is Blank");
                if (e == binding.etUsernameLayout.getEditText().getText())
                    StringUtils.empty(binding.etUsernameLayout, "Username Is Blank");
                if (e == binding.etFullNameLayout.getEditText().getText())
                    StringUtils.empty(binding.etFullNameLayout, "Full Name Is Blank");
                if (e == binding.etCityLayout.getEditText().getText())
                    StringUtils.empty(binding.etCityLayout, "City Is Blank");
                if (e == binding.etStateLayout.getEditText().getText())
                    StringUtils.empty(binding.etStateLayout, "State Is Blank");
                if (e == binding.etAgeLayout.getEditText().getText())
                    StringUtils.empty(binding.etAgeLayout, "Age Is Blank");
                if (e == binding.etGenderLayout.getEditText().getText())
                    StringUtils.empty(binding.etGenderLayout, "Gender Is Blank");
                if (e == binding.etPassOneLayout.getEditText().getText())
                    StringUtils.empty(binding.etPassOneLayout, "Password Is Blank");
                if (e == binding.etPassTwoLayout.getEditText().getText())
                    StringUtils.empty(binding.etPassTwoLayout, "Password Is Blank");


            }
        };
        binding.etEmail.addTextChangedListener(signupWatcher);
        binding.etUsername.addTextChangedListener(signupWatcher);
        binding.etFullName.addTextChangedListener(signupWatcher);
        binding.etCity.addTextChangedListener(signupWatcher);
        binding.etState.addTextChangedListener(signupWatcher);
        binding.etAge.addTextChangedListener(signupWatcher);
        binding.etGender.addTextChangedListener(signupWatcher);
        binding.etPassOne.addTextChangedListener(signupWatcher);
        binding.etPassTwo.addTextChangedListener(signupWatcher);


    }

    @Override
    public void toggleSpinner(boolean flag) {
        if (flag) dialog.show();
        else dialog.dismiss();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.unbind();
        presenter.unsubscribe();
    }

    @Override
    public void showToast(String text) {

    }
}