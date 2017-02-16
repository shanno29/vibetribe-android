package matthew.shannon.jamfam.service.meta;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteController;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.service.cache.CacheService;
import matthew.shannon.jamfam.service.flow.FlowService;
import matthew.shannon.jamfam.service.location.LocationService;
import matthew.shannon.jamfam.service.network.NetworkService;

@Module
public class MetaModule {

    private MetaView service;

    public MetaModule(MetaView service) {
        this.service = service;
    }

    @Provides
    @MetaScope
    Track provideTrack() {
        return new Track();
    }

    @Provides
    @MetaScope
    RemoteController remoteController() {
        return new RemoteController(service.getApplicationContext(), service);
    }

    @Provides
    @MetaScope
    MetaContract.Presenter metadataPresenter(LocationService location, NetworkService network, CacheService cache, FlowService flow, Track track) {
        return new MetaPresenter(location, network, cache, flow, service, track);
    }

}