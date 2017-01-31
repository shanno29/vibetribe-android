package matthew.shannon.jamfam.feature.message;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.animation.Animation;

import javax.inject.Inject;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.feature.adapter.fragment.FragmentAdapter;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.databinding.ActivityMessageBinding;
import matthew.shannon.jamfam.base.BaseToolbarActivity;

public class MessageView extends BaseToolbarActivity implements MessageContract.View {
    @Inject MessageContract.Presenter presenter;
    @Inject FragmentAdapter adapter;
    @Inject Animation animation;
    private ActivityMessageBinding binding;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_message);
        setSupportActionBar(binding.toolbar);
        binding.viewpager.setAdapter(adapter);
        binding.viewpager.startAnimation(animation);
    }

    @Override
    public void setupActivityComponent() {
        ((App) getApplicationContext()).getAppComponent().plus(new MessageModule(this)).inject(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        binding.unbind();
    }

}