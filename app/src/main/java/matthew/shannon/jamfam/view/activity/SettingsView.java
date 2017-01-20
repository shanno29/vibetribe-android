package matthew.shannon.jamfam.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.animation.Animation;
import javax.inject.Inject;

import matthew.shannon.jamfam.view.adapter.FragmentAdapter;
import matthew.shannon.jamfam.inject.activity.base.BaseToolbarActivity;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.ActivitySettingsBinding;
import matthew.shannon.jamfam.inject.activity.component.HasActivityComponentBuilders;
import matthew.shannon.jamfam.inject.activity.component.SettingsComponent;

public class SettingsView extends BaseToolbarActivity {
    private ActivitySettingsBinding binding;
    @Inject FragmentAdapter adapter;
    @Inject Animation animation;

    @Override
    protected void injectMembers(HasActivityComponentBuilders builders) {
        ((SettingsComponent.Builder) builders.getActivityBuilders(SettingsView.class))
            .activityModule(new SettingsComponent.SettingsModule(this))
            .build().injectMembers(this);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings);
        setSupportActionBar(binding.toolbar);

        binding.viewpager.setAdapter(adapter);
        binding.viewpager.startAnimation(animation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
    }

}