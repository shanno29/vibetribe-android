package matthew.shannon.jamfam.feature.access;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import javax.inject.Inject;

import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.AccessViewBinding;
import matthew.shannon.jamfam.model.base.BaseActivity;

public class AccessView extends BaseActivity implements AccessContract.View {

    @Inject AccessContract.Presenter presenter;
    private AccessViewBinding binding;

    public AccessView() {}

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.access_view);
    }

    @Override
    protected void setupActivityComponent() {
        ((App)getApplicationContext()).getAppComponent().plus(new AccessModule(this)).inject(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        binding.buttonRight.setOnClickListener(view -> presenter.checkAccess());
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