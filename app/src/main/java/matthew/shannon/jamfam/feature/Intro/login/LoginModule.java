package matthew.shannon.jamfam.feature.Intro.login;


import android.app.ProgressDialog;

import com.romainpiel.shimmer.Shimmer;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.User;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;

@Module
public class LoginModule {

    private LoginView activity;

    public LoginModule(LoginView activity) {
        this.activity = activity;
    }

    @Provides
    @LoginScope
    LoginContract.View loginView() {
        return this.activity;
    }

    @Provides
    @LoginScope
    LoginContract.Presenter presenter(LoginContract.View view, CacheService cache, FlowService flow) {
        return new LoginPresenter(view, cache, flow);

    }

    @Provides
    @LoginScope
    Shimmer provideShimmer() {
        Shimmer shimmer = new Shimmer();
        shimmer.setDuration(3000);
        return shimmer;
    }

    @Provides
    @LoginScope
    User user() {
        return new User();
    }

    @Provides
    @LoginScope
    ProgressDialog dialog() {
        return new ProgressDialog(activity);
    }

}