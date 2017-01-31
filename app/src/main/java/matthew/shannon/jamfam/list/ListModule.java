package matthew.shannon.jamfam.list;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.adapter.item.ItemAdapter;
import matthew.shannon.jamfam.adapter.item.viewholder.ItemViewHolderFactory;
import matthew.shannon.jamfam.adapter.item.viewholder.ItemViewHolderSettingsFactory;
import matthew.shannon.jamfam.adapter.item.viewholder.ItemViewHolderTrackFactory;
import matthew.shannon.jamfam.adapter.item.viewholder.ItemViewHolderUserFactory;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@Module
public class ListModule  {

    private ListView fragment;


    public ListModule(ListView fragment) {
        this.fragment = fragment;
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
    ListContract.View view(){
        return this.fragment;
    }

    @Provides
    @ListScope
    ListContract.Presenter listPresenter(NetworkService network, CacheService cache, FlowService flow, ListContract.View view) {
        return new ListPresenter(network, cache, flow, view);
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

    @Provides
    @ListScope
    ItemAdapter provideGenericAdapter(Map<Integer, ItemViewHolderFactory> viewHolderFactories, List<?> itemsList, BusService bus) {
        return new ItemAdapter(viewHolderFactories, itemsList, bus);
    }

}