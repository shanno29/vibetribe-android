package matthew.shannon.jamfam.inject.service.component;

import android.app.Service;

import dagger.MembersInjector;
import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.inject.service.scope.ServiceScope;

public interface ServiceComponent<A extends Service> extends MembersInjector<A> {
    @Module
    public abstract class ServiceModule<T> {
        protected final T service;

        public ServiceModule(T service) {
            this.service = service;
        }

        @Provides
        @ServiceScope
        T provideService() {
            return service;
        }

    }
}