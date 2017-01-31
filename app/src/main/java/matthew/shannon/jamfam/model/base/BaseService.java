package matthew.shannon.jamfam.model.base;

import android.service.notification.NotificationListenerService;
import android.widget.Toast;

public abstract class BaseService extends NotificationListenerService implements BaseView{
    //@Inject public Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        //bus.register(this);
    }

    @Override
    public void showToast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //bus.unregister(this);
    }

}
