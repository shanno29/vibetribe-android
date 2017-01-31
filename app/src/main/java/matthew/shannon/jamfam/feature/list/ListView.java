package matthew.shannon.jamfam.feature.list;

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
import matthew.shannon.jamfam.model.data.Action;
import matthew.shannon.jamfam.model.data.Event;
import matthew.shannon.jamfam.model.data.FragType;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.data.User;

public class ListView extends BaseFragment implements ListContract.View {
    @Inject DividerItemDecoration dividerItem;
    @Inject ListContract.Presenter presenter;
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
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        binding.recyclerView.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(android.view.View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        binding.unbind();
    }

    @Subscribe
    public void onEvent(Event event) {
        if (event.getObject() instanceof Track && getUserVisibleHint()) {
            Track track = ((Track) event.getObject());
            switch (event.getType()) {
                case Action.ADD_TRACK:
                    presenter.loadAddTrack(ID, track);
                    break;
                case Action.DEL_TRACK:
                    presenter.loadDelTrack(track.get_id());
                    break;
                case Action.GO_TO_TRACK:
                    break;
                case Action.GO_TO_USER:
                    presenter.goToUser(track.getOwner().get_id());
                    break;
            }
        } else if (event.getObject() instanceof String && getUserVisibleHint()) {
            String string = ((String) event.getObject());
            switch (event.getType()) {
                case Action.QUERY_CHANGED:
                    onQuery(string);
                    break;
            }
        } else if (event.getObject() instanceof User && getUserVisibleHint()) {
            User user = ((User) event.getObject());
            switch (event.getType()) {
                case Action.GO_TO_USER:
                    presenter.goToUser(user.get_id());
                    break;
                case Action.ADD_FRIEND:
                    presenter.loadAddFriend(ID, user.get_id());
                    break;
                case Action.DEL_FRIEND:
                    presenter.loadDelFriend(ID, user.get_id());
                    break;

            }
        } else if (event.getType() == Action.REFRESH && TYPE != FragType.SEARCH_TRACKS) onRefresh();
    }

    @Override
    public void onQuery(String query) {
        if (TYPE == FragType.SEARCH_TRACKS) {
            presenter.searchTracks(query, "", "10");
        } else {
            binding.recyclerView.scrollToPosition(0);
            adapter.updateList(presenter.localQuery(items, query));
        }
    }

    @Override
    public void onSuccess(List<?> items) {
        if (items.size() > 0) {
            onContent(items);
        } else {
            onEmpty();
        }
    }

    @Override
    public void onContent(List<?> items) {
        this.items = items;
        adapter.updateList(this.items);
        // TODO something to show content
    }

    @Override
    public void onEmpty() {
        // TODO something to show empty
    }

    @Override
    public void onRefresh() {
        // TODO Something to show loading
        switch (TYPE) {
            case FragType.FRIENDS_TRACKS:
                presenter.loadFriendsTracks(ID);
                break;
            case FragType.USER_FRIENDS:
                presenter.loadUserFriends(ID);
                break;
            case FragType.USER_MATCHES:
                presenter.loadUserMatches(ID);
                break;
            case FragType.USER_TRACKS:
                presenter.loadUserTracks(ID);
                break;
            case FragType.ALL_TRACKS:
                presenter.loadAllTracks();
                break;
            case FragType.ALL_USERS:
                presenter.loadAllUsers();
                break;
            case FragType.SETTINGS:
                presenter.loadSettings(ID);
                break;
        }
    }

}