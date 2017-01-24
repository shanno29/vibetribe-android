package matthew.shannon.jamfam.presenter.activity;

import javax.inject.Inject;
import matthew.shannon.jamfam.inject.activity.scope.ActivityScope;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.presenter.BasePresenter;
import matthew.shannon.jamfam.view.activity.MessageView;

@ActivityScope
public class MessagePresenter extends BasePresenter {
    private final FlowService flow;
    private final MessageView view;

    @Inject public MessagePresenter(MessageView view, FlowService flow) {
        this.flow = flow;
        this.view = view;
    }

    public void checkMessage(){
//        if (flow.checkServiceStatus()) flow.goToLoginActivity();
//        else {
//            settings.startIntent(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
//                .compose(RxUtils.applySchedulers())
//                .subscribe(
//                    res -> { if (flow.checkServiceStatus()) flow.goToLoginActivity();},
//                    error -> view.showToast("Error Checking Notification Message")
//                );
//        }
    }

    public void init() {

    }
}