package matthew.shannon.jamfam.feature.home.map;

import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.utils.RxUtils;

public class MapPresenter extends BasePresenter implements MapContract.Presenter{
    private final NetworkService network;
    private final MapContract.View view;

    public MapPresenter(NetworkService network, MapContract.View view) {
        this.network = network;
        this.view = view;
    }

    @Override
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
