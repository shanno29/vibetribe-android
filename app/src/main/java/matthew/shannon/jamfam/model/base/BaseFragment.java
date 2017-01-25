package matthew.shannon.jamfam.model.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import matthew.shannon.jamfam.inject.fragment.HasFragmentComponentBuilders;
import matthew.shannon.jamfam.App;

public abstract class BaseFragment extends Fragment implements BaseView{
    protected abstract void injectMembers(HasFragmentComponentBuilders builders);
   // @Inject public Bus bus;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        injectMembers(App.getFragment(getContext()));

    }

    @Override
    public void showToast(String text){
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStop() {
        super.onStop();
       // bus.unregister(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        //bus.register(this);
    }

}
