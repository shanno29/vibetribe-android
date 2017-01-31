package matthew.shannon.jamfam.app;

import com.fuck_boilerplate.rx_paparazzo.RxPaparazzo;

import matthew.shannon.jamfam.model.local.bus.BusModule;
import matthew.shannon.jamfam.model.local.cache.CacheModule;
import matthew.shannon.jamfam.model.local.flow.FlowModule;
import matthew.shannon.jamfam.model.remote.location.LocationModule;
import matthew.shannon.jamfam.model.remote.network.NetworkModule;
import rx_activity_result.RxActivityResult;

public class MockApp extends App {

    private MockAppComponent appComponent;
    public static String userID = null;
    public static String token = null;

    @Override public void onCreate() {
        super.onCreate();
        RxActivityResult.register(this);
        RxPaparazzo.register(this);
        initAppComponent();

    }

    public void initAppComponent() {
        appComponent = DaggerMockAppComponent.builder()
                .mockAppModule(new MockAppModule(this))
                .busModule(new BusModule())
                .flowModule(new FlowModule())
                .cacheModule(new CacheModule())
                .networkModule(new NetworkModule())
                .locationModule(new LocationModule())
                .build();
    }

    public AppComponent component(){
        return this.appComponent;
    }

}