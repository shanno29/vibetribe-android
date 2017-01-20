package matthew.shannon.jamfam.inject.service.component;

import android.app.Service;

public interface HasServiceComponentBuilders {
    ServiceComponentBuilder getServiceBuilders(Class<? extends Service> serviceClass);
}