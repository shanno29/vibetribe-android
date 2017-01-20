package matthew.shannon.jamfam.model.local.cache;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.v7.preference.PreferenceManager;

import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.inject.app.scope.AppScope;
import matthew.shannon.jamfam.model.data.User;


@Module
public final class CacheModule {

    @Provides
    @AppScope
    SharedPreferences sharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @AppScope
    RxSharedPreferences rxSharedPreferences(SharedPreferences sharedPreferences){
        return RxSharedPreferences.create(sharedPreferences);
    }

    @Provides
    @AppScope
    CacheHelper<User> cacheHelper(Gson gson){
        return new CacheHelper<>(gson, User.class);
    }

}
