package matthew.shannon.jamfam.feature.settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.animation.Animation;

import javax.inject.Inject;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.feature.adapter.fragment.FragmentAdapter;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.databinding.ActivitySettingsBinding;
import matthew.shannon.jamfam.base.BaseToolbarActivity;

public class SettingsView extends BaseToolbarActivity implements SettingsContract.View {
    @Inject SettingsContract.Presenter presenter;
    @Inject FragmentAdapter adapter;
    @Inject Animation animation;
    private ActivitySettingsBinding binding;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings);
        setSupportActionBar(binding.toolbar);
        binding.viewpager.setAdapter(adapter);
        binding.viewpager.startAnimation(animation);
    }

    @Override
    protected void setupActivityComponent() {
        ((App) getApplicationContext()).getAppComponent().plus(new SettingsModule(this)).inject(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
        presenter.unsubscribe();
    }

}