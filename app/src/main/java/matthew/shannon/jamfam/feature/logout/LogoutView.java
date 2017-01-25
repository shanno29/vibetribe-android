package matthew.shannon.jamfam.feature.logout;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import javax.inject.Inject;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.LogoutBinding;
import matthew.shannon.jamfam.inject.activity.HasActivityComponentBuilders;
import matthew.shannon.jamfam.model.base.BaseActivity;

public class LogoutView extends BaseActivity {
    private LogoutBinding binding;
    @Inject public LogoutPresenter presenter;

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