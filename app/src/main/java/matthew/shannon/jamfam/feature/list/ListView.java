package matthew.shannon.jamfam.feature.list;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.hwangjr.rxbus.annotation.Subscribe;
import java.util.List;
import javax.inject.Inject;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.feature.adapter.item.ItemAdapter;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.databinding.FlowLayoutBinding;
import matthew.shannon.jamfam.base.BaseFragment;
import matthew.shannon.jamfam.model.Action;
import matthew.shannon.jamfam.model.Event;
import matthew.shannon.jamfam.model.FragType;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.model.User;

public class ListView extends BaseFragment implements ListContract.View {
    @Inject MaterialViewPagerHeaderDecorator decorator;
    @Inject DividerItemDecoration dividerItem;
    @Inject ListContract.Presenter presenter;
    @Inject LinearLayoutManager manager;
    @Inject ProgressDialog dialog;
    @Inject ItemAdapter adapter;
    @Inject List<?> items;

    private FlowLayoutBinding binding;
    private String ID;
    private int TYPE;

    public static ListView newInstance(String ID, int TYPE) {
        Bundle args = new Bundle();
        args.putString("ID", ID);
        args.putSerializable("TYPE", TYPE);
        ListView fragment = new ListView();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent() {
        ((App) getActivity().getApplicationContext()).getAppComponent().plus(new ListModule(this)).inject(this);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ID = getArguments().getString("ID");
        TYPE = getArguments().getInt("TYPE");
    }

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        super.onCreateView(inflater, container, bundle);
        binding = DataBindingUtil.inflate(inflater, R.layout.flow_layout, container, false);
        binding.recyclerView.setLayoutManager(manager);
        binding.recyclerView.addItemDecoration(decorator);
        binding.recyclerView.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(android.view.View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setOnCreateContextMenuListener(this);
    }



    @Subscribe
    public void onEvent(Event event) {
        if (event.getObject() instanceof Track && getUserVisibleHint()) {
            Track track = ((Track) event.getObject());
            if(event.getType() == Action.ADD_TRACK) presenter.loadAddTrack(ID, track);
            if(event.getType() == Action.DEL_TRACK) presenter.loadDelTrack(track.get_id());
            if(event.getType() == Action.GO_TO_USER) presenter.goToUser(track.getOwner().get_id());
            //if(event.getType() == Action.GO_TO_TRACK);
        }
        if (event.getObject() instanceof String && getUserVisibleHint() && event.getType() == Action.QUERY_CHANGED) {
            onQuery(this.items, ((String) event.getObject()));
        }
        if (event.getObject() instanceof User && getUserVisibleHint()) {
            User user = ((User) event.getObject());
            if(event.getType() == Action.GO_TO_USER) presenter.goToUser(user.get_id());
            if(event.getType() == Action.ADD_FRIEND) presenter.loadAddFriend(ID, user.get_id());
            if(event.getType() == Action.DEL_FRIEND) presenter.loadDelFriend(ID, user.get_id());
        }
        if (event.getType() == Action.REFRESH && TYPE != FragType.SEARCH_TRACKS) onRefresh();
    }

    @Override
    public void onQuery(List<?> items, String string){
        if (TYPE == FragType.SEARCH_TRACKS) {
            presenter.searchTracks(string, "", "10");
        } else {
            binding.recyclerView.scrollToPosition(0);
            adapter.updateList(presenter.localQuery(items, string));
        }
    }

    @Override
    public void onContent(List<?> items) {
        toggleSpinner(false);
        if (items.size() > 0) {
            this.items = items;
            adapter.updateList(this.items);
        }
    }

    @Override
    public void onRefresh() {
        toggleSpinner(true);
        if(TYPE == FragType.FRIENDS_TRACKS) presenter.loadFriendsTracks(ID);
        if(TYPE == FragType.USER_FRIENDS) presenter.loadUserFriends(ID);
        if(TYPE == FragType.USER_MATCHES) presenter.loadUserMatches(ID);
        if(TYPE == FragType.USER_TRACKS) presenter.loadUserTracks(ID);
        if(TYPE == FragType.SETTINGS) presenter.loadSettings(ID);
        if(TYPE == FragType.ALL_TRACKS) presenter.loadAllTracks();
        if(TYPE == FragType.ALL_USERS) presenter.loadAllUsers();
    }

    @Override
    public void toggleSpinner(boolean flag) {
        if (flag) dialog.show();
        else dialog.dismiss();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        binding.unbind();
    }
}