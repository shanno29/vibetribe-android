package matthew.shannon.jamfam.presenter.service;

import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.presenter.BasePresenter;
import matthew.shannon.jamfam.view.utils.RxUtils;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.location.LocationService;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.view.service.MetadataView;

public class MetadataPresenter extends BasePresenter {
    private final LocationService location;
    private final NetworkService network;
    private final CacheService cache;
    private final BusService bus;
    private final MetadataView view;
    private Track track;

    public MetadataPresenter(LocationService location, NetworkService network, CacheService cache, BusService bus, MetadataView view, Track track) {
        this.location = location;
        this.network = network;
        this.cache = cache;
        this.bus = bus;
        this.view = view;
        this.track = track;
    }

    public void getLastLocation() {
        add(location.getLastLocation()
            .compose(RxUtils.applySchedulers())
            .subscribe(
                location -> {
                    track.setLatitude(location.getLatitude());
                    track.setLongitude(location.getLongitude());
                    bus.sendTrackUpdate(track);
                },
                error -> view.showToast("Error Getting Location Info")
            )
        );
    }

    public void getLocationUpdate() {
        add(location.getUpdatedLocation()
            .compose(RxUtils.applySchedulers())
            .subscribe(
                location -> {
                    track.setLatitude(location.getLatitude());
                    track.setLongitude(location.getLongitude());
                    bus.sendTrackUpdate(track);
                },
                error -> view.showToast("Error Getting Location Info")
            )
        );
    }

    private void lookUpTrack() {
        add(network.searchOnline(App.token, track.getTitle(), track.getArtist(), "1")
            .compose(RxUtils.applySchedulers())
            .subscribe(
                tracks -> {
                    track = tracks.get(0);
                    bus.sendTrackUpdate(track);
                },
                error -> view.showToast("Error Getting Track Info")
            )
        );
    }

    public void trackUpdate(String title, String album, String artist) {
        if (!track.getTitle().equals(title)) {
            track.setArtist(artist);
            track.setTitle(title);
            track.setAlbum(album);
            lookUpTrack();
        }
    }
}
