package matthew.shannon.jamfam.inject.activity;

import android.app.Activity;
import dagger.MapKey;

@MapKey
public @interface ActivityKey {
    Class<? extends Activity> value();
}