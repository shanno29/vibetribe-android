package matthew.shannon.jamfam.list;

import java.util.List;

import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.utils.RxUtils;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

public class ListPresenter extends BasePresenter {
    private final NetworkService network;
    private final CacheService cache;
    private final FlowService flow;
    private final ListView view;

    public ListPresenter(NetworkService network, CacheService cache, FlowService flow, ListView view) {
        this.network = network;
        this.cache = cache;
        this.flow = flow;
        this.view = view;
    }

    public void loadSettings(String Id) {
        add(cache.getUserSettings(Id)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                view::onSuccess,
                error -> view.showToast("Error Loading Settings " + error.getMessage())
            )
        );
    }

    public void loadAllTracks() {
        add(network.getAllTracks(App.token)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                view::onSuccess,
                error -> view.showToast("Error Loading Tracks " + error.getMessage())
            )
        );
    }

    public void loadFriendsTracks(String Id) {
        add(network.getFriendsTracks(App.token, Id)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                view::onSuccess,
                error -> view.showToast("Error Loading Friends Tracks " + error.getMessage())
            )
        );
    }

    public void loadUserTracks(String Id) {
        add(network.getUserTracks(App.token, Id)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                view::onSuccess,
                error -> view.showToast("Error Loading User Tracks " + error.getMessage())
            )
        );
    }

    public void loadAllUsers() {
        add(network.getAllUsers(App.token)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                view::onSuccess,
                error -> view.showToast("Error Loading All Users " + error.getMessage())
            )
        );
    }

    public void loadUserFriends(String Id) {
        add(network.getUserFriends(App.token, Id)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                view::onSuccess,
                error -> view.showToast("Error Loading Friends " + error.getMessage())
            )
        );
    }

    public void loadUserMatches(String Id) {
        add(network.getUserMatches(App.token, Id)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                view::onSuccess,
                error -> view.showToast("Error Loading User Matches " + error.getMessage())
            )
        );
    }

    public void searchTracks(String title, String artist, String limit) {
        add(network.searchOnline(App.token, title, artist, limit)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                view::onSuccess,
                error -> view.showToast("Error Searching Tracks " + error.getMessage())
            )
        );
    }

    public void loadAddTrack(String Id, Track track) {
        add(network.postTrack(App.token, Id, track)
            .compose(RxUtils.applySchedulers())
            .doOnCompleted(view::onRefresh)
            .subscribe(
                tracks -> view.showToast("Track Added Successfully"),
                error -> view.showToast("Error Adding Track " + error.getMessage())
            )
        );
    }

    public void loadDelTrack(String trackId) {
        add(network.deleteTrack(App.token, trackId)
            .compose(RxUtils.applySchedulers())
            .doOnCompleted(view::onRefresh)
            .subscribe(
                tracks -> view.showToast("Track Deleted Successfully"),
                error -> view.showToast("Error Deleting Track " + error.getMessage())
            )
        );
    }

    public void loadAddFriend(String userId, String userTwoId) {
        add(network.postFriend(App.token, userId, userTwoId)
            .compose(RxUtils.applySchedulers())
            .doOnCompleted(view::onRefresh)
            .subscribe(
                friends -> view.showToast("Friend Added Successfully"),
                error -> view.showToast("Error Adding Friend " + error.getMessage())
            )
        );
    }

    public void loadDelFriend(String userId, String userTwoId) {
        add(network.deleteFriend(App.token, userId, userTwoId)
            .compose(RxUtils.applySchedulers())
            .doOnCompleted(view::onRefresh)
            .subscribe(
                friends -> view.showToast("Friend Deleted Successfully"),
                error -> view.showToast("Error Deleting Friend " + error.getMessage())
            )
        );
    }

    public List<?> localQuery(List<?> items, String query) {
        return null;
//        return Stream.of(items)
//            .filter(item -> StringUtils.contains(item.toString(), query))
//            .collect(com.annimon.stream.Collectors.toList());
    }

    public void goToUser(String id) {
        flow.goToUserProfile(id);
    }
}
