package matthew.shannon.jamfam.adapter.item;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;
import java.util.Map;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.adapter.item.viewholder.ItemViewHolder;
import matthew.shannon.jamfam.adapter.item.viewholder.ItemViewHolderFactory;
import matthew.shannon.jamfam.model.data.Settings;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.bus.BusService;

public class ItemAdapter extends RecyclerView.Adapter {
    private final Map<Integer, ItemViewHolderFactory> viewHolderFactories;
    private final BusService bus;
    private List<?> items;


    public ItemAdapter(Map<Integer, ItemViewHolderFactory> viewHolderFactories, List<?> items, BusService bus) {
        this.viewHolderFactories = viewHolderFactories;
        this.items = items;
        this.bus = bus;
    }

    @Override public int getItemViewType(int position) {
        if(items.get(position) instanceof User){return R.layout.user_card_layout; }
        else if(items.get(position) instanceof Track){return R.layout.track_card_layout; }
        else if(items.get(position) instanceof Settings){return R.layout.setting_card_layout; }
        else { return 0; }
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewHolderFactories.get(viewType).createViewHolder(parent);
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder)holder).bind(items.get(position), bus);
    }

    @Override
    public int getItemCount() {
        return items.size();

    }

    public void updateList(List<?> newItems) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return items != null ? items.size() : 0;
            }

            @Override
            public int getNewListSize() {
                return newItems != null ? newItems.size() : 0;
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                Object oldItem = items.get(oldItemPosition);
                Object newItem = newItems.get(newItemPosition);
                boolean ret  = false;

                if(oldItem instanceof User && newItem instanceof User){
                    ret = ((User) oldItem).get_id().equals(((User) newItem).get_id());
                }
                else if(oldItem instanceof Track && newItem instanceof Track){
                    ret = ((Track) oldItem).get_id().equals(((Track) newItem).get_id());
                }
                else if(oldItem instanceof Settings && newItem instanceof Settings){
                    ret = ((Settings) oldItem).getValue().equals(((Settings) newItem).getValue());
                }

                return ret;
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return items.get(oldItemPosition).equals(newItems.get(newItemPosition));
            }
        });
        items = newItems;
        diffResult.dispatchUpdatesTo(this);
    }

}



