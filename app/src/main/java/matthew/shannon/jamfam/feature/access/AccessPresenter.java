package matthew.shannon.jamfam.feature.access;

import android.content.Intent;
import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.utils.RxUtils;
import rx_activity_result.RxActivityResult;

public class AccessPresenter extends BasePresenter implements AccessContract.Presenter {
    private final RxActivityResult.Builder<AccessView> settings;
    private final FlowService flow;
    private final AccessContract.View view;

    public AccessPresenter(AccessContract.View view, FlowService flow, RxActivityResult.Builder<AccessView> settings) {
        this.settings = settings;
        this.flow = flow;
        this.view = view;
    }

    @Override
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