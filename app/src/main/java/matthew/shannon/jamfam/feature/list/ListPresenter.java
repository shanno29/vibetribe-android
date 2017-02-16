package matthew.shannon.jamfam.feature.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.app.Utils;
import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;
import matthew.shannon.jamfam.service.network.NetworkService;

public class ListPresenter extends BasePresenter implements ListContract.Presenter {
    private final NetworkService network;
    private final CacheService cache;
    private final FlowService flow;
    private final ListContract.View view;


    public ListPresenter(NetworkService network, CacheService cache, FlowService flow, ListContract.View view) {
        this.network = network;
        this.cache = cache;
        this.flow = flow;
        this.view = view;
    }

    @Override
    public void loadSettings(String Id) {
//        add(cache.getUserSettings(Id)
//                .compose(Utils.applySchedulers())
//                .subscribe(
//                        view::onContent,
//                        error -> view.showToast("Error Loading Settings " + error.getMessage())
//                )
//        );
    }

    @Override
    public void loadAllTracks() {
        add(network.getAllTracks(App.token)
                .compose(Utils.applySchedulers())
                .subscribe(
                        view::onContent,
                        error -> view.showToast("Error Loading Tracks " + error.getMessage())
                )
        );
    }

    @Override
    public void loadFriendsTracks(String Id) {
        add(network.getFriendsTracks(App.token, Id)
                .compose(Utils.applySchedulers())
                .subscribe(
                        view::onContent,
                        error -> view.showToast("Error Loading Friends Tracks " + error.getMessage())
                )
        );
    }

    @Override
    public void loadUserTracks(String Id) {
        add(network.getUserTracks(App.token, Id)
                .compose(Utils.applySchedulers())
                .subscribe(
                        view::onContent,
                        error -> view.showToast("Error Loading User Tracks " + error.getMessage())
                )
        );
    }

    @Override
    public void loadAllUsers() {
        add(network.getAllUsers(App.token)
                .compose(Utils.applySchedulers())
                .subscribe(
                        view::onContent,
                        error -> view.showToast("Error Loading All Users " + error.getMessage())
                )
        );
    }

    @Override
    public void loadUserFriends(String Id) {
        add(network.getUserFriends(App.token, Id)
                .compose(Utils.applySchedulers())
                .subscribe(
                        view::onContent,
                        error -> view.showToast("Error Loading Friends " + error.getMessage())
                )
        );
    }

    @Override
    public void loadUserMatches(String Id) {
        add(network.getUserMatches(App.token, Id)
                .compose(Utils.applySchedulers())
                .subscribe(
                        view::onContent,
                        error -> view.showToast("Error Loading User Matches " + error.getMessage())
                )
        );
    }

    @Override
    public void searchTracks(String title, String artist, String limit) {
        add(network.searchOnline(App.token, title + " " + artist, limit)
                .compose(Utils.applySchedulers())
                .subscribe(
                        view::onContent,
                        error -> view.showToast("Error Searching Tracks " + error.getMessage())
                )
        );
    }

    @Override
    public void loadAddTrack(String Id, Track track) {
        add(network.postTrack(App.token, track)
                .compose(Utils.applySchedulers())
                .doOnCompleted(view::onRefresh)
                .subscribe(
                        tracks -> view.showToast("Track Added Successfully"),
                        error -> view.showToast("Error Adding Track " + error.getMessage())
                )
        );
    }

    @Override
    public void loadDelTrack(String trackId) {
        add(network.deleteTrack(App.token, trackId)
                .compose(Utils.applySchedulers())
                .doOnCompleted(view::onRefresh)
                .subscribe(
                        tracks -> view.showToast("Track Deleted Successfully"),
                        error -> view.showToast("Error Deleting Track " + error.getMessage())
                )
        );
    }

    @Override
    public void loadAddFriend(String userId, String userTwoId) {
        add(network.postFriend(App.token, Arrays.asList(userId, userTwoId))
                .compose(Utils.applySchedulers())
                .doOnCompleted(view::onRefresh)
                .subscribe(
                        friends -> view.showToast("Friend Added Successfully"),
                        error -> view.showToast("Error Adding Friend " + error.getMessage())
                )
        );
    }

    @Override
    public void loadDelFriend(String friendId) {
        add(network.deleteFriend(App.token, friendId)
                .compose(Utils.applySchedulers())
                .doOnCompleted(view::onRefresh)
                .subscribe(
                        friends -> view.showToast("Friend Deleted Successfully"),
                        error -> view.showToast("Error Deleting Friend " + error.getMessage())
                )
        );
    }

    @Override
    public List<?> localQuery(List<?> items, String query) {
        return null;
//        return Stream.of(items)
//            .filter(item -> Utils.contains(item.toString(), query))
//            .collect(com.annimon.stream.Collectors.toList());
    }

    @Override
    public void goToUser(String id) {
        flow.goToUserProfile(id);
    }
}
