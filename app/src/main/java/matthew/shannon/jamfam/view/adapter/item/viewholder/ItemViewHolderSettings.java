package matthew.shannon.jamfam.view.adapter.item.viewholder;

import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.auto.factory.AutoFactory;
import com.hwangjr.rxbus.Bus;
import butterknife.Bind;
import butterknife.ButterKnife;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.view.utils.constant.Action;
import matthew.shannon.jamfam.model.data.Event;
import matthew.shannon.jamfam.model.data.Settings;
import matthew.shannon.jamfam.R;

@AutoFactory(implementing = ItemViewHolderFactory.class)
public class ItemViewHolderSettings extends ItemViewHolder {
    @Bind(R.id.description) TextView description;
    @Bind(R.id.overflow) ImageView overflow;
    @Bind(R.id.value) TextView value;

    public ItemViewHolderSettings(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.setting_card_layout, parent, false));
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(Object item, BusService bus) {
        Settings settings = (Settings) item;
        value.setText(settings.getValue());
        description.setText(settings.getDescription());

        overflow.setOnClickListener(view -> {
            View dialogView = View.inflate(view.getContext(), R.layout.custom_dialog, null);

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext()).setView(dialogView);
            alertDialog.setTitle("Enter new " + settings.getDescription());
            EditText input = (EditText) dialogView.findViewById(R.id.dialogText);
            input.setHint(settings.getDescription());
            alertDialog.setNegativeButton("Close", (dialogInterface, i) -> dialogInterface.dismiss());
            alertDialog.setPositiveButton("Done", (dialog, whichButton) -> {
                settings.setValue(input.getText().toString());
                bus.updateUser(settings);
                dialog.dismiss();
            });
            alertDialog.show();
        });
    }


}