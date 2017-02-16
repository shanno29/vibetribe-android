package matthew.shannon.jamfam.feature.adapter.item;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.auto.factory.AutoFactory;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.databinding.TrackCardLayoutBinding;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.service.flow.FlowService;

@AutoFactory(implementing = ItemViewHolderFactory.class)
public class ItemViewHolderTrack extends ItemViewHolder {

    public ItemViewHolderTrack(ViewGroup parent) {
        super(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.track_card_layout, parent, false).getRoot());
    }

    @Override
    public void bind(Object value, FlowService flow) {
        TrackCardLayoutBinding binding = DataBindingUtil.bind(itemView);
        Track track = ((Track) value);
        binding.setTrack(track);

        if (track.getOwner() != null && !track.getOwner().get_id().equals(App.userID)) {
            binding.getTrack().getOwner().setUsername(track.getOwner().getUsername());
        } else binding.getTrack().getOwner().setUsername("You");

        binding.overflow.setOnClickListener(view -> {
            PopupMenu popup = new PopupMenu(view.getContext(), view);
            popup.inflate(track.getOwner() == null ? R.menu.track_search_menu : R.menu.owner_track_menu);
            popup.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.go_to_user) flow.goToUser(track.getOwner());
                if (item.getItemId() == R.id.add_track) flow.goToTrack(track);
                if (item.getItemId() == R.id.del_track) flow.delTrack(track);
                return true;
            });
            popup.show();
        });
    }


}
