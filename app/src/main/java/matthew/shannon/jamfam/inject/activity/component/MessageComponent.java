package matthew.shannon.jamfam.inject.activity.component;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.util.Map;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.inject.activity.scope.ActivityScope;
import matthew.shannon.jamfam.view.adapter.FragmentAdapter;
import matthew.shannon.jamfam.view.utils.constant.FragType;
import matthew.shannon.jamfam.view.fragment.ListView;
import matthew.shannon.jamfam.view.activity.MessageView;

@ActivityScope
@Subcomponent(modules = MessageComponent.MessageModule.class)
public interface MessageComponent extends ActivityComponent<MessageView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MessageModule, MessageComponent> {}

    @Module
    class MessageModule extends ActivityModule<MessageView> {

        public MessageModule(MessageView activity) {
            super(activity);
        }

        @Provides
        @ActivityScope
        @IntoMap
        @IntKey(FragType.USER_MATCHES)
        Fragment listUserMatches() {
            return ListView.newInstance(App.userID, FragType.USER_MATCHES);

        }

        @Provides
        @ActivityScope
        Animation viewPagerAnimation(){
            return AnimationUtils.loadAnimation(activity, R.anim.slide_up);
        }

        @Provides
        @ActivityScope
        FragmentManager fragmentManager(){
            return activity.getSupportFragmentManager();
        }

        @Provides
        @ActivityScope
        FragmentAdapter fragmentAdapter(FragmentManager manager, Map<Integer, Fragment> map){
            FragmentAdapter adapter = new FragmentAdapter(manager);
            adapter.addFragment(map.get(FragType.USER_MATCHES), "");
            return adapter;
        }


    }

}
