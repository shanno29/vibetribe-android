package matthew.shannon.jamfam.model.local.flow;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class FlowModule {

    @Provides
    @Singleton
    ActivityManager activityManager(Application application){
        return (ActivityManager) application.getSystemService(Context.ACTIVITY_SERVICE);
    }

}
