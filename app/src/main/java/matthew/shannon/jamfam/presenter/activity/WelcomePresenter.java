package matthew.shannon.jamfam.presenter.activity;

import com.google.android.gms.common.ConnectionResult;

import javax.inject.Inject;

import matthew.shannon.jamfam.view.activity.WelcomeView;
import matthew.shannon.jamfam.presenter.BasePresenter;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.data.GoogleAPI;

public class WelcomePresenter extends BasePresenter {
    private final GoogleAPI api;
    private final FlowService flow;
    private final WelcomeView view;

    public WelcomePresenter(GoogleAPI api, FlowService flow, WelcomeView view) {
        this.api = api;
        this.flow = flow;
        this.view = view;
    }

    public void checkGoogleApi(){
        int code = api.getResultCode();
        if (code != ConnectionResult.SUCCESS) {
            if (api.isResolvable(code)) api.showErrorDialog(code);
            else view.showToast("Unrecoverable Play Service Error");
        }
    }

    public void gotoSignup() {
        flow.goToSignupActivity();
    }
}