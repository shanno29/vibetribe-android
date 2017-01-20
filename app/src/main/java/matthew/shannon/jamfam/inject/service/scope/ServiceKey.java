package matthew.shannon.jamfam.inject.service.scope;

import android.app.Service;
import dagger.MapKey;

@MapKey
public @interface ServiceKey {
    Class<? extends Service> value();
}