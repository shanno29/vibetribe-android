package matthew.shannon.jamfam.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import javax.inject.Inject;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.inject.activity.base.BaseActivity;
import matthew.shannon.jamfam.databinding.LogoutBinding;
import matthew.shannon.jamfam.inject.activity.component.HasActivityComponentBuilders;
import matthew.shannon.jamfam.inject.activity.component.LogoutComponent;
import matthew.shannon.jamfam.presenter.activity.LogoutPresenter;

public class LogoutView extends BaseActivity {
    private LogoutBinding binding;
    @Inject LogoutPresenter presenter;

    @Override
    protected void injectMembers(HasActivityComponentBuilders builders) {
        ((LogoutComponent.Builder) builders.getActivityBuilders(LogoutView.class))
            .activityModule(new LogoutComponent.LogoutModule(this))
            .build().injectMembers(this);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this,R.layout.logout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.logoutUser();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
        presenter.unsubscribe();
    }

}