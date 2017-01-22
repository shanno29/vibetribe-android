package matthew.shannon.jamfam;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.support.v4.app.Fragment;
import com.fuck_boilerplate.rx_paparazzo.RxPaparazzo;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import matthew.shannon.jamfam.inject.activity.component.ActivityComponentBuilder;
import matthew.shannon.jamfam.inject.activity.component.HasActivityComponentBuilders;
import matthew.shannon.jamfam.inject.app.component.AppComponent;
import matthew.shannon.jamfam.inject.app.component.DaggerAppComponent;
import matthew.shannon.jamfam.inject.app.module.AppModule;
import matthew.shannon.jamfam.inject.fragment.component.FragmentComponentBuilder;
import matthew.shannon.jamfam.inject.fragment.component.HasFragmentComponentBuilders;
import matthew.shannon.jamfam.inject.service.component.HasServiceComponentBuilders;
import matthew.shannon.jamfam.inject.service.component.ServiceComponentBuilder;
import matthew.shannon.jamfam.model.local.bus.BusModule;
import matthew.shannon.jamfam.model.local.cache.CacheModule;
import matthew.shannon.jamfam.model.local.flow.FlowModule;
import matthew.shannon.jamfam.model.remote.location.LocationModule;
import matthew.shannon.jamfam.model.remote.network.NetworkModule;
import rx_activity_result.RxActivityResult;

public class App extends Application implements HasActivityComponentBuilders, HasFragmentComponentBuilders, HasServiceComponentBuilders {
    @Inject Map<Class<? extends Activity>, Provider<ActivityComponentBuilder>> activityBuilders;
    @Inject Map<Class<? extends Fragment>, Provider<FragmentComponentBuilder>> fragmentBuilders;
    @Inject Map<Class<? extends Service>, Provider<ServiceComponentBuilder>> serviceBuilders;

    public static String userID = null;
    public static String token = null;

    @Override public void onCreate() {
        super.onCreate();
        RxActivityResult.register(this);
        RxPaparazzo.register(this);
        createAppComponent();
    }

    private void createAppComponent(){
        AppComponent component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .busModule(new BusModule())
                .flowModule(new FlowModule())
                .cacheModule(new CacheModule())
                .networkModule(new NetworkModule())
                .locationModule(new LocationModule())
                .build();
        component.inject(this);
    }

    public static HasActivityComponentBuilders getActivity(Context context) {
        return ((HasActivityComponentBuilders) context.getApplicationContext());
    }

    public static HasFragmentComponentBuilders getFragment(Context context) {
        return ((HasFragmentComponentBuilders) context.getApplicationContext());
    }

    public static HasServiceComponentBuilders getService(Context context) {
        return ((HasServiceComponentBuilders) context.getApplicationContext());
    }

    @Override
    public ActivityComponentBuilder getActivityBuilders(Class<? extends Activity> activityClass) {
        return activityBuilders.get(activityClass).get();
    }

    @Override
    public FragmentComponentBuilder getFragmentBuilders(Class<? extends Fragment> fragmentClass) {
        return fragmentBuilders.get(fragmentClass).get();
    }

    @Override
    public ServiceComponentBuilder getServiceBuilders(Class<? extends Service> serviceClass) {
        return serviceBuilders.get(serviceClass).get();
    }

}