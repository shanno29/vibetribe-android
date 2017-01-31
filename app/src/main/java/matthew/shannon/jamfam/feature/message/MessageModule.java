package matthew.shannon.jamfam.feature.message;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.util.Map;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.adapter.fragment.FragmentAdapter;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.list.ListView;
import matthew.shannon.jamfam.model.data.FragType;
import matthew.shannon.jamfam.model.local.flow.FlowService;

@Module
public class MessageModule {

    private MessageView activity;

    public MessageModule(MessageView activity) {
        this.activity = activity;
    }

    @Provides
    @MessageScope
    MessageContract.View messageView(){
        return this.activity = activity;
    }

    @Provides
    @MessageScope
    MessageContract.Presenter messagePresenter(FlowService flow) {
        return new MessagePresenter(activity, flow);

    }

    @Provides
    @MessageScope
    @IntoMap
    @IntKey(FragType.USER_MATCHES)
    Fragment listUserMatches() {
        return ListView.newInstance(App.userID, FragType.USER_MATCHES);

    }

    @Provides
    @MessageScope
    Animation viewPagerAnimation(){
        return AnimationUtils.loadAnimation(activity, R.anim.slide_up);
    }

    @Provides
    @MessageScope
    FragmentManager fragmentManager(){
        return activity.getSupportFragmentManager();
    }

    @Provides
    @MessageScope
    FragmentAdapter fragmentAdapter(FragmentManager manager, Map<Integer, Fragment> map){
        FragmentAdapter adapter = new FragmentAdapter(manager);
        adapter.addFragment(map.get(FragType.USER_MATCHES), "");
        return adapter;
    }


}