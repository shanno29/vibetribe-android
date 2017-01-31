package matthew.shannon.jamfam.feature.meta;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteController;
import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.location.LocationService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

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
    AudioManager provideAudioManager(Application application) {
        return (AudioManager) application.getSystemService(Context.AUDIO_SERVICE);
    }

    @Provides
    @MetaScope
    RemoteController remoteController(){
        return new RemoteController(service.getApplicationContext(), service);
    }

    @Provides
    @MetaScope
    MetaContract.Presenter metadataPresenter(LocationService location, NetworkService network, CacheService cache, BusService bus, Track track){
        return new MetaPresenter(location, network, cache, bus, service, track);
    }

}