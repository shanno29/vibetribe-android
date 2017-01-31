package matthew.shannon.jamfam.feature.profile.info;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.User;
import matthew.shannon.jamfam.service.cache.CacheService;

@Module
public class InfoModule {

    private InfoView fragment;

    public InfoModule(InfoView fragment) {
        this.fragment = fragment;
    }

    @Provides
    @InfoScope
    User user() {
        return new User();
    }

    @Provides
    @InfoScope
    InfoContract.View view() {
        return this.fragment;
    }

    @Provides
    @InfoScope
    InfoContract.Presenter presenter(CacheService cache, User user) {
        return new InfoPresenter(cache, fragment, user);
    }

}