package matthew.shannon.jamfam.fragment;

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

import matthew.shannon.jamfam.ApplicationMock;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.inject.fragment.component.TrackComponent;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.presenter.fragment.TrackPresenter;
import matthew.shannon.jamfam.view.activity.TestFragmentActivity;
import matthew.shannon.jamfam.view.fragment.TrackView;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class TrackViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<TestFragmentActivity> activityRule = new ActivityTestRule<>(TestFragmentActivity.class, true, false);

    @Mock
    NetworkService network;

    @Mock
    CacheService cache;

    @Mock
    BusService bus;

    @Mock
    TrackComponent.Builder builder;

    private TrackComponent trackComponent = new TrackComponent() {
        @Override
        public void injectMembers(TrackView instance) {
            instance.presenter = new TrackPresenter(network, cache, bus, instance);
        }
    };

    @Before
    public void setUp() {
        activityRule.launchActivity(TestFragmentActivity.getStartIntent(getTargetContext(), false));




    }

    @Test
    public void init() {

        FragmentManager fragmentManager = activityRule.getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_test_fragment_linearlayout, new TrackView()).commitAllowingStateLoss();

        when(builder.build()).thenReturn(trackComponent);
        when(builder.fragmentModule(any(TrackComponent.TrackModule.class))).thenReturn(builder);

        ApplicationMock app = (ApplicationMock) getTargetContext().getApplicationContext();
        app.putFragmentComponentBuilder(builder, TrackView.class);

        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        instrumentation.waitForIdleSync();



    }

    @Test
    public void checkTextView() {

    }

}