package matthew.shannon.jamfam.presenter.fragment;

import java.util.Objects;

import javax.inject.Inject;

import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.presenter.BasePresenter;
import matthew.shannon.jamfam.view.utils.RxUtils;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.view.fragment.UserInfoView;

public class UserInfoPresenter extends BasePresenter {
    private final NetworkService network;
    private final CacheService cache;
    private final UserInfoView view;
    private User user;

    public UserInfoPresenter(NetworkService network, CacheService cache, UserInfoView view, User user) {
        this.network = network;
        this.cache = cache;
        this.view = view;
        this.user = user;
    }

    public void loadGetUser(String ID) {
        add(network.getUser(App.token, ID)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                res -> {
                    if(Objects.equals(ID, App.userID)){
                        user = res.get(0);
                        cache.setOwner(user);
                        view.updateUI(user);
                    }

                },
                error -> view.showToast("Error Getting User"))
        );
    }

    public void updateUser(User updatedUser) {
        add(network.putUser(App.token, updatedUser.get_id(), updatedUser)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                user -> {
                    cache.setOwner(user);
                    view.updateUI(user);
                    view.showToast("About Me Updated");
                },
                error -> view.showToast("Error Updating About Me")
            )
        );
    }

}
