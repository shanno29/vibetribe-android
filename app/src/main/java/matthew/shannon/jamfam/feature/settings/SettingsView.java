package matthew.shannon.jamfam.feature.settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import javax.inject.Inject;

import matthew.shannon.jamfam.model.base.BaseToolbarActivity;
import matthew.shannon.jamfam.adapter.fragment.FragmentAdapter;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.ActivitySettingsBinding;
import matthew.shannon.jamfam.inject.activity.HasActivityComponentBuilders;

public class SettingsView extends BaseToolbarActivity {
    private ActivitySettingsBinding binding;
    @Inject public SettingsPresenter presenter;
    @Inject FragmentAdapter adapter;
    //@Inject Animation animation;

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
        //binding.viewpager.startAnimation(animation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
        presenter.unsubscribe();
    }

}