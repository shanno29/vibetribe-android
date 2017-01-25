package matthew.shannon.jamfam.inject.app;

import android.app.ActivityManager;
import android.app.Application;

import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.hwangjr.rxbus.Bus;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.bus.BusModel;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheHelper;
import matthew.shannon.jamfam.model.local.cache.CacheModel;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowModel;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.location.LocationManager;
import matthew.shannon.jamfam.model.remote.location.LocationService;
import matthew.shannon.jamfam.model.remote.network.NetworkModel;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import pl.charmas.android.reactivelocation.ReactiveLocationProvider;
import retrofit2.Retrofit;

@Module
public class AppModule {
    private final App app;

    public AppModule(App app) {
        this.app = app;

    }

    @Provides
    @AppScope
    Application application() {
        return app;
    }

    @Provides
    @AppScope
    FlowService flowService(ActivityManager manager){
        return new FlowModel(app, manager);
    }

    @Provides
    @AppScope
    BusService busService(Bus bus){
        return new BusModel(bus);
    }

    @Provides
    @AppScope
    NetworkService networkService(Retrofit retrofit) {
        return new NetworkModel(retrofit);

    }

    @Provides
    @AppScope
    CacheService cacheService(RxSharedPreferences rxPrefs, CacheHelper<User> cacheHelper) {
        return new CacheModel(rxPrefs, cacheHelper);

    }

    @Provides
    @AppScope
    LocationService locationService(ReactiveLocationProvider locationProvider, LocationSettingsRequest settingsRequest, LocationRequest locationRequest) {
        return new LocationManager(locationProvider, settingsRequest, locationRequest);

    }


}