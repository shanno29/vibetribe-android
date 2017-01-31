package matthew.shannon.jamfam.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.hwangjr.rxbus.Bus;

import javax.inject.Inject;

public abstract class BaseFragment extends Fragment implements BaseView {
    protected abstract void setupFragmentComponent();
    @Inject public Bus bus;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupFragmentComponent();
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        bus.register(this);
    }

}
