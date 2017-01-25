package matthew.shannon.jamfam.adapter.item.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import matthew.shannon.jamfam.model.local.bus.BusService;

public abstract class ItemViewHolder extends RecyclerView.ViewHolder {
    public View itemView;
    ItemViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }



    public abstract void bind(Object item, BusService bus);
}
