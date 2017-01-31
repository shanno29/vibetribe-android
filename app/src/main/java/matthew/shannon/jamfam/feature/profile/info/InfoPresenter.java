package matthew.shannon.jamfam.feature.profile.info;

import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.service.cache.CacheService;

public class InfoPresenter extends BasePresenter implements InfoContract.Presenter {
    private final CacheService cache;
    private final InfoContract.View view;
    private User user;

    public InfoPresenter(CacheService cache, InfoContract.View view, User user) {
        this.cache = cache;
        this.view = view;
        this.user = user;
    }

    @Override
    public void loadGetUser(String ID) {
//        add(network.getUser(App.token, ID)
//                .compose(RxUtils.applySchedulers())
//                .subscribe(
//                        res -> {
//                            if (Objects.equals(ID, App.userID)) {
//                                user = res.get(0);
//                                cache.setOwner(user);
//                                view.updateUI(user);
//                            }
//
//                        },
//                        error -> view.showToast("Error Getting User"))
//        );
    }

    @Override
    public void updateUser(User updatedUser) {
//        add(network.putUser(App.token, updatedUser.get_id(), updatedUser)
//                .compose(RxUtils.applySchedulers())
//                .subscribe(
//                        user -> {
//                            cache.setOwner(user);
//                            view.updateUI(user);
//                            view.showToast("About Me Updated");
//                        },
//                        error -> view.showToast("Error Updating About Me")
//                )
//        );
    }

}
