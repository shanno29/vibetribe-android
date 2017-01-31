package matthew.shannon.jamfam.feature.meta;

import android.media.RemoteController;

public interface MetaService extends RemoteController.OnClientUpdateListener {

    void onClientChange(boolean b);

    void onClientPlaybackStateUpdate(int i);

    void onClientPlaybackStateUpdate(int i, long l, long l1, float v);

    void onClientTransportControlUpdate(int i);

    void onClientMetadataUpdate(RemoteController.MetadataEditor metadataEditor);

}
