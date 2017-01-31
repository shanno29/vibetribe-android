package matthew.shannon.jamfam.feature.message;

import matthew.shannon.jamfam.model.base.BasePresenter;
import matthew.shannon.jamfam.model.local.flow.FlowService;

public class MessagePresenter extends BasePresenter implements MessageContract.Presenter{
    private final FlowService flow;
    private final MessageContract.View view;

    public MessagePresenter(MessageContract.View view, FlowService flow) {
        this.flow = flow;
        this.view = view;
    }

}