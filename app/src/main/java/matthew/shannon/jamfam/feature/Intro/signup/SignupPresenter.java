package matthew.shannon.jamfam.feature.Intro.signup;

import matthew.shannon.jamfam.app.Utils;
import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.model.User;
import matthew.shannon.jamfam.service.network.NetworkService;

public class SignupPresenter extends BasePresenter implements SignupContract.Presenter {

    private final SignupContract.View view;
    private final NetworkService network;

    public SignupPresenter(SignupContract.View view, NetworkService network) {
        this.view = view;
        this.network = network;
    }

    @Override
    public void signup(User user) {
        view.toggleSpinner(true);
        add(network.postUser(user)
            .compose(Utils.applySchedulers())
            .subscribe(
                res -> {
                    view.toggleSpinner(false);
                    view.goToAccess();
                },
                error -> {
                    view.toggleSpinner(false);
                    view.showToast("The email address is already in use by another account");
                }
            )
        );
    }



}
