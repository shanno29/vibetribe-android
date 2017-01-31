package matthew.shannon.jamfam.feature.home.map;

import dagger.Module;
import dagger.Provides;

@Module
public class MapModule {

    private MapView fragment;

    public MapModule(MapView fragment) {
        this.fragment = fragment;
    }

    @Provides
    @MapScope
    MapContract.View view() {
        return this.fragment;
    }

    @Provides
    @MapScope
    MapContract.Presenter mapPresenter(MapContract.View view) {
        return new MapPresenter(view);

    }

}