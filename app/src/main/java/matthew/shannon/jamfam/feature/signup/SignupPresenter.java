package matthew.shannon.jamfam.feature.signup;

import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.utils.RxUtils;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

public class SignupPresenter extends BasePresenter {

    private final SignupView view;
    private final NetworkService network;
    private final FlowService flow;

    public SignupPresenter(SignupView view, NetworkService network, FlowService flow) {
        this.view = view;
        this.network = network;
        this.flow = flow;
    }

    public void signup(User user) {
        view.toggleSpinner(true);
        add(network.postUser(user)
            .compose(RxUtils.applySchedulers())
            .subscribe(
                res -> {
                    view.toggleSpinner(false);
                    goToAccess();
                },
                error -> {
                    view.toggleSpinner(false);
                    view.showToast("The email address is already in use by another account");
                }
            )
        );
    }

    public void goToAccess() {
       flow.goToAccessActivity();
    }
}
