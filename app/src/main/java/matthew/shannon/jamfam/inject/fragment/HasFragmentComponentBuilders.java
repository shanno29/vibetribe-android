package matthew.shannon.jamfam.inject.fragment;

import android.support.v4.app.Fragment;

public interface HasFragmentComponentBuilders {
    FragmentComponentBuilder getFragmentBuilders(Class<? extends Fragment> fragmentClass);
}