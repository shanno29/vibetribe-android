package matthew.shannon.jamfam.model.remote.location;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.location.Location;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.tbruyelle.rxpermissions.RxPermissions;
import matthew.shannon.jamfam.R;
import pl.charmas.android.reactivelocation.ReactiveLocationProvider;
import rx.Observable;
import rx_activity_result.RxActivityResult;

public class LocationManager implements LocationService {
    private final ReactiveLocationProvider locationProvider;
    private final LocationSettingsRequest settingsRequest;
    private final LocationRequest locationRequest;

    public LocationManager(ReactiveLocationProvider locationProvider, LocationSettingsRequest settingsRequest, LocationRequest locationRequest) {
        this.locationProvider = locationProvider;
        this.settingsRequest = settingsRequest;
        this.locationRequest = locationRequest;
    }

    @Override
    public Observable<Location> getLastLocation() {
        return locationProvider.getLastKnownLocation();
    }

    @Override
    public Observable<Location> getUpdatedLocation() {
        return locationProvider.getUpdatedLocation(locationRequest);
    }

    @Override
    public Observable<LocationSettingsResult> getLocationSettingsResult() {
        return locationProvider.checkLocationSettings(settingsRequest);
    }

    @Override
    public void startCheck(AppCompatActivity activity) {
        checkLocationPermissions(activity);
    }

    @Override
    public void checkLocationPermissions(AppCompatActivity activity) {
        RxPermissions.getInstance(activity).request(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION).subscribe(granted -> {
            if (!granted) {
                this.checkLocationPermissions(activity);
            } else {
                checkLocationSettings(activity);
            }
        });
    }

    @Override
    public void checkLocationSettings(AppCompatActivity activity) {
        getLocationSettingsResult().subscribe(result -> {
            if (result.getStatus().getStatusCode() != LocationSettingsStatusCodes.SUCCESS) {
                if (result.getStatus().hasResolution()) {
                    RxActivityResult.on(activity).startIntentSender(result.getStatus().getResolution().getIntentSender(), new Intent(), 0, 0, 0).subscribe(appCompatActivityResult -> {
                        checkLocationSettings(activity);
                    });
                } else {
                    activity.finish();
                }
            } else {
                checkAccess(activity);
            }
        });
    }

    @Override
    public void checkAccess(AppCompatActivity activity) {
        ContentResolver contentResolver = activity.getContentResolver();
        String enabledNotificationListeners = Settings.Secure.getString(contentResolver, "enabled_notification_listeners");
        if (enabledNotificationListeners == null || !enabledNotificationListeners.contains(activity.getPackageName())) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
            dialog.setPositiveButton("Ok", (dialogInterface, i) -> goToAccessScreen(activity));
            dialog.setMessage(R.string.access_text);
            dialog.setCancelable(false);
            dialog.show();
        } else {
            checkIfMetaServiceRunning(activity);
        }
    }

    @Override
    public void goToAccessScreen(AppCompatActivity activity) {
        RxActivityResult.on(activity).startIntent(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")).subscribe(appCompatActivityResult -> {
            checkAccess(activity);
        });
    }

    @Override
    public void checkIfMetaServiceRunning(AppCompatActivity activity) {
        //activity.startService(new Intent(activity, MetadataView.class));
    }

}




