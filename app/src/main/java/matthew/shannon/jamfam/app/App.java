package matthew.shannon.jamfam.app;

import android.app.Application;
import android.content.Context;

import com.fuck_boilerplate.rx_paparazzo.RxPaparazzo;

import matthew.shannon.jamfam.service.cache.CacheModule;
import matthew.shannon.jamfam.service.flow.FlowModule;
import matthew.shannon.jamfam.service.location.LocationModule;
import matthew.shannon.jamfam.service.network.NetworkModule;
import rx_activity_result.RxActivityResult;

public class App extends Application {

    public static String userID = null;
    public static String token = null;
    private AppComponent appComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();

    }

    @Override
    public void onCreate() {
        super.onCreate();
        RxActivityResult.register(this);
        RxPaparazzo.register(this);
        initAppComponent();


    }

    public void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .flowModule(new FlowModule())
                .cacheModule(new CacheModule())
                .networkModule(new NetworkModule())
                .locationModule(new LocationModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}