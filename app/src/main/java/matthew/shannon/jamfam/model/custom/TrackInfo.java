package matthew.shannon.jamfam.model.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class TrackInfo extends RelativeLayout {

    public TrackInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Bind(R.id.prev_track) IconicsImageView prevTrack;
//    @Bind(R.id.next_track) IconicsImageView nextTrack;
//    @Bind(R.id.post_track) IconicsImageView postTrack;
//    @Bind(R.id.open_app) IconicsImageView openApp;
//    @Bind(R.id.album_art) ImageView albumArt;
//
//    private Subscription subscription;
//
//    @Inject NetworkService networkService;
//    @Inject Track track;
//    @Inject Bus bus;
//
//    public interface Injector {
//        void inject(TrackInfo activity);
//    }
//    public TrackInfo(Context context) {
//        super(context);
//        init();
//
//    }
//    public TrackInfo(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        init();
//    }
//    public TrackInfo(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//    public void init() {
//        View v = LayoutInflater.from(getContext()).inflate(R.layout.track_info, this, true);
//        ButterKnife.bind(this, v);
//
//
//        App.getActivity(getContext()).getComponent().inject(this);
//        bus.postUser(this);
//
//        this.openApp.setOnClickListener(view -> bus.post(new Event("GoToApp")));
//        this.prevTrack.setOnClickListener(view -> bus.post(new Event("ControlTrack","prevTrack")));
//        this.nextTrack.setOnClickListener(view -> bus.post(new Event("ControlTrack", "nextTrack")));
//        this.albumArt.setOnClickListener(view -> bus.post(new Event("GoToTrack", null, track)));
//
//        this.postTrack.setOnClickListener(view ->
//            subscription = networkService
//                .postUserTrackObs(track, track.get_id())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnError(throwable -> bus.post(new Event("ShowToast", "Error Posting Track")))
//                .doOnNext(tracks -> bus.post(new Event("ShowToast", "Track Posted Successfully")))
//                .subscribe());
//    }
//
//
//    @Subscribe public void trackUpdate(Track track) {
//        if (track != null && track.getTitle() != null) {
//            this.track = track;
//        }
//    }
//    @Subscribe public void locationUpdate(Location location) {
//        track.setLatitude(Double.toString(location.getLatitude()));
//        track.setLongitude(Double.toString(location.getLongitude()));
//    }
//
//    @Override protected void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        ButterKnife.unbind(this);
//        bus.unregister(this);
//        if(subscription != null && !subscription.isUnsubscribed()){
//            subscription.unsubscribe();
//        }
//    }

}
