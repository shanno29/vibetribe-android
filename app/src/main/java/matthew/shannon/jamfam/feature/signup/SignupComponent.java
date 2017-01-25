package matthew.shannon.jamfam.feature.signup;

import android.app.ProgressDialog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.inject.activity.ActivityComponent;
import matthew.shannon.jamfam.inject.activity.ActivityComponentBuilder;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@SignupComponent.SignupScope
@Subcomponent(modules = SignupComponent.SignupModule.class)
public interface SignupComponent extends ActivityComponent<SignupView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<SignupModule, SignupComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface SignupScope {}

    @Module
    class SignupModule extends ActivityModule<SignupView> {

        public SignupModule(SignupView activity) {
            super(activity);
        }

        @Provides
        @SignupScope
        SignupPresenter presenter(NetworkService network, FlowService flow) {
            return new SignupPresenter(activity, network, flow);

        }

        @Provides
        @SignupScope
        ProgressDialog dialog(){
            return new ProgressDialog(activity);
        }

    }

}