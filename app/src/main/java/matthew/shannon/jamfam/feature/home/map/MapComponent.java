package matthew.shannon.jamfam.feature.home.map;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.inject.fragment.FragmentComponent;
import matthew.shannon.jamfam.inject.fragment.FragmentComponentBuilder;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@MapComponent.MapScope
@Subcomponent(modules = MapComponent.MapModule.class)
public interface MapComponent extends FragmentComponent<MapView> {

    @Subcomponent.Builder
    interface Builder extends FragmentComponentBuilder<MapModule, MapComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface MapScope {}

    @Module
    class MapModule extends FragmentModule<MapView> {

        public MapModule(MapView fragment) {
            super(fragment);
        }

        @Provides
        @MapScope
        MapPresenter mapPresenter(NetworkService network) {
            return new MapPresenter(network, fragment);

        }

    }

}