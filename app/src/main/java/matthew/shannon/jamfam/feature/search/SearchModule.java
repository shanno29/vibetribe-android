package matthew.shannon.jamfam.feature.search;

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
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@Module
public class SearchModule {

    private SearchView activity;

    public SearchModule(SearchView activity) {
        this.activity = activity;
    }

    @Provides
    @SearchScope
    SearchContract.View searchView(){
        return this.activity;
    }

    @Provides
    @SearchScope
    SearchContract.Presenter searchPresenter(SearchContract.View view, NetworkService network, CacheService cache, FlowService flow) {
        return new SearchPresenter(view, network, cache, flow);

    }

    @Provides
    @SearchScope
    @IntoMap
    @IntKey(FragType.SEARCH_TRACKS)
    Fragment listSearchTracks() {
        return ListView.newInstance(App.userID, FragType.SEARCH_TRACKS);
    }

    @Provides
    @SearchScope
    @IntoMap
    @IntKey(FragType.ALL_USERS)
    Fragment listAllUsers() {
        return ListView.newInstance(App.userID, FragType.ALL_USERS);
    }

    @Provides
    @SearchScope
    @IntoMap
    @IntKey(FragType.ALL_TRACKS)
    Fragment listAllTracks() {
        return ListView.newInstance(App.userID, FragType.ALL_TRACKS);
    }

    @Provides
    @SearchScope
    @IntoMap
    @IntKey(FragType.FRIENDS_TRACKS)
    Fragment listFriendsTracks() {
        return ListView.newInstance(App.userID, FragType.FRIENDS_TRACKS);
    }

    @Provides
    @SearchScope
    Animation viewPagerAnimation(){
        return AnimationUtils.loadAnimation(activity, R.anim.slide_up);
    }

    @Provides
    @SearchScope
    FragmentManager fragmentManager(){
        return activity.getSupportFragmentManager();
    }

    @Provides
    @SearchScope
    FragmentAdapter fragmentAdapter(FragmentManager manager, Map<Integer, Fragment> map){
        FragmentAdapter adapter = new FragmentAdapter(manager);
        adapter.addFragment(map.get(FragType.SEARCH_TRACKS), "Tracks");
        adapter.addFragment(map.get(FragType.ALL_TRACKS), "Feed");
        adapter.addFragment(map.get(FragType.FRIENDS_TRACKS), "Friends");
        adapter.addFragment(map.get(FragType.ALL_USERS), "People");
        return adapter;
    }

}
