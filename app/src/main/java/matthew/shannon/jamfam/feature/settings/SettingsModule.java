package matthew.shannon.jamfam.feature.settings;

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
import matthew.shannon.jamfam.feature.adapter.fragment.FragmentAdapter;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.feature.list.ListView;
import matthew.shannon.jamfam.model.FragType;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;

@Module
public class SettingsModule {

    private SettingsView activity;

    public SettingsModule(SettingsView activity) {
        this.activity = activity;
    }

    @Provides
    @SettingsScope
    SettingsContract.View settingsVIew() {
        return this.activity;
    }

    @Provides
    @SettingsScope
    SettingsContract.Presenter searchPresenter(SettingsContract.View view, CacheService cache, FlowService flow) {
        return new SettingsPresenter(view, cache, flow);

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
    Animation viewPagerAnimation() {
        return AnimationUtils.loadAnimation(activity, R.anim.slide_up);
    }

    @Provides
    @SettingsScope
    FragmentManager fragmentManager() {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @SettingsScope
    FragmentAdapter fragmentAdapter(FragmentManager manager, Map<Integer, Fragment> map) {
        FragmentAdapter adapter = new FragmentAdapter(manager);
        adapter.addFragment(map.get(FragType.SETTINGS), "");
        return adapter;
    }

}