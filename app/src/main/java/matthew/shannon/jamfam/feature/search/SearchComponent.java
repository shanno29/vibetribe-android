package matthew.shannon.jamfam.feature.search;

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

@SearchComponent.SearchScope
@Subcomponent(modules = SearchComponent.SearchModule.class)
public interface SearchComponent extends ActivityComponent<SearchView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<SearchModule, SearchComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface SearchScope {}

    @Module
    class SearchModule extends ActivityModule<SearchView> {

        public SearchModule(SearchView activity) {
            super(activity);
        }

        @Provides
        @SearchScope
        SearchPresenter searchPresenter(NetworkService network, CacheService cache, FlowService flow) {
            return new SearchPresenter(activity, network, cache, flow);

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

}
