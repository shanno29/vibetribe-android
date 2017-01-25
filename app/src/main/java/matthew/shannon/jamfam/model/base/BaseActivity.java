package matthew.shannon.jamfam.model.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import javax.inject.Inject;
import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.inject.activity.HasActivityComponentBuilders;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    protected abstract void injectMembers(HasActivityComponentBuilders builders);
    @Inject public FlowService flowService;
    //@Inject public Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectMembers(App.getActivity(this));
    }

    @Override
    public void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onStart() {
        super.onStart();
       // bus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //bus.unregister(this);
    }

}