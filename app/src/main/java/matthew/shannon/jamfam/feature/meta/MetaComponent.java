package matthew.shannon.jamfam.feature.meta;


import dagger.Subcomponent;

@MetaScope
@Subcomponent(modules = MetaModule.class)
public interface MetaComponent {

    MetaView inject(MetaView activity);

}
