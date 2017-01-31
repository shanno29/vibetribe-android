package matthew.shannon.jamfam.utils;

import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class GoogleAPI {
    private final AppCompatActivity activity;
    private final GoogleApiAvailability api;

    public GoogleAPI(AppCompatActivity activity, GoogleApiAvailability api) {
        this.activity = activity;
        this.api = api;
    }

    public void getResultCode() {
       int code = api.isGooglePlayServicesAvailable(activity);
        if (code != ConnectionResult.SUCCESS && isResolvable(code)) showErrorDialog(code);

    }

    public boolean isResolvable(int code) {
        return api.isUserResolvableError(code);
    }

    public void showErrorDialog(int code) {
        api.getErrorDialog(activity, code, 900).show();
    }

}
