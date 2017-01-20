package matthew.shannon.jamfam.inject.service.base;

import android.service.notification.NotificationListenerService;
import android.widget.Toast;
import com.hwangjr.rxbus.Bus;
import javax.inject.Inject;
import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.view.BaseView;
import matthew.shannon.jamfam.inject.service.component.HasServiceComponentBuilders;

public abstract class BaseService extends NotificationListenerService implements BaseView{
    protected abstract void injectMembers(HasServiceComponentBuilders builders);
    @Inject public Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        injectMembers(App.getService(getApplicationContext()));
        bus.register(this);
    }

    @Override
    public void showToast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }

}
