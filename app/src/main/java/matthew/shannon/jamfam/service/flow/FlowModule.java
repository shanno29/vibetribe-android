package matthew.shannon.jamfam.service.flow;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.hwangjr.rxbus.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class FlowModule {

    @Provides
    @Singleton
    Bus bus(){
        return new Bus();
    }

    @Provides
    @Singleton
    ActivityManager activityManager(Application application) {
        return (ActivityManager) application.getSystemService(Context.ACTIVITY_SERVICE);
    }

}
