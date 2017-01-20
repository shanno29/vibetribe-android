package matthew.shannon.jamfam.inject.fragment.component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.presenter.fragment.UserInfoPresenter;
import matthew.shannon.jamfam.view.fragment.UserInfoView;

@UserInfoComponent.UserInfoScope
@Subcomponent(modules = UserInfoComponent.UserInfoModule.class)
public interface UserInfoComponent extends FragmentComponent<UserInfoView> {

    @Subcomponent.Builder
    interface Builder extends FragmentComponentBuilder<UserInfoModule, UserInfoComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface UserInfoScope {}

    @Module
    class UserInfoModule extends FragmentModule<UserInfoView> {

        public UserInfoModule(UserInfoView fragment) {
            super(fragment);
        }

        @Provides
        @UserInfoScope
        User user(){
            return new User();
        }

        @Provides
        @UserInfoScope
        UserInfoPresenter presenter(NetworkService network, CacheService cache, User user) {
            return new UserInfoPresenter(network, cache, fragment, user);

        }

    }

}
