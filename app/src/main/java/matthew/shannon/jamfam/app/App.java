package matthew.shannon.jamfam.app;

import android.app.Application;
import android.content.Context;
import com.fuck_boilerplate.rx_paparazzo.RxPaparazzo;
import matthew.shannon.jamfam.model.local.bus.BusModule;
import matthew.shannon.jamfam.model.local.cache.CacheModule;
import matthew.shannon.jamfam.model.local.flow.FlowModule;
import matthew.shannon.jamfam.model.remote.location.LocationModule;
import matthew.shannon.jamfam.model.remote.network.NetworkModule;
import rx_activity_result.RxActivityResult;

public class App extends Application {

    private AppComponent appComponent;
    public static String userID = null;
    public static String token = null;


    @Override public void onCreate() {
        super.onCreate();
        RxActivityResult.register(this);
        RxPaparazzo.register(this);
        initAppComponent();


    }

    public void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .busModule(new BusModule())
                .flowModule(new FlowModule())
                .cacheModule(new CacheModule())
                .networkModule(new NetworkModule())
                .locationModule(new LocationModule())
                .build();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();

    }


    public AppComponent getAppComponent(){
        return appComponent;
    }

}