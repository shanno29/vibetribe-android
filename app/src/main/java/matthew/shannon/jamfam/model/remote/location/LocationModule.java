package matthew.shannon.jamfam.model.remote.location;

import android.app.Application;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.inject.app.AppScope;
import pl.charmas.android.reactivelocation.ReactiveLocationProvider;

@Module
public class LocationModule {

    @Provides
    @AppScope
    ReactiveLocationProvider reactiveLocationProvider(Application application) {
        return new ReactiveLocationProvider(application);
    }

    @Provides
    @AppScope
    LocationRequest locationRequest() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        locationRequest.setInterval(1000);
        return locationRequest;
    }

    @Provides
    @AppScope
    LocationSettingsRequest locationSettingsRequest(LocationRequest request) {
        LocationSettingsRequest.Builder locationSettingsRequest = new LocationSettingsRequest.Builder();
        locationSettingsRequest.addLocationRequest(request);
        locationSettingsRequest.setAlwaysShow(true);
        return locationSettingsRequest.build();
    }

}
