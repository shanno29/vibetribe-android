package matthew.shannon.jamfam.feature.home.track;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hwangjr.rxbus.annotation.Subscribe;

import javax.inject.Inject;

import co.mobiwise.materialintro.view.MaterialIntroView;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.databinding.FragmentTrackBinding;
import matthew.shannon.jamfam.base.BaseFragment;
import matthew.shannon.jamfam.model.data.Track;

public class TrackView extends BaseFragment implements TrackContract.View {
    @Inject MaterialIntroView.Builder intro;
    @Inject TrackContract.Presenter presenter;
    private FragmentTrackBinding binding;

    public TrackView() {}

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
    protected void setupFragmentComponent() {
        ((App) getActivity().getApplicationContext()).getAppComponent().plus(new TrackModule(this)).inject(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        binding.unbind();
    }


    @Subscribe
    public void trackUpdate(Track track) {
        if (track.getTitle() != null) {
            binding.setTrack(track);
            binding.executePendingBindings();
        }
    }

    @Override
    public void showIntroView() {
//        intro.setTarget(binding.openApp);
//        intro.show();
    }


}