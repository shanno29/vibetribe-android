package matthew.shannon.jamfam.feature.logout;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import javax.inject.Inject;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.LogoutBinding;
import matthew.shannon.jamfam.model.base.BaseActivity;

public class LogoutView extends BaseActivity implements LogoutContract.View{
    private LogoutBinding binding;
    @Inject LogoutContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this,R.layout.logout);
    }

    @Override
    protected void setupActivityComponent() {
        ((App)getApplicationContext()).getAppComponent().plus(new LogoutModule(this)).inject(this);

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