package matthew.shannon.jamfam.inject.fragment;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.list.ListComponent;
import matthew.shannon.jamfam.list.ListView;
import matthew.shannon.jamfam.feature.home.map.MapComponent;
import matthew.shannon.jamfam.feature.home.map.MapView;
import matthew.shannon.jamfam.feature.home.track.TrackComponent;
import matthew.shannon.jamfam.feature.home.track.TrackView;
import matthew.shannon.jamfam.feature.profile.info.InfoComponent;
import matthew.shannon.jamfam.feature.profile.info.InfoView;

@Module(
    subcomponents = {
        MapComponent.class,
        TrackComponent.class,
        InfoComponent.class,
        ListComponent.class,

    })
public abstract class FragmentBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(MapView.class)
    public abstract FragmentComponentBuilder MapComponentBuilder(MapComponent.Builder impl);

    @Binds
    @IntoMap
    @FragmentKey(TrackView.class)
    public abstract FragmentComponentBuilder TrackComponentBuilder(TrackComponent.Builder impl);

    @Binds
    @IntoMap
    @FragmentKey(InfoView.class)
    public abstract FragmentComponentBuilder UsrInfoComponentBuilder(InfoComponent.Builder impl);

    @Binds
    @IntoMap
    @FragmentKey(ListView.class)
    public abstract FragmentComponentBuilder ListComponentBuilder(ListComponent.Builder impl);

}