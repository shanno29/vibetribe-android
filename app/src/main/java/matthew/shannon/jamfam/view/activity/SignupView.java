package matthew.shannon.jamfam.view.activity;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import javax.inject.Inject;
import matthew.shannon.jamfam.inject.activity.base.BaseActivity;
import matthew.shannon.jamfam.view.utils.StringUtils;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.view.utils.SimpleTextWatcher;
import matthew.shannon.jamfam.databinding.SignupViewBinding;
import matthew.shannon.jamfam.inject.activity.component.HasActivityComponentBuilders;
import matthew.shannon.jamfam.inject.activity.component.SignupComponent;
import matthew.shannon.jamfam.presenter.activity.SignupPresenter;

public class SignupView extends BaseActivity {

    private SignupViewBinding binding;
    @Inject SignupPresenter presenter;
    @Inject ProgressDialog dialog;

    @Override
    protected void injectMembers(HasActivityComponentBuilders builders) {
        ((SignupComponent.Builder) builders.getActivityBuilders(SignupView.class))
            .activityModule(new SignupComponent.SignupModule(this))
            .build().injectMembers(this);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.signup_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SimpleTextWatcher signupWatcher = new SimpleTextWatcher(){
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {}
            @Override  public void afterTextChanged(Editable editable) {
                if(editable == binding.etEmailLayout.getEditText().getText()){
                    StringUtils.empty(binding.etEmailLayout, "Email Is Blank");
                }
                else if(editable == binding.etUsernameLayout.getEditText().getText()){
                    StringUtils.empty(binding.etUsernameLayout, "Username Is Blank");
                }
                else if(editable == binding.etFullNameLayout.getEditText().getText()){
                    StringUtils.empty(binding.etFullNameLayout, "Full Name Is Blank");
                }
                else if(editable == binding.etCityLayout.getEditText().getText()){
                    StringUtils.empty(binding.etCityLayout, "City Is Blank");
                }
                else if(editable == binding.etStateLayout.getEditText().getText()){
                    StringUtils.empty(binding.etStateLayout, "State Is Blank");
                }
                else if(editable == binding.etAgeLayout.getEditText().getText()){
                    StringUtils.empty(binding.etAgeLayout, "Age Is Blank");
                }
                else if(editable == binding.etGenderLayout.getEditText().getText()){
                    StringUtils.empty(binding.etGenderLayout, "Gender Is Blank");
                }
                else if(editable == binding.etPassOneLayout.getEditText().getText()){
                    StringUtils.empty(binding.etPassOneLayout, "Password Is Blank");
                }
                else if(editable == binding.etPassTwoLayout.getEditText().getText()){
                    StringUtils.empty(binding.etPassTwoLayout, "Password Is Blank");
                }

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

    }

    public void toggleSpinner(boolean flag) {
        if(flag) dialog.show(); else dialog.dismiss();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        binding.unbind();
    }

}