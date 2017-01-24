package matthew.shannon.jamfam.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import javax.inject.Inject;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.AccessViewBinding;
import matthew.shannon.jamfam.inject.activity.component.AccessComponent;
import matthew.shannon.jamfam.inject.activity.component.HasActivityComponentBuilders;
import matthew.shannon.jamfam.presenter.activity.AccessPresenter;

public class AccessView extends BaseActivity {

    @Inject public AccessPresenter presenter;
    private AccessViewBinding binding;

    public AccessView() {}

    @Override
    protected void injectMembers(HasActivityComponentBuilders builders) {
        ((AccessComponent.Builder) builders.getActivityBuilders(AccessView.class))
            .activityModule(new AccessComponent.AccessModule(this))
            .build().injectMembers(this);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.access_view);
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


}