package matthew.shannon.jamfam.feature.profile.info;

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
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import matthew.shannon.jamfam.model.base.TestFragmentActivity;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class InfoViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<TestFragmentActivity> activityRule = new ActivityTestRule<>(TestFragmentActivity.class, true, false);

    @Mock
    NetworkService network;

    @Mock
    CacheService cache;

    @Mock
    User user;

    @Mock
    InfoComponent.Builder builder;

    private InfoComponent infoComponent = new InfoComponent() {
        @Override
        public void injectMembers(InfoView instance) {
            instance.presenter = new InfoPresenter(network, cache, instance, user);
        }
    };

    @Before
    public void setUp() {
        activityRule.launchActivity(TestFragmentActivity.getStartIntent(getTargetContext(), false));




    }

    @Test
    public void init() {

        FragmentManager fragmentManager = activityRule.getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_test_fragment_linearlayout, InfoView.newInstance("test _id")).commitAllowingStateLoss();

        when(builder.build()).thenReturn(infoComponent);
        when(builder.fragmentModule(any(InfoComponent.UserInfoModule.class))).thenReturn(builder);

        MockApp app = (MockApp) getTargetContext().getApplicationContext();
        app.putFragmentComponentBuilder(builder, InfoView.class);

        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        instrumentation.waitForIdleSync();



    }

    @Test
    public void checkTextView() {

    }

}