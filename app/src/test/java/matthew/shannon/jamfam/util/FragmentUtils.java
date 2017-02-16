package matthew.shannon.jamfam.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class FragmentUtils {

    public static void startFragment(FragmentActivity parentActivity, Fragment fragment) {
        FragmentManager fragmentManager = parentActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragment, null);
        fragmentTransaction.commit();
    }

    public static void endFragment(FragmentActivity parentActivity, Fragment fragment) {
        FragmentManager fragmentManager = parentActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

}
