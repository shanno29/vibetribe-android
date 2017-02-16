package matthew.shannon.jamfam.feature.home.track;

import matthew.shannon.jamfam.app.Utils;
import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;

public class TrackPresenter extends BasePresenter implements TrackContract.Presenter {
    private final CacheService cache;
    private final FlowService flow;
    private final TrackContract.View view;

    public TrackPresenter(CacheService cache, FlowService flow, TrackContract.View view) {
        this.cache = cache;
        this.flow = flow;
        this.view = view;
    }

    @Override
    public void checkForSecondRun() {
        add(cache.getHomeSecondRun()
                .compose(Utils.applySchedulers())
                .subscribe(
                        flag -> {
                            if (!flag) cache.setSecondRun();
                            view.showIntroView();
                        },
                        error -> view.showToast(error.getMessage())
                )
        );
    }

    @Override
    public void postTrack(Track track) {
//        add(network.postTrack(App.token, App.userID, track)
//                .compose(Utils.applySchedulers())
//                .subscribe(
//                        tracks -> view.showToast("Track Posted Successfully"),
//                        error -> view.showToast("Error Posting Track " + error.getMessage())
//                )
//        );
    }

    @Override
    public void trackSelected(Track track) {
        flow.goToTrack(track);
    }

    @Override
    public void appSelected() {
        flow.goToApp();
    }

    @Override
    public void controlUpdate(int command) {
        flow.controlTrack(command);
    }

}