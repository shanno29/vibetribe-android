package matthew.shannon.jamfam.feature.login;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.romainpiel.shimmer.Shimmer;
import javax.inject.Inject;
import matthew.shannon.jamfam.model.base.BaseActivity;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.databinding.LoginViewBinding;
import matthew.shannon.jamfam.inject.activity.HasActivityComponentBuilders;

public class LoginView extends BaseActivity {

    private LoginViewBinding binding;
    @Inject public LoginPresenter presenter;
    @Inject ProgressDialog dialog;
    //@Inject Shimmer shimmer;
    @Inject User user;

    @Override
    protected void injectMembers(HasActivityComponentBuilders builders) {
        ((LoginComponent.Builder) builders.getActivityBuilders(LoginView.class))
            .activityModule(new LoginComponent.LoginModule(this))
            .build().injectMembers(this);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.login_view);
        binding.setUser(user);
        //shimmer.start(binding.title);
    }

    @Override
    public void onResume() {
        super.onResume();
//        SimpleTextWatcher loginWatcher = new SimpleTextWatcher(){
//            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}
//            @Override public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {}
//            @Override public void afterTextChanged(Editable editable) {
//                if(editable == binding.etEmailLayout.getEditText().getText()) StringUtils.empty(binding.etEmailLayout, "Email Is Blank");
//                else if(editable == binding.etPasswordLayout.getEditText().getText()) StringUtils.empty(binding.etPasswordLayout, "Username Is Blank");
//            }
//        };
//        binding.etEmail.addTextChangedListener(loginWatcher);
//        binding.etPassword.addTextChangedListener(loginWatcher);
//
//        presenter.getInitialCheckbox();
//        binding.cbLogin.setOnCheckedChangeListener((cb, b) -> presenter.setCheckBox(b));
//
//        binding.buttonLeft.setOnClickListener(view -> presenter.goToSignup());
//        binding.buttonRight.setOnClickListener(view -> {
//            int errors = 0;
//            errors += !StringUtils.empty(binding.etEmailLayout, "Email Is Blank") ? 1 : 0;
//            errors += !StringUtils.empty(binding.etPasswordLayout, "Password Is Blank") ? 1 : 0;
//            errors += !StringUtils.email(binding.etEmailLayout, "Email Is Invalid") ? 1 : 0;
//            if (errors == 0) {
//                presenter.login(binding.getUser());
//
//            }
//        });
    }

    public void updateUI(User user, boolean checked) {
        binding.cbLogin.setChecked(checked);
        binding.setUser(user);
        binding.executePendingBindings();
    }

    public void toggleSpinner(boolean flag) {
        if(flag) dialog.show(); else dialog.dismiss();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //shimmer.cancel();
        binding.unbind();
        presenter.unsubscribe();
    }

}