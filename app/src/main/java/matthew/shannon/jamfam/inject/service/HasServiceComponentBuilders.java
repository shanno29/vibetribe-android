package matthew.shannon.jamfam.inject.service;

import android.app.Service;

public interface HasServiceComponentBuilders {
    ServiceComponentBuilder getServiceBuilders(Class<? extends Service> serviceClass);
}