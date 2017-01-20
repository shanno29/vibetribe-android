package matthew.shannon.jamfam.model.data;

import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.common.GoogleApiAvailability;

public class GoogleAPI {
    private final AppCompatActivity activity;
    private final GoogleApiAvailability api;

    public GoogleAPI(AppCompatActivity activity, GoogleApiAvailability api) {
        this.activity = activity;
        this.api = api;
    }

    public int getResultCode() {
       return api.isGooglePlayServicesAvailable(activity);
    }

    public boolean isResolvable(int code){
        return api.isUserResolvableError(code);
    }

    public void showErrorDialog(int code){
        api.getErrorDialog(activity, code, 900).show();
    }

}
