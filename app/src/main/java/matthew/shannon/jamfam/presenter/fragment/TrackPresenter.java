package matthew.shannon.jamfam.presenter.fragment;

import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.presenter.BasePresenter;
import matthew.shannon.jamfam.view.utils.RxUtils;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.view.fragment.TrackView;

public class TrackPresenter extends BasePresenter {
    private final NetworkService network;
    private final CacheService cache;
    private final BusService bus;
    private final TrackView view;

    public TrackPresenter(NetworkService network, CacheService cache, BusService bus, TrackView view) {
        this.network = network;
        this.cache = cache;
        this.bus = bus;
        this.view = view;
    }

    public void checkForSecondRun() {
        add(cache.getHomeSecondRun()
            .compose(RxUtils.applySchedulers())
            .subscribe(
                flag -> { if(!flag) cache.setSecondRun(); view.showIntroView(); },
                error -> view.showToast(error.getMessage())
            )
        );
    }

    public void postTrack(Track track) {
        add(network.postTrack(App.token, App.userID, track)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                tracks -> view.showToast("Track Posted Successfully"),
                error -> view.showToast("Error Posting Track " + error.getMessage())
            )
        );
    }

    public void trackSelected(Track track) {
        bus.goToTrack(track);
    }

    public void appSelected() {
        bus.goToApp();
    }

    public void controlUpdate(int command) {
        bus.controlTrack(command);
    }

}