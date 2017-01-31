package matthew.shannon.jamfam.app;

import android.app.ActivityManager;
import android.app.Application;

import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.hwangjr.rxbus.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
    private Application app;

    public AppModule(Application app) {
        this.app = app;

    }

    @Provides
    @Singleton
    Application application() {
        return app;
    }

    @Provides
    @Singleton
    FlowService flowService(ActivityManager manager){
        return new FlowModel(app, manager);
    }

    @Provides
    @Singleton
    BusService busService(Bus bus){
        return new BusModel(bus);
    }

    @Provides
    @Singleton
    NetworkService networkService(Retrofit retrofit) {
        return new NetworkModel(retrofit);

    }

    @Provides
    @Singleton
    CacheService cacheService(RxSharedPreferences rxPrefs, CacheHelper<User> cacheHelper) {
        return new CacheModel(rxPrefs, cacheHelper);

    }

    @Provides
    @Singleton
    LocationService locationService(ReactiveLocationProvider locationProvider, LocationSettingsRequest settingsRequest, LocationRequest locationRequest) {
        return new LocationManager(locationProvider, settingsRequest, locationRequest);

    }


}