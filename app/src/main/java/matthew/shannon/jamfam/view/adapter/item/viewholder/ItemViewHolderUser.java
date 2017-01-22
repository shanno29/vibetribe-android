package matthew.shannon.jamfam.view.adapter.item.viewholder;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.auto.factory.AutoFactory;
import matthew.shannon.jamfam.databinding.UserCardLayoutBinding;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.model.data.User;

@AutoFactory(implementing = ItemViewHolderFactory.class)
public class ItemViewHolderUser extends ItemViewHolder {

    public ItemViewHolderUser(ViewGroup parent) {
        super(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user_card_layout, parent, false).getRoot());
    }

    @Override
    public void bind(Object value, BusService bus) {
        UserCardLayoutBinding binding = DataBindingUtil.bind(itemView);
        User user = ((User) value);
        Log.d("VIBETRIBE", "bind: " + user.getAvatar());
        binding.setUser(user);

        binding.root.setOnClickListener(view -> bus.goToUser(user));
        binding.overflow.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.non_friend_meu);
            popupMenu.setOnMenuItemClickListener(item -> {
              switch (item.getItemId()) {
                    case R.id.add_friend: bus.addFriend(user); break;
                    case R.id.del_friend: bus.delFriend(user); break;
                    case R.id.go_to_user: bus.goToUser(user);  break;
                } return true;
            });
            popupMenu.show();
        });
    }
}