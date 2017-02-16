package matthew.shannon.jamfam.feature.Intro.signup;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import javax.inject.Inject;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.app.Utils;
import matthew.shannon.jamfam.databinding.SignupViewBinding;
import matthew.shannon.jamfam.base.BaseActivity;
import matthew.shannon.jamfam.model.User;

public class SignupView extends BaseActivity implements SignupContract.View {

    @Inject User user;
    @Inject ProgressDialog dialog;
    @Inject public SignupContract.Presenter presenter;
    private SignupViewBinding binding;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.signup_view);
        binding.setUser(user);
    }

    @Override
    public void setupActivityComponent() {
        ((App) getApplicationContext()).getAppComponent().plus(new SignupModule(this)).inject(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        binding.buttonLeft.setOnClickListener(v -> goToAccess());
        binding.buttonRight.setOnClickListener(v -> {
            int errors = 0;
            errors += !Utils.empty(binding.etEmailLayout, "Email Is Blank") ? 1 : 0;
            errors += !Utils.empty(binding.etUsernameLayout, "Username Is Blank") ? 1 : 0;
            errors += !Utils.empty(binding.etFullNameLayout, "Full Name Is Blank") ? 1 : 0;
            errors += !Utils.empty(binding.etCityLayout, "City Is Blank") ? 1 : 0;
            errors += !Utils.empty(binding.etStateLayout, "State Is Blank") ? 1 : 0;
            errors += !Utils.empty(binding.etAgeLayout, "Age Is Blank") ? 1 : 0;
            errors += !Utils.empty(binding.etGenderLayout, "Gender Is Blank") ? 1 : 0;
            errors += !Utils.empty(binding.etPassOneLayout, "Password Is Blank") ? 1 : 0;
            errors += !Utils.empty(binding.etPassTwoLayout, "Password Is Blank") ? 1 : 0;
            errors += !Utils.email(binding.etEmailLayout, "Email Is Invalid") ? 1 : 0;
            errors += !Utils.passwords(binding.etPassOneLayout, binding.etPassTwoLayout, "Passwords Do Not Match") ? 1 : 0;

            if (errors == 0) presenter.signup(binding.getUser());
        });

        TextWatcher signupWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable e) {
                if (e == binding.etEmailLayout.getEditText().getText())
                    Utils.empty(binding.etEmailLayout, "Email Is Blank");
                if (e == binding.etUsernameLayout.getEditText().getText())
                    Utils.empty(binding.etUsernameLayout, "Username Is Blank");
                if (e == binding.etFullNameLayout.getEditText().getText())
                    Utils.empty(binding.etFullNameLayout, "Full Name Is Blank");
                if (e == binding.etCityLayout.getEditText().getText())
                    Utils.empty(binding.etCityLayout, "City Is Blank");
                if (e == binding.etStateLayout.getEditText().getText())
                    Utils.empty(binding.etStateLayout, "State Is Blank");
                if (e == binding.etAgeLayout.getEditText().getText())
                    Utils.empty(binding.etAgeLayout, "Age Is Blank");
                if (e == binding.etGenderLayout.getEditText().getText())
                    Utils.empty(binding.etGenderLayout, "Gender Is Blank");
                if (e == binding.etPassOneLayout.getEditText().getText())
                    Utils.empty(binding.etPassOneLayout, "Password Is Blank");
                if (e == binding.etPassTwoLayout.getEditText().getText())
                    Utils.empty(binding.etPassTwoLayout, "Password Is Blank");


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
    public void goToAccess() {
        flow.goToAccessActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.unbind();
        presenter.unsubscribe();
    }

}