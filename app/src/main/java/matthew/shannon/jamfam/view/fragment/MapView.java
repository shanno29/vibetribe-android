package matthew.shannon.jamfam.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.hwangjr.rxbus.annotation.Subscribe;
import java.util.List;
import javax.inject.Inject;

import matthew.shannon.jamfam.presenter.fragment.MapPresenter;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.FragmentMapBinding;
import matthew.shannon.jamfam.inject.fragment.component.HasFragmentComponentBuilders;
import matthew.shannon.jamfam.inject.fragment.component.MapComponent;

public class MapView extends BaseFragment {
    private FragmentMapBinding binding;
    @Inject MapPresenter presenter;
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
        binding.mapView.getMapAsync(mapReady -> {
            this.googleMap = mapReady;
            this.googleMap.setMapType(2);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.mapView.onResume();
        // presenter.getUserTracks();
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        binding.mapView.onDestroy();
        binding.unbind();
    }


    @Subscribe
    public void trackUpdate(Track track) {
        if (googleMap != null) {
            LatLng pos = new LatLng(track.getLatitude(), track.getLongitude());
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 14));
        }
    }

    public void addMarkers(List<Track> tracks) {
//        Stream.of(tracks)
//            .forEach(track -> {
//                MarkerOptions options = new MarkerOptions();
//                options.position(new LatLng(track.getLatitude(), track.getLongitude()));
//                options.title(track.getUpdatedAt());
//                options.snippet(track.getTitle() + "\n " + track.getArtist());
//                options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
//                googleMap.addMarker(options);
//            });

    }
    
}
