package matthew.shannon.jamfam.feature.Intro.access;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.app.Utils;
import matthew.shannon.jamfam.databinding.AccessViewBinding;
import matthew.shannon.jamfam.base.BaseActivity;
import rx_activity_result.RxActivityResult;

public class AccessView extends BaseActivity implements AccessContract.View {

    @Inject RxActivityResult.Builder<AccessView> settings;
    @Inject AccessContract.Presenter presenter;
    private AccessViewBinding binding;

    public AccessView() {
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.access_view);
    }

    @Override
    protected void setupActivityComponent() {
        ((App) getApplicationContext()).getAppComponent().plus(new AccessModule(this)).inject(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        binding.buttonRight.setOnClickListener(view -> checkAccess());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        binding.unbind();
    }


    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void checkAccess() {
        if (flow.serviceStatus()) flow.goToLoginActivity();
        else {
            settings.startIntent(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
                .compose(Utils.applySchedulers())
                .subscribe(
                    res -> { if (flow.serviceStatus()) flow.goToLoginActivity();},
                    error -> showToast("Error Checking Notification Access")
                );
        }
    }

}