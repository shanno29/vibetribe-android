package matthew.shannon.jamfam.inject.app.module;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.inject.fragment.component.ListComponent;
import matthew.shannon.jamfam.view.fragment.ListView;
import matthew.shannon.jamfam.inject.fragment.component.MapComponent;
import matthew.shannon.jamfam.view.fragment.MapView;
import matthew.shannon.jamfam.inject.fragment.component.TrackComponent;
import matthew.shannon.jamfam.view.fragment.TrackView;
import matthew.shannon.jamfam.inject.fragment.component.UserInfoComponent;
import matthew.shannon.jamfam.view.fragment.UserInfoView;
import matthew.shannon.jamfam.inject.fragment.component.FragmentComponentBuilder;
import matthew.shannon.jamfam.inject.fragment.scope.FragmentKey;

@Module(
    subcomponents = {
        MapComponent.class,
        TrackComponent.class,
        UserInfoComponent.class,
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
    @FragmentKey(UserInfoView.class)
    public abstract FragmentComponentBuilder UsrInfoComponentBuilder(UserInfoComponent.Builder impl);

    @Binds
    @IntoMap
    @FragmentKey(ListView.class)
    public abstract FragmentComponentBuilder ListComponentBuilder(ListComponent.Builder impl);

}