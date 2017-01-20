package matthew.shannon.jamfam.inject.app.component;

import dagger.Component;
import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.inject.app.module.AppModule;
import matthew.shannon.jamfam.model.local.bus.BusModule;
import matthew.shannon.jamfam.model.local.flow.FlowModule;
import matthew.shannon.jamfam.inject.app.module.ActivityBindingModule;
import matthew.shannon.jamfam.inject.app.scope.AppScope;
import matthew.shannon.jamfam.inject.app.module.FragmentBindingModule;
import matthew.shannon.jamfam.inject.app.module.ServiceBindingModule;
import matthew.shannon.jamfam.model.local.cache.CacheModule;
import matthew.shannon.jamfam.model.remote.location.LocationModule;
import matthew.shannon.jamfam.model.remote.network.NetworkModule;

@AppScope
@Component(modules = {
    AppModule.class,
    BusModule.class,
    NetworkModule.class,
    CacheModule.class,
    LocationModule.class,
    FlowModule.class,
    ActivityBindingModule.class,
    FragmentBindingModule.class,
    ServiceBindingModule.class,
})
public interface AppComponent {

    void inject(App app);



}