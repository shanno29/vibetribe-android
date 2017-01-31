package matthew.shannon.jamfam.service.location;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.location.LocationSettingsResult;

import rx.Observable;

public interface LocationService {
    Observable<Location> getLastLocation();

    Observable<Location> getUpdatedLocation();

    Observable<LocationSettingsResult> getLocationSettingsResult();

    void checkLocationPermissions(AppCompatActivity activity);

    void checkLocationSettings(AppCompatActivity activity);

    void startCheck(AppCompatActivity activity);

    void checkAccess(AppCompatActivity activity);

    void goToAccessScreen(AppCompatActivity activity);

    void checkIfMetaServiceRunning(AppCompatActivity activity);

}
