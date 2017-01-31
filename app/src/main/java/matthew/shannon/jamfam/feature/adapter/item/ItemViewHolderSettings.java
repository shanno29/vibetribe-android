package matthew.shannon.jamfam.feature.adapter.item;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.auto.factory.AutoFactory;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.SettingCardLayoutBinding;
import matthew.shannon.jamfam.model.data.Settings;
import matthew.shannon.jamfam.service.flow.FlowService;

@AutoFactory(implementing = ItemViewHolderFactory.class)
public class ItemViewHolderSettings extends ItemViewHolder {


    public ItemViewHolderSettings(ViewGroup parent) {
        super(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.setting_card_layout, parent, false).getRoot());
    }

    @Override
    public void bind(Object item, FlowService flow) {
        SettingCardLayoutBinding binding = DataBindingUtil.bind(itemView);

        Settings settings = (Settings) item;


        binding.overflow.setOnClickListener(view -> {
            View dialogView = View.inflate(view.getContext(), R.layout.custom_dialog, null);

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext()).setView(dialogView);
            alertDialog.setTitle("Enter new " + settings.getDescription());
            EditText input = (EditText) dialogView.findViewById(R.id.dialogText);
            input.setHint(settings.getDescription());
            alertDialog.setNegativeButton("Close", (dialogInterface, i) -> dialogInterface.dismiss());
            alertDialog.setPositiveButton("Done", (dialog, whichButton) -> {
                settings.setValue(input.getText().toString());
                flow.updateUser(settings);
                dialog.dismiss();
            });
            alertDialog.show();
        });
    }


}