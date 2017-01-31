package matthew.shannon.jamfam.feature.Intro.signup;

import android.app.ProgressDialog;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.service.flow.FlowService;

@Module
public class SignupModule {

    private SignupView activity;

    public SignupModule(SignupView activity) {
        this.activity = activity;
    }

    @Provides
    @SignupScope
    SignupContract.View signupView() {
        return this.activity;
    }

    @Provides
    @SignupScope
    SignupContract.Presenter signupPresenter(SignupContract.View view, FlowService flow) {
        return new SignupPresenter(view, flow);

    }

    @Provides
    @SignupScope
    ProgressDialog dialog() {
        return new ProgressDialog(activity);
    }

}