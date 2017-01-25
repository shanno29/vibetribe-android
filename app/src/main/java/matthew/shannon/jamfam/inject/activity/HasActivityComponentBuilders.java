package matthew.shannon.jamfam.inject.activity;

import android.app.Activity;

public interface HasActivityComponentBuilders {
    ActivityComponentBuilder getActivityBuilders(Class<? extends Activity> activityClass);
}