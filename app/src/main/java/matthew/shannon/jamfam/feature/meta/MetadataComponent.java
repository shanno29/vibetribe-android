package matthew.shannon.jamfam.feature.meta;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteController;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import matthew.shannon.jamfam.inject.service.ServiceComponent;
import matthew.shannon.jamfam.inject.service.ServiceComponentBuilder;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.location.LocationService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

@MetadataComponent.MetadataScope
@Subcomponent(modules = MetadataComponent.MetadataModule.class)
public interface MetadataComponent extends ServiceComponent<MetadataView> {

    @Subcomponent.Builder
    interface Builder extends ServiceComponentBuilder<MetadataModule, MetadataComponent> {}

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    @interface MetadataScope {}

    @Module
    class MetadataModule extends ServiceModule<MetadataView> {

        public MetadataModule(MetadataView service) {
            super(service);
        }

        @Provides
        @MetadataScope
        Track provideTrack() {
            return new Track();
        }

        @Provides
        @MetadataScope
        AudioManager provideAudioManager(Application application) {
            return (AudioManager) application.getSystemService(Context.AUDIO_SERVICE);
        }

        @Provides
        @MetadataScope
        RemoteController remoteController(){
            return new RemoteController(service.getApplicationContext(), service);
        }

        @Provides
        @MetadataScope
        MetadataPresenter metadataPresenter(LocationService location, NetworkService network, CacheService cache, BusService bus, Track track){
            return new MetadataPresenter(location, network, cache, bus, service, track);
        }

    }

}
