package matthew.shannon.jamfam.feature.Intro.signup;

import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.model.User;
import matthew.shannon.jamfam.service.flow.FlowService;

public class SignupPresenter extends BasePresenter implements SignupContract.Presenter {

    private final SignupContract.View view;
    private final FlowService flow;

    public SignupPresenter(SignupContract.View view, FlowService flow) {
        this.view = view;
        this.flow = flow;
    }

    @Override
    public void signup(User user) {
//        view.toggleSpinner(true);
//        add(network.postUser(user)
//            .compose(RxUtils.applySchedulers())
//            .subscribe(
//                res -> {
//                    view.toggleSpinner(false);
//                    goToAccess();
//                },
//                error -> {
//                    view.toggleSpinner(false);
//                    view.showToast("The email address is already in use by another account");
//                }
//            )
//        );
    }

    @Override
    public void goToAccess() {
        flow.goToAccessActivity();
    }

}
