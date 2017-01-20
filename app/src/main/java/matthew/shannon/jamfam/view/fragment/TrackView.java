package matthew.shannon.jamfam.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hwangjr.rxbus.annotation.Subscribe;
import javax.inject.Inject;
import co.mobiwise.materialintro.view.MaterialIntroView;
import matthew.shannon.jamfam.presenter.fragment.TrackPresenter;
import matthew.shannon.jamfam.inject.fragment.base.BaseFragment;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.databinding.FragmentTrackBinding;
import matthew.shannon.jamfam.inject.fragment.component.HasFragmentComponentBuilders;
import matthew.shannon.jamfam.inject.fragment.component.TrackComponent;

public class TrackView extends BaseFragment {
    private FragmentTrackBinding binding;
    @Inject MaterialIntroView.Builder intro;
    @Inject TrackPresenter presenter;

    public TrackView() {}

    @Override
    protected void injectMembers(HasFragmentComponentBuilders builders) {
        ((TrackComponent.Builder) builders.getFragmentBuilders(TrackView.class))
            .fragmentModule(new TrackComponent.TrackModule(this))
            .build().injectMembers(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        super.onCreateView(inflater, container, bundle);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_track, container, false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.openApp.setOnClickListener(view -> presenter.appSelected());
        binding.albumArt.setOnClickListener(view -> presenter.trackSelected(binding.getTrack()));
        binding.prevTrack.setOnClickListener(view -> presenter.controlUpdate(88));
        binding.nextTrack.setOnClickListener(view -> presenter.controlUpdate(87));
        binding.postTrack.setOnClickListener(view -> presenter.postTrack(binding.getTrack()));
        presenter.checkForSecondRun();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        binding.unbind();
    }

    @Subscribe
    public void trackUpdate(Track track) {
        if(track.getTitle() != null) {
            binding.setTrack(track);
            binding.executePendingBindings();
        }
    }

    public void showIntroView() {
        intro.setTarget(binding.openApp);
        intro.show();
    }

}