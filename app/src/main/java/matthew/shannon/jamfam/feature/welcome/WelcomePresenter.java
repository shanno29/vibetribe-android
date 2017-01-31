package matthew.shannon.jamfam.feature.welcome;

import com.google.android.gms.common.ConnectionResult;

import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.utils.GoogleAPI;

public class WelcomePresenter extends BasePresenter implements WelcomeContract.Presenter {
    private final GoogleAPI api;
    private final FlowService flow;
    private final WelcomeContract.View view;

    public WelcomePresenter(GoogleAPI api, FlowService flow, WelcomeContract.View view) {
        this.api = api;
        this.flow = flow;
        this.view = view;
    }

    @Override
    public void checkGoogleApi(){
        int code = api.getResultCode();
        if (code != ConnectionResult.SUCCESS) {
            if (api.isResolvable(code)) api.showErrorDialog(code);
            else view.showToast("Unrecoverable Play Service Error");
        }
    }

    @Override
    public void gotoSignup() {
        flow.goToSignupActivity();
    }
}