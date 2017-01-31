package matthew.shannon.jamfam.model.local.bus;

import com.hwangjr.rxbus.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class BusModule {

    @Provides
    @Singleton
    Bus bus() { return new Bus(); }

}
