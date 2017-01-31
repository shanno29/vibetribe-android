package matthew.shannon.jamfam.feature.about;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.animation.Animation;

import javax.inject.Inject;

import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.adapter.fragment.FragmentAdapter;
import matthew.shannon.jamfam.databinding.ActivityAboutBinding;
import matthew.shannon.jamfam.model.base.BaseToolbarActivity;

public class AboutView extends BaseToolbarActivity {
    private ActivityAboutBinding binding;
    @Inject FragmentAdapter adapter;
    @Inject Animation animation;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about);
        setSupportActionBar(binding.toolbar);
        binding.viewpager.setAdapter(adapter);
        binding.viewpager.startAnimation(animation);
        binding.viewpager.setOffscreenPageLimit(adapter.getCount());

    }

    @Override
    protected void setupActivityComponent() {
        ((App)getApplicationContext()).getAppComponent().plus(new AboutModule(this)).inject(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
    }

}