package matthew.shannon.jamfam.inject.activity.component;

import android.app.ProgressDialog;
import com.romainpiel.shimmer.Shimmer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.presenter.activity.LoginPresenter;
import matthew.shannon.jamfam.view.activity.LoginView;

@LoginComponent.LoginScope
@Subcomponent(modules = LoginComponent.LoginModule.class)
public interface LoginComponent extends ActivityComponent<LoginView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<LoginComponent.LoginModule, LoginComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface LoginScope {}

    @Module
    class LoginModule extends ActivityModule<LoginView> {

        public LoginModule(LoginView activity) {
            super(activity);
        }

        @Provides
        @LoginScope
        LoginPresenter presenter(NetworkService network, CacheService cache, FlowService flow) {
            return new LoginPresenter(activity, network, cache, flow);

        }

        @Provides
        @LoginScope
        Shimmer provideShimmer(){
            Shimmer shimmer = new Shimmer();
            shimmer.setDuration(3000);
            return shimmer;
        }

        @Provides
        @LoginScope
        User user(){
            return new User();
        }

        @Provides
        @LoginScope
        ProgressDialog dialog(){
            return new ProgressDialog(activity);
        }

    }



}
