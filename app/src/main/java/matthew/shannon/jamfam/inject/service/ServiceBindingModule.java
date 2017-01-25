package matthew.shannon.jamfam.inject.service;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.feature.meta.MetadataComponent;
import matthew.shannon.jamfam.feature.meta.MetadataView;

@Module(
    subcomponents = {
        MetadataComponent.class,
    })
public abstract class ServiceBindingModule {

    @Binds
    @IntoMap
    @ServiceKey(MetadataView.class)
    public abstract ServiceComponentBuilder MetadataComponentBuilder(MetadataComponent.Builder impl);

}