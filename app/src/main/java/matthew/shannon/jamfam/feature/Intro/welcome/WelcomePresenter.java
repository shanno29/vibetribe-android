package matthew.shannon.jamfam.feature.Intro.welcome;

import matthew.shannon.jamfam.base.BasePresenter;
import matthew.shannon.jamfam.service.flow.FlowService;
import matthew.shannon.jamfam.util.GoogleAPI;

public class WelcomePresenter extends BasePresenter implements WelcomeContract.Presenter {
    private final GoogleAPI api;
    private final FlowService flow;

    public WelcomePresenter(GoogleAPI api, FlowService flow) {
        this.api = api;
        this.flow = flow;
    }

    @Override
    public void checkGoogleApi() {
       api.getResultCode();
    }

    @Override
    public void gotoSignup() {
        flow.goToSignupActivity();
    }
}