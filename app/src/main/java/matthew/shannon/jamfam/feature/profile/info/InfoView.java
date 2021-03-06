package matthew.shannon.jamfam.feature.profile.info;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import javax.inject.Inject;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.databinding.ProfileAboutBinding;
import matthew.shannon.jamfam.base.BaseFragment;
import matthew.shannon.jamfam.model.User;

public class InfoView extends BaseFragment implements InfoContract.View {
    @Inject InfoContract.Presenter presenter;
    private String ID;
    private ProfileAboutBinding binding;

    public InfoView() {}

    public static InfoView newInstance(String id) {
        InfoView fragment = new InfoView();
        Bundle args = new Bundle();
        args.putString("_id", id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent() {
        ((App) getActivity().getApplicationContext()).getAppComponent().plus(new InfoModule(this)).inject(this);

    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //ID = getArguments().getString("_id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        super.onCreateView(inflater, container, bundle);
        binding = DataBindingUtil.inflate(inflater, R.layout.profile_about, container, false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        //presenter.loadGetUser(ID);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        binding.unbind();
    }

    @Override
    public void EditAboutMe(View view) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View dialogView = inflater.inflate(R.layout.custom_dialog, null, false);

        EditText editText = (EditText) dialogView.findViewById(R.id.dialogText);
        editText.setText(binding.aboutText.getText().toString());

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext()).setView(dialogView);
        alert.setNegativeButton("Close", (dialogInterface, i) -> dialogInterface.dismiss());
        alert.setPositiveButton("Done", (dialog, whichButton) -> {
            String edit = editText.getText().toString();
            binding.aboutText.setText(edit);
            binding.getUser().setAboutme(edit);
            presenter.updateUser(binding.getUser());
        });

        alert.show();
    }

    @Override
    public void updateUI(User user) {
        binding.setUser(user);
        binding.executePendingBindings();
        binding.aboutText.setOnClickListener((ID.equals(App.userID) ? this::EditAboutMe : null));
    }

}
