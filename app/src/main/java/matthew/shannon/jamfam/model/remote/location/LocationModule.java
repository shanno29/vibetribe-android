package matthew.shannon.jamfam.model.remote.location;

import android.app.Application;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.charmas.android.reactivelocation.ReactiveLocationProvider;

@Module
public class LocationModule {

    @Provides
    @Singleton
    ReactiveLocationProvider reactiveLocationProvider(Application application) {
        return new ReactiveLocationProvider(application);
    }

    @Provides
    @Singleton
    LocationRequest locationRequest() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        locationRequest.setInterval(1000);
        return locationRequest;
    }

    @Provides
    @Singleton
    LocationSettingsRequest locationSettingsRequest(LocationRequest request) {
        LocationSettingsRequest.Builder locationSettingsRequest = new LocationSettingsRequest.Builder();
        locationSettingsRequest.addLocationRequest(request);
        locationSettingsRequest.setAlwaysShow(true);
        return locationSettingsRequest.build();
    }

}
