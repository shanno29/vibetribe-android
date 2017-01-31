package matthew.shannon.jamfam.feature.adapter.item;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public interface ItemViewHolderFactory {
    RecyclerView.ViewHolder createViewHolder(ViewGroup parent);
}