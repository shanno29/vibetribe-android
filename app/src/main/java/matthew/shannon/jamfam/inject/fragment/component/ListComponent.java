package matthew.shannon.jamfam.inject.fragment.component;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import com.hwangjr.rxbus.Bus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.view.adapter.item.ItemAdapter;
import matthew.shannon.jamfam.view.adapter.item.viewholder.ItemViewHolderFactory;
import matthew.shannon.jamfam.presenter.fragment.ListPresenter;
import matthew.shannon.jamfam.view.fragment.ListView;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.view.adapter.item.viewholder.ItemViewHolderSettingsFactory;
import matthew.shannon.jamfam.view.adapter.item.viewholder.ItemViewHolderTrackFactory;
import matthew.shannon.jamfam.view.adapter.item.viewholder.ItemViewHolderUserFactory;

@ListComponent.ListScope
@Subcomponent(modules = ListComponent.ListModule.class)
public interface ListComponent extends FragmentComponent<ListView> {

    @Subcomponent.Builder
    interface Builder extends FragmentComponentBuilder<ListModule, ListComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface ListScope {}

    @Module
    class ListModule extends FragmentModule<ListView> {

        public ListModule(ListView fragment) {
            super(fragment);
        }

        @Provides
        @ListScope
        LayoutInflater layoutInflater(){
            return fragment.getLayoutInflater(new Bundle());
        }

        @Provides
        @ListScope
        List<?> genericList(){
            return new ArrayList<>();
        }

        @Provides
        @ListScope
        LinearLayoutManager linearLayoutManager(){
            return new LinearLayoutManager(fragment.getContext());
        }

        @Provides
        @ListScope
        DividerItemDecoration dividerItemDecoration(){
            return new DividerItemDecoration(fragment.getContext(), RecyclerView.VERTICAL);
        }
        
        @Provides
        @ListScope
        ListPresenter listPresenter(NetworkService network, CacheService cache, FlowService flow) {
            return new ListPresenter(network, cache, flow, fragment);
        }

        @Provides
        @ListScope
        @IntoMap
        @IntKey(R.layout.setting_card_layout)
        ItemViewHolderFactory provideViewHolderNormal() {
            return new ItemViewHolderSettingsFactory();
        }

        @Provides
        @ListScope
        @IntoMap
        @IntKey(R.layout.track_card_layout)
        ItemViewHolderFactory provideViewHolderBig() {
            return new ItemViewHolderTrackFactory();
        }

        @Provides
        @ListScope
        @IntoMap
        @IntKey(R.layout.user_card_layout)
        ItemViewHolderFactory provideViewHolderFeatured() {
            return new ItemViewHolderUserFactory();
        }

        //    @Provides
        //    @FragmentScope
        //    AlphaInAnimationAdapter provideAlphaInAnimatorAdapter(ItemAdapter adapter) {
        //        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        //        alphaAdapter.setInterpolator(new OvershootInterpolator());
        //        alphaAdapter.setHasStableIds(true);
        //        alphaAdapter.setFirstOnly(true);
        //        alphaAdapter.setDuration(100);
        //        return alphaAdapter;
        //    }

        @Provides
        @ListScope
        ItemAdapter provideGenericAdapter(Map<Integer, ItemViewHolderFactory> viewHolderFactories, List<?> itemsList, BusService bus) {
            return new ItemAdapter(viewHolderFactories, itemsList, bus);
        }

    }

}
