package matthew.shannon.jamfam.feature.profile.info;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@Module
public class InfoModule {

    private InfoView fragment;

    public InfoModule(InfoView fragment) {
        this.fragment = fragment;
    }

    @Provides
    @InfoScope
    User user(){
        return new User();
    }

    @Provides
    @InfoScope
    InfoContract.View view(){
        return this.fragment;
    }

    @Provides
    @InfoScope
    InfoContract.Presenter presenter(NetworkService network, CacheService cache, User user) {
        return new InfoPresenter(network, cache, fragment, user);
    }

}