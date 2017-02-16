package matthew.shannon.jamfam.feature.adapter.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import matthew.shannon.jamfam.service.flow.FlowService;

public abstract class ItemViewHolder extends RecyclerView.ViewHolder {
    public abstract void bind(Object item, FlowService flow);
    public View itemView;

    ItemViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }


}
