package matthew.shannon.jamfam.inject.app.module;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.inject.service.component.MetadataComponent;
import matthew.shannon.jamfam.view.service.MetadataView;
import matthew.shannon.jamfam.inject.service.component.ServiceComponentBuilder;
import matthew.shannon.jamfam.inject.service.scope.ServiceKey;

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