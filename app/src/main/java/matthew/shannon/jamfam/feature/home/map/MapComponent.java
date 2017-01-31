package matthew.shannon.jamfam.feature.home.map;


import dagger.Subcomponent;

@MapScope
@Subcomponent(modules = MapModule.class)
public interface MapComponent {

    MapView inject(MapView activity);


}