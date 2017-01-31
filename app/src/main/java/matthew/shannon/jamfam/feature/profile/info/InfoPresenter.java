package matthew.shannon.jamfam.feature.profile.info;

import java.util.Objects;

import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.utils.RxUtils;

public class InfoPresenter extends BasePresenter implements InfoContract.Presenter {
    private final NetworkService network;
    private final CacheService cache;
    private final InfoContract.View view;
    private User user;

    public InfoPresenter(NetworkService network, CacheService cache, InfoContract.View view, User user) {
        this.network = network;
        this.cache = cache;
        this.view = view;
        this.user = user;
    }

    @Override
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

    @Override
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
