package matthew.shannon.jamfam.feature.login;

import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.utils.RxUtils;
import retrofit2.adapter.rxjava.HttpException;

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter {
    private final LoginContract.View view;
    private final NetworkService network;
    private final CacheService cache;
    private final FlowService flow;

    public LoginPresenter(LoginContract.View view, NetworkService network, CacheService cache, FlowService flow) {
        this.view = view;
        this.network = network;
        this.cache = cache;
        this.flow = flow;
    }

    @Override
    public void login(User user) {
        user.setType("android");
        user.setVersion(BuildConfig.VERSION_NAME);
        view.toggleSpinner(true);
        add(network.loginUser(user)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                res -> {
                    view.toggleSpinner(false);
                    App.userID = res.get_id();
                    App.token = "JWT " + res.getToken();
                    res.setPassword(user.getPassword());
                    cache.setOwner(user);
                    flow.goToHomeActivity();
                },
                error -> {
                    view.toggleSpinner(false);
                    if(error instanceof HttpException){
                        switch (((HttpException)error).code()){
                            case 404: flow.goToStore(); break;
                            case 204: view.showToast(error.getMessage()); break;
                        }
                    } else view.showToast("Incorrect Email or Password");
                }
            )
        );
    }

    @Override
    public void getInitialCheckbox() {
        if(cache.getCheckBox()) view.updateUI(cache.getOwner(), true);
    }

    @Override
    public void goToSignup() {
        flow.goToSignupActivity();
    }

    @Override
    public void setCheckBox(boolean b) {
        cache.setCheckBox(b);
    }

}