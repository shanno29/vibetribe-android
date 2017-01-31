package matthew.shannon.jamfam.app;

import com.fuck_boilerplate.rx_paparazzo.RxPaparazzo;
import matthew.shannon.jamfam.service.cache.CacheModule;
import matthew.shannon.jamfam.service.flow.FlowModule;
import matthew.shannon.jamfam.service.location.LocationModule;
import matthew.shannon.jamfam.service.network.NetworkModule;
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