package matthew.shannon.jamfam.feature.home.map;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@Module
public class MapModule {

    private MapView fragment;

    public MapModule(MapView fragment) {
       this.fragment = fragment;
    }

    @Provides
    @MapScope
    MapContract.View view(){
        return this.fragment;
    }

    @Provides
    @MapScope
    MapContract.Presenter mapPresenter(NetworkService network, MapContract.View view) {
        return new MapPresenter(network, view);

    }

}