package matthew.shannon.jamfam.feature.Intro.login;

import android.util.Log;

import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.app.Utils;
import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.model.User;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;
import matthew.shannon.jamfam.service.network.NetworkService;
import retrofit2.adapter.rxjava.HttpException;

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter {
    private final LoginContract.View view;
    private final CacheService cache;
    private final NetworkService network;

    public LoginPresenter(LoginContract.View view, CacheService cache, NetworkService network) {
        this.view = view;
        this.cache = cache;
        this.network = network;
    }

    @Override
    public void login(User user) {
        user.setType("android");
        user.setVersion(BuildConfig.VERSION_NAME);
        view.toggleSpinner(true);
        add(network.loginUser(user)
            .compose(Utils.applySchedulers())
            .subscribe(
                res -> {
                    view.toggleSpinner(false);
                    App.userID = res.get_id();
                    App.token = "JWT " + res.getToken();
                    res.setPassword(user.getPassword());
                    cache.setOwner(user);
                    view.goToHomeActivity();
                },
                error -> {
                    view.toggleSpinner(false);
                    if (error instanceof HttpException) {
                        int code = ((HttpException) error).code();
                        Log.d("LOGIN", error.toString());
                        if (code == 404) view.goToStore();
                        else view.showToast("Incorrect Login Info");
                    }
                }
            )
        );
    }

    @Override
    public void getInitialCheckbox() {
        if (cache.getCheckBox()) view.updateUI(cache.getOwner(), true);
    }



    @Override
    public void setCheckBox(boolean b) {
        cache.setCheckBox(b);
    }

}