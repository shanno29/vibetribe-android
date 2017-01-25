package matthew.shannon.jamfam.model.local.bus;

import com.hwangjr.rxbus.Bus;
import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.inject.app.AppScope;

@Module
public final class BusModule {

    @Provides
    @AppScope
    Bus bus() { return new Bus(); }

}
