package matthew.shannon.jamfam;

import android.app.Activity;
import android.app.Service;
import android.support.v4.app.Fragment;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Provider;
import matthew.shannon.jamfam.inject.activity.ActivityComponentBuilder;
import matthew.shannon.jamfam.inject.fragment.FragmentComponentBuilder;
import matthew.shannon.jamfam.inject.service.ServiceComponentBuilder;

public class MockApp extends App {

    public void putActivityComponentBuilder(final ActivityComponentBuilder builder, Class<? extends Activity> cls) {
        Map<Class<? extends Activity>, Provider<ActivityComponentBuilder>> activityComponentBuilders = new HashMap<>(this.activityBuilders);
        activityComponentBuilders.put(cls, () -> builder);
        this.activityBuilders = activityComponentBuilders;
    }

    public void putFragmentComponentBuilder(final FragmentComponentBuilder builder, Class<? extends Fragment> cls) {
        Map<Class<? extends Fragment>, Provider<FragmentComponentBuilder>> fragmentComponentBuilders = new HashMap<>(this.fragmentBuilders);
        fragmentComponentBuilders.put(cls, () -> builder);
        this.fragmentBuilders = fragmentComponentBuilders;
    }

    public void putServiceComponentBuilder(final ServiceComponentBuilder builder, Class<? extends Service> cls) {
        Map<Class<? extends Service>, Provider<ServiceComponentBuilder>> serviceComponentBuilders = new HashMap<>(this.serviceBuilders);
        serviceComponentBuilders.put(cls, () -> builder);
        this.serviceBuilders = serviceComponentBuilders;
    }
    
}