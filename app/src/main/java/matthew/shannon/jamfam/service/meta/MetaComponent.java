package matthew.shannon.jamfam.service.meta;


import dagger.Subcomponent;

@MetaScope
@Subcomponent(modules = MetaModule.class)
public interface MetaComponent {

    MetaView inject(MetaView activity);

}
