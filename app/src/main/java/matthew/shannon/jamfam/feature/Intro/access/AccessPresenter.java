package matthew.shannon.jamfam.feature.Intro.access;

import matthew.shannon.jamfam.base.BasePresenter;

public class AccessPresenter extends BasePresenter implements AccessContract.Presenter {
    private final AccessContract.View view;

    public AccessPresenter(AccessContract.View view) {
        this.view = view;
    }

}