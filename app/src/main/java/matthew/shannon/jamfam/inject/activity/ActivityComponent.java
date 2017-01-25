package matthew.shannon.jamfam.inject.activity;

import android.support.v7.app.AppCompatActivity;
import dagger.MembersInjector;
import dagger.Module;
import dagger.Provides;

public interface ActivityComponent<A extends AppCompatActivity> extends MembersInjector<A> {

    @Module
    abstract class ActivityModule<T> {
        protected final T activity;

        public ActivityModule(T activity) {
            this.activity = activity;
        }

        @Provides
        @ActivityScope
        T provideActivity() {
            return activity;
        }

    }
}