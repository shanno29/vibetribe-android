package matthew.shannon.jamfam.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import javax.inject.Inject;
import matthew.shannon.jamfam.view.fragment.TrackView;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.ActivityHomeBinding;
import matthew.shannon.jamfam.view.fragment.MapView;
import matthew.shannon.jamfam.inject.activity.component.HasActivityComponentBuilders;
import matthew.shannon.jamfam.inject.activity.component.HomeComponent;

public class HomeView extends BaseToolbarActivity {
    private ActivityHomeBinding binding;
    @Inject FragmentManager fragmentManager;
    @Inject TrackView trackView;
    @Inject MapView mapView;

    @Override
    protected void injectMembers(HasActivityComponentBuilders builders) {
        ((HomeComponent.Builder) builders.getActivityBuilders(HomeView.class))
            .activityModule(new HomeComponent.HomeModule(this))
            .build().injectMembers(this);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        setSupportActionBar(binding.toolbar);

        fragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.slide_up, R.anim.slide_down)
            .replace(R.id.trackFragment, trackView)
            .replace(R.id.mapFragment, mapView)
            .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
    }
}