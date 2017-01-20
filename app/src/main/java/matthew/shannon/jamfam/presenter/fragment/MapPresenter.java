package matthew.shannon.jamfam.presenter.fragment;

import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.presenter.BasePresenter;
import matthew.shannon.jamfam.view.utils.RxUtils;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.view.fragment.MapView;

public class MapPresenter extends BasePresenter {
    private final NetworkService network;
    private final MapView view;

    public MapPresenter(NetworkService network, MapView view) {
        this.network = network;
        this.view = view;
    }

    public void getUserTracks() {
        add(network.getUserTracks(App.token, App.userID)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                view::addMarkers,
                error -> view.showToast("Error Getting Tracks " + error.getMessage())
            )
        );
    }

}
