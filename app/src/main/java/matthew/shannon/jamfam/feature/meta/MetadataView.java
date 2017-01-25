package matthew.shannon.jamfam.feature.meta;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.RemoteController;
import android.service.notification.StatusBarNotification;
import android.view.KeyEvent;
import com.hwangjr.rxbus.annotation.Subscribe;
import javax.inject.Inject;

import matthew.shannon.jamfam.model.base.BaseService;
import matthew.shannon.jamfam.model.data.Action;
import matthew.shannon.jamfam.model.data.Event;
import matthew.shannon.jamfam.inject.service.HasServiceComponentBuilders;

public class MetadataView extends BaseService implements MetadataService {
    @Inject public MetadataPresenter presenter;
    @Inject AudioManager audioManager;
    @Inject RemoteController remote;

    @Override
    protected void injectMembers(HasServiceComponentBuilders builders) {
        ((MetadataComponent.Builder) builders.getServiceBuilders(MetadataView.class))
            .serviceModule(new MetadataComponent.MetadataModule(this))
            .build().injectMembers(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        //audioManager.registerRemoteController(remote);
        //presenter.getLastLocation();
        //presenter.getLocationUpdate();
        return startId;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        //audioManager.unregisterRemoteController(remote);
    }

    @Override
    public void onClientMetadataUpdate(RemoteController.MetadataEditor e) {
        if (audioManager.isMusicActive()) {
            String title = e.getString(MediaMetadataRetriever.METADATA_KEY_TITLE, "");
            String album = e.getString(MediaMetadataRetriever.METADATA_KEY_ALBUM, "");
            String artist = e.getString(MediaMetadataRetriever.METADATA_KEY_ARTIST, album);
            presenter.trackUpdate(title, album, artist);
        }
    }

    @Subscribe
    public void musicControls(Event event) {
        if (event.getType()== Action.CONTROL_TRACK) {
            remote.sendMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, (int)event.getObject()));
            remote.sendMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, (int)event.getObject()));
        }
    }

    // Unused Methods
    @Override public void onClientChange(boolean b) {

    }
    @Override public void onClientPlaybackStateUpdate(int i) {

    }
    @Override public void onClientPlaybackStateUpdate(int i, long l, long l1, float v) {

    }
    @Override public void onClientTransportControlUpdate(int i) {

    }
    @Override public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
    }
    @Override public void onNotificationPosted(StatusBarNotification sbn, RankingMap rankingMap) {
        super.onNotificationPosted(sbn, rankingMap);
    }
    @Override public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
    }
    @Override public void onNotificationRemoved(StatusBarNotification sbn, RankingMap rankingMap) {
        super.onNotificationRemoved(sbn, rankingMap);
    }

}