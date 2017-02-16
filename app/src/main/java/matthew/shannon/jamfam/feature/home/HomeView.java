package matthew.shannon.jamfam.feature.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.databinding.ActivityHomeBinding;
import matthew.shannon.jamfam.feature.home.map.MapView;
import matthew.shannon.jamfam.feature.home.track.TrackView;
import matthew.shannon.jamfam.base.BaseToolbarActivity;

public class HomeView extends BaseToolbarActivity implements HomeContract.View {
    @Inject public HomeContract.Presenter presenter;
    @Inject FragmentManager fragmentManager;
    @Inject TrackView trackView;
    @Inject MapView mapView;
    private ActivityHomeBinding binding;

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
    protected void setupActivityComponent() {
        ((App) getApplicationContext()).getAppComponent().plus(new HomeModule(this)).inject(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
        presenter.unsubscribe();
    }

}