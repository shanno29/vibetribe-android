package matthew.shannon.jamfam.feature.list;


import dagger.Subcomponent;

@ListScope
@Subcomponent(modules = ListModule.class)
public interface ListComponent {

    ListView inject(ListView activity);

}
