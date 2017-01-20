package matthew.shannon.jamfam.inject.fragment.scope;

import android.support.v4.app.Fragment;
import dagger.MapKey;

@MapKey
public @interface FragmentKey {
    Class<? extends Fragment> value();
}