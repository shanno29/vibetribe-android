package matthew.shannon.jamfam.feature.home.map;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import matthew.shannon.jamfam.MockApp;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.model.base.TestFragmentActivity;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class MapViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<TestFragmentActivity> activityRule = new ActivityTestRule<>(TestFragmentActivity.class, true, false);

    @Mock
    NetworkService network;

    @Mock
    MapComponent.Builder builder;

    private MapComponent mapComponent = new MapComponent() {
        @Override
        public void injectMembers(MapView instance) {
            instance.presenter = new MapPresenter(network, instance);
        }
    };

    @Before
    public void setUp() {
        activityRule.launchActivity(TestFragmentActivity.getStartIntent(getTargetContext(), false));




    }

    @Test
    public void init() {

        FragmentManager fragmentManager = activityRule.getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_test_fragment_linearlayout, new MapView()).commitAllowingStateLoss();

        when(builder.build()).thenReturn(mapComponent);
        when(builder.fragmentModule(any(MapComponent.MapModule.class))).thenReturn(builder);

        MockApp app = (MockApp) getTargetContext().getApplicationContext();
        app.putFragmentComponentBuilder(builder, MapView.class);

        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        instrumentation.waitForIdleSync();



    }

    @Test
    public void checkTextView() {

    }

}