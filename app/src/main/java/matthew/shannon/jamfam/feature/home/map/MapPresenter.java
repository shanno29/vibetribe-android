package matthew.shannon.jamfam.feature.home.map;

import matthew.shannon.jamfam.base.BasePresenter;

public class MapPresenter extends BasePresenter implements MapContract.Presenter {
    private final MapContract.View view;

    public MapPresenter(MapContract.View view) {
        this.view = view;
    }

    @Override
    public void getUserTracks() {
//        add(network.getUserTracks(App.token, App.userID)
//                .compose(RxUtils.applySchedulers())
//                .subscribe(
//                        view::addMarkers,
//                        error -> view.showToast("Error Getting Tracks " + error.getMessage())
//                )
//        );
    }

}
