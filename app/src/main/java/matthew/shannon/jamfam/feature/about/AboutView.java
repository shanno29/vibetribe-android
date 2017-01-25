package matthew.shannon.jamfam.feature.about;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.animation.Animation;
import javax.inject.Inject;

import matthew.shannon.jamfam.model.base.BaseToolbarActivity;
import matthew.shannon.jamfam.adapter.fragment.FragmentAdapter;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.ActivityAboutBinding;
import matthew.shannon.jamfam.inject.activity.HasActivityComponentBuilders;

public class AboutView extends BaseToolbarActivity {
    private ActivityAboutBinding binding;
    @Inject FragmentAdapter adapter;
    @Inject Animation animation;

    @Override
    protected void injectMembers(HasActivityComponentBuilders builders) {
        ((AboutComponent.Builder) builders.getActivityBuilders(AboutView.class))
            .activityModule(new AboutComponent.AboutModule(this))
            .build().injectMembers(this);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about);
        setSupportActionBar(binding.toolbar);
        binding.viewpager.setAdapter(adapter);
        //binding.viewpager.startAnimation(animation);
        //binding.viewpager.setOffscreenPageLimit(adapter.getCount());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
    }

}