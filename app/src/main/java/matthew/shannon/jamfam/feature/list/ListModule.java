package matthew.shannon.jamfam.feature.list;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.feature.adapter.item.ItemAdapter;
import matthew.shannon.jamfam.feature.adapter.item.ItemViewHolderFactory;
import matthew.shannon.jamfam.feature.adapter.item.ItemViewHolderSettingsFactory;
import matthew.shannon.jamfam.feature.adapter.item.ItemViewHolderTrackFactory;
import matthew.shannon.jamfam.feature.adapter.item.ItemViewHolderUserFactory;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;

@Module
public class ListModule {

    private ListView fragment;


    public ListModule(ListView fragment) {
        this.fragment = fragment;
    }

    @Provides
    @ListScope
    LayoutInflater layoutInflater() {
        return fragment.getLayoutInflater(new Bundle());
    }


    @Provides
    @ListScope
    ProgressDialog dialog() {
        return new ProgressDialog(fragment.getContext());
    }

    @Provides
    @ListScope
    MaterialViewPagerHeaderDecorator decorator(){
        return new MaterialViewPagerHeaderDecorator();
    }


    @Provides
    @ListScope
    List<?> genericList() {
        return new ArrayList<>();
    }

    @Provides
    @ListScope
    LinearLayoutManager linearLayoutManager() {
        return new LinearLayoutManager(fragment.getContext());
    }

    @Provides
    @ListScope
    DividerItemDecoration dividerItemDecoration() {
        return new DividerItemDecoration(fragment.getContext(), RecyclerView.VERTICAL);
    }

    @Provides
    @ListScope
    ListContract.View view() {
        return this.fragment;
    }

    @Provides
    @ListScope
    ListContract.Presenter listPresenter(CacheService cache, FlowService flow, ListContract.View view) {
        return new ListPresenter(cache, flow, view);
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
    ItemAdapter provideGenericAdapter(Map<Integer, ItemViewHolderFactory> viewHolderFactories, List<?> itemsList, FlowService flow) {
        return new ItemAdapter(viewHolderFactories, itemsList, flow);
    }

}