package matthew.shannon.jamfam.feature.home.map;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.hwangjr.rxbus.annotation.Subscribe;
import java.util.List;
import javax.inject.Inject;

import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.FragmentMapBinding;
import matthew.shannon.jamfam.inject.fragment.HasFragmentComponentBuilders;
import matthew.shannon.jamfam.model.base.BaseFragment;

public class MapView extends BaseFragment implements OnMapReadyCallback{
    private FragmentMapBinding binding;
    @Inject public MapPresenter presenter;
    private GoogleMap googleMap;

    public MapView() {}

    @Override
    protected void injectMembers(HasFragmentComponentBuilders builders) {
        ((MapComponent.Builder) builders.getFragmentBuilders(MapView.class))
            .fragmentModule(new MapComponent.MapModule(this))
            .build().injectMembers(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        super.onCreateView(inflater, container, bundle);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map,  container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        MapsInitializer.initialize(getContext());
        binding.mapView.onCreate(bundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.mapView.onDestroy();
        binding.unbind();
        presenter.unsubscribe();
    }


//    @Subscribe
//    public void trackUpdate(Track track) {
//        if (googleMap != null) googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(track.getLatitude(), track.getLongitude()), 14));
//    }
//
//    public void addMarkers(List<Track> tracks) {
//        Stream.of(tracks)
//            .forEach(track -> {
//                MarkerOptions options = new MarkerOptions();
//                options.position(new LatLng(track.getLatitude(), track.getLongitude()));
//                options.title(track.getUpdatedAt());
//                options.snippet(track.getTitle() + "\n " + track.getArtist());
//                options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
//                googleMap.addMarker(options);
//            });
//
//    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
//        this.googleMap = googleMap;
//        this.googleMap.setMapType(2);
//        presenter.getUserTracks();
    }
}
