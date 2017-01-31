package matthew.shannon.jamfam.app;

import android.app.ActivityManager;
import android.app.Application;

import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.hwangjr.rxbus.Bus;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheHelper;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowModel;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.location.LocationService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import pl.charmas.android.reactivelocation.ReactiveLocationProvider;
import retrofit2.Retrofit;

@Module
public class MockAppModule {
    private final MockApp app;

    public MockAppModule(MockApp app) {
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
        FlowService service = Mockito.mock(FlowModel.class);
        return service;
    }

    @Provides
    @Singleton
    BusService busService(Bus bus){
        BusService service = Mockito.mock(BusService.class);
        return service;
    }

    @Provides
    @Singleton
    NetworkService networkService(Retrofit retrofit) {
        NetworkService service = Mockito.mock(NetworkService.class);
        return service;
    }

    @Provides
    @Singleton
    CacheService cacheService(RxSharedPreferences rxPrefs, CacheHelper<User> cacheHelper) {
        CacheService service = Mockito.mock(CacheService.class);
        return service;
    }

    @Provides
    @Singleton
    LocationService locationService(ReactiveLocationProvider locationProvider, LocationSettingsRequest settingsRequest, LocationRequest locationRequest) {
        LocationService service = Mockito.mock(LocationService.class);
        return service;
    }


}