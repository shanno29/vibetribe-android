package matthew.shannon.jamfam.feature.adapter.item;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.auto.factory.AutoFactory;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.UserCardLayoutBinding;
import matthew.shannon.jamfam.model.User;
import matthew.shannon.jamfam.service.flow.FlowService;

@AutoFactory(implementing = ItemViewHolderFactory.class)
public class ItemViewHolderUser extends ItemViewHolder {

    public ItemViewHolderUser(ViewGroup parent) {
        super(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user_card_layout, parent, false).getRoot());
    }

    @Override
    public void bind(Object value, FlowService flow) {
        UserCardLayoutBinding binding = DataBindingUtil.bind(itemView);
        User user = ((User) value);
        binding.setUser(user);

        binding.root.setOnClickListener(view -> flow.goToUser(user));
        binding.overflow.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.non_friend_meu);
            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.add_friend) flow.addFriend(user);
                if (item.getItemId() == R.id.del_friend) flow.delFriend(user);
                if (item.getItemId() == R.id.go_to_user) flow.goToUser(user);
                return true;
            });
            popupMenu.show();
        });
    }
}