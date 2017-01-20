package matthew.shannon.jamfam.inject.fragment.component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.presenter.fragment.MapPresenter;
import matthew.shannon.jamfam.view.fragment.MapView;

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