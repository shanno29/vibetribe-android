package matthew.shannon.jamfam.feature.profile.info;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.inject.fragment.FragmentComponent;
import matthew.shannon.jamfam.inject.fragment.FragmentComponentBuilder;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@InfoComponent.UserInfoScope
@Subcomponent(modules = InfoComponent.UserInfoModule.class)
public interface InfoComponent extends FragmentComponent<InfoView> {

    @Subcomponent.Builder
    interface Builder extends FragmentComponentBuilder<UserInfoModule, InfoComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface UserInfoScope {}

    @Module
    class UserInfoModule extends FragmentModule<InfoView> {

        public UserInfoModule(InfoView fragment) {
            super(fragment);
        }

        @Provides
        @UserInfoScope
        User user(){
            return new User();
        }

        @Provides
        @UserInfoScope
        InfoPresenter presenter(NetworkService network, CacheService cache, User user) {
            return new InfoPresenter(network, cache, fragment, user);

        }

    }

}
