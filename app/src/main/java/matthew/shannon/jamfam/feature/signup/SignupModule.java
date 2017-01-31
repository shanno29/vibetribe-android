package matthew.shannon.jamfam.feature.signup;

import android.app.ProgressDialog;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@Module
public class SignupModule  {

    private SignupView activity;

    public SignupModule(SignupView activity) {
        this.activity = activity;
    }

    @Provides
    @SignupScope
    SignupContract.View signupView(){
        return this.activity;
    }

    @Provides
    @SignupScope
    SignupContract.Presenter signupPresenter(SignupContract.View view, NetworkService network, FlowService flow) {
        return new SignupPresenter(view, network, flow);

    }

    @Provides
    @SignupScope
    ProgressDialog dialog(){
        return new ProgressDialog(activity);
    }

}