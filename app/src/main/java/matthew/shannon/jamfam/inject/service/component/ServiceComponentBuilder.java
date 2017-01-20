package matthew.shannon.jamfam.inject.service.component;


public interface ServiceComponentBuilder<M extends ServiceComponent.ServiceModule, C extends ServiceComponent> {
    ServiceComponentBuilder<M, C> serviceModule(M serviceModule);
    C build();
}