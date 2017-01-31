package matthew.shannon.jamfam.list;


import dagger.Subcomponent;

@ListScope
@Subcomponent(modules = ListModule.class)
public interface ListComponent {

    ListView inject(ListView activity);

}
