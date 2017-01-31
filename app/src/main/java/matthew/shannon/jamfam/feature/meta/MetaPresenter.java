package matthew.shannon.jamfam.feature.meta;

import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.location.LocationService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.utils.RxUtils;

public class MetaPresenter extends BasePresenter implements MetaContract.Presenter {
    private final LocationService location;
    private final NetworkService network;
    private final CacheService cache;
    private final BusService bus;
    private final MetaView view;
    private Track track;

    public MetaPresenter(LocationService location, NetworkService network, CacheService cache, BusService bus, MetaView view, Track track) {
        this.location = location;
        this.network = network;
        this.cache = cache;
        this.bus = bus;
        this.view = view;
        this.track = track;
    }

    @Override
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

    @Override
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

    @Override
    public void lookUpTrack() {
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

    @Override
    public void trackUpdate(String title, String album, String artist) {
        if (!track.getTitle().equals(title)) {
            track.setArtist(artist);
            track.setTitle(title);
            track.setAlbum(album);
            lookUpTrack();
        }
    }
}
