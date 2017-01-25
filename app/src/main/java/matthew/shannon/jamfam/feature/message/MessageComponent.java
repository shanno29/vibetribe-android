package matthew.shannon.jamfam.feature.message;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.App;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.inject.activity.ActivityComponent;
import matthew.shannon.jamfam.inject.activity.ActivityComponentBuilder;
import matthew.shannon.jamfam.feature.message.MessageComponent.MessageScope;
import matthew.shannon.jamfam.adapter.fragment.FragmentAdapter;
import matthew.shannon.jamfam.model.data.FragType;
import matthew.shannon.jamfam.list.ListView;
import matthew.shannon.jamfam.model.local.flow.FlowService;

@MessageScope
@Subcomponent(modules = MessageComponent.MessageModule.class)
public interface MessageComponent extends ActivityComponent<MessageView> {

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface MessageScope {}

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MessageModule, MessageComponent> {}

    @Module
    class MessageModule extends ActivityModule<MessageView> {

        public MessageModule(MessageView activity) {
            super(activity);
        }

        @Provides
        @MessageScope
        MessagePresenter messagePresenter(FlowService flow) {
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

}
