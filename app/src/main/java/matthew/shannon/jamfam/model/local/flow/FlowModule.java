package matthew.shannon.jamfam.model.local.flow;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.inject.app.scope.AppScope;

@Module
public final class FlowModule {

    @Provides
    @AppScope
    ActivityManager activityManager(Application application){
        return (ActivityManager) application.getSystemService(Context.ACTIVITY_SERVICE);
    }

}
