package matthew.shannon.jamfam.feature.search;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.R;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=21)
public class SearchViewTest {

    private SearchView searchView;

    @Before
    public void setUp() {
        searchView = Robolectric.setupActivity(SearchView.class);
    }

    @Test
    public void shouldStartNextActivityWhenButtonIsClicked() {

        MaterialSearchView search = (MaterialSearchView) searchView.findViewById(R.id.search);
        MaterialViewPager viewPager = (MaterialViewPager) searchView.findViewById(R.id.viewpager);

        search.performClick();
        search.showSearch();
        viewPager.getViewPager().setCurrentItem(1);
        viewPager.getViewPager().setCurrentItem(2);
        viewPager.getViewPager().setCurrentItem(3);
        viewPager.getViewPager().setCurrentItem(4);


        searchView.showToast("Hello World");

        search.performClick();
        search.setQuery("test", false);
        searchView.onBackPressed();

        search.performClick();
        search.setQuery("test", true);

        search.performClick();
        search.showSearch();

        //Close Activity
        searchView.onBackPressed();
        searchView.onDestroy();
    }



}
