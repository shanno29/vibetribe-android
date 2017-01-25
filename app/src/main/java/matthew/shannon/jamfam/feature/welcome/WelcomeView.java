package matthew.shannon.jamfam.feature.welcome;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import javax.inject.Inject;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.WelcomeViewBinding;
import matthew.shannon.jamfam.inject.activity.HasActivityComponentBuilders;
import matthew.shannon.jamfam.model.base.BaseActivity;

public class WelcomeView extends BaseActivity {

    @Inject
    public
    WelcomePresenter presenter;
    private WelcomeViewBinding binding;

    @Override
    protected void injectMembers(HasActivityComponentBuilders builders) {
        ((WelcomeComponent.Builder) builders.getActivityBuilders(WelcomeView.class))
            .activityModule(new WelcomeComponent.WelcomeModule(this))
            .build().injectMembers(this);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.welcome_view);
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

}