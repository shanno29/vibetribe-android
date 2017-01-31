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
import matthew.shannon.jamfam.model.User;
import matthew.shannon.jamfam.service.cache.CacheHelper;
import matthew.shannon.jamfam.service.cache.CacheModel;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowModel;
import matthew.shannon.jamfam.service.flow.FlowService;
import matthew.shannon.jamfam.service.location.LocationManager;
import matthew.shannon.jamfam.service.location.LocationService;
import matthew.shannon.jamfam.service.network.NetworkModel;
import matthew.shannon.jamfam.service.network.NetworkService;
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
    FlowService flowService(ActivityManager manager, Bus bus) {
        return new FlowModel(app, manager, bus);
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