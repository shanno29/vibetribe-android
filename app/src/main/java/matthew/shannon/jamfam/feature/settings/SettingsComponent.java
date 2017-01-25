package matthew.shannon.jamfam.feature.settings;

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
import matthew.shannon.jamfam.adapter.fragment.FragmentAdapter;
import matthew.shannon.jamfam.inject.activity.ActivityComponent;
import matthew.shannon.jamfam.inject.activity.ActivityComponentBuilder;
import matthew.shannon.jamfam.model.data.FragType;
import matthew.shannon.jamfam.list.ListView;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@SettingsComponent.SettingsScope
@Subcomponent(modules = SettingsComponent.SettingsModule.class)
public interface SettingsComponent extends ActivityComponent<SettingsView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<SettingsModule, SettingsComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface SettingsScope {}

    @Module
    class SettingsModule extends ActivityModule<SettingsView> {

        public SettingsModule(SettingsView activity) {
            super(activity);
        }

        @Provides
        @SettingsScope
        SettingsPresenter searchPresenter(NetworkService network, CacheService cache, FlowService flow) {
            return new SettingsPresenter(activity, network, cache, flow);

        }

        @Provides
        @SettingsScope
        @IntoMap
        @IntKey(FragType.SETTINGS)
        Fragment settings() {
            return ListView.newInstance(App.userID, FragType.SETTINGS);

        }

        @Provides
        @SettingsScope
        Animation viewPagerAnimation(){
            return AnimationUtils.loadAnimation(activity, R.anim.slide_up);
        }

        @Provides
        @SettingsScope
        FragmentManager fragmentManager(){
            return activity.getSupportFragmentManager();
        }

        @Provides
        @SettingsScope
        FragmentAdapter fragmentAdapter(FragmentManager manager, Map<Integer, Fragment> map){
            FragmentAdapter adapter = new FragmentAdapter(manager);
            adapter.addFragment(map.get(FragType.SETTINGS), "");
            return adapter;
        }

    }

}