package matthew.shannon.jamfam.app;

import android.app.ActivityManager;
import android.app.Application;
import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import org.mockito.Mockito;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.User;
import matthew.shannon.jamfam.service.cache.CacheHelper;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowModel;
import matthew.shannon.jamfam.service.flow.FlowService;
import matthew.shannon.jamfam.service.location.LocationService;
import matthew.shannon.jamfam.service.network.NetworkService;
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