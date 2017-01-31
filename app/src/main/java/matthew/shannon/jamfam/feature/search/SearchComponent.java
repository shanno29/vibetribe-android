package matthew.shannon.jamfam.feature.search;


import dagger.Subcomponent;

@SearchScope
@Subcomponent(modules = SearchModule.class)
public interface SearchComponent {

    SearchView inject(SearchView activity);


}
