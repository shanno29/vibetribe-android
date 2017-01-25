package matthew.shannon.jamfam.feature.access;

import javax.inject.Inject;

import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.feature.access.AccessView;
import rx_activity_result.RxActivityResult;

public class AccessPresenter extends BasePresenter {
    private final RxActivityResult.Builder<AccessView> settings;
    private final FlowService flow;
    private final AccessView view;

    @Inject public AccessPresenter(AccessView view, FlowService flow, RxActivityResult.Builder<AccessView> settings) {
        this.settings = settings;
        this.flow = flow;
        this.view = view;
    }

    public void checkAccess(){
//        if (flow.checkServiceStatus()) flow.goToLoginActivity();
//        else {
//            settings.startIntent(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
//                .compose(RxUtils.applySchedulers())
//                .subscribe(
//                    res -> { if (flow.checkServiceStatus()) flow.goToLoginActivity();},
//                    error -> view.showToast("Error Checking Notification Access")
//                );
//        }
    }

}