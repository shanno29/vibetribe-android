package matthew.shannon.jamfam.presenter.activity;

import android.content.Intent;
import matthew.shannon.jamfam.presenter.BasePresenter;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.view.activity.AccessView;
import matthew.shannon.jamfam.view.utils.RxUtils;
import rx_activity_result.RxActivityResult;

public class AccessPresenter extends BasePresenter {
    private final RxActivityResult.Builder<AccessView> settings;
    private final FlowService flow;
    private final AccessView view;

    public AccessPresenter(AccessView view, FlowService flow, RxActivityResult.Builder<AccessView> settings) {
        this.settings = settings;
        this.flow = flow;
        this.view = view;
    }

    public void checkAccess(){
        if (flow.checkServiceStatus()) flow.goToLoginActivity();
        else {
            settings.startIntent(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
                .compose(RxUtils.applySchedulers())
                .subscribe(
                    res -> { if (flow.checkServiceStatus()) flow.goToLoginActivity();},
                    error -> view.showToast("Error Checking Notification Access")
                );
        }
    }

}