package matthew.shannon.jamfam.feature.profile;

import android.content.ContentResolver;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.fuck_boilerplate.rx_paparazzo.entities.Response;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.inject.Named;

import matthew.shannon.jamfam.MockApp;
import matthew.shannon.jamfam.model.data.User;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;
import rx.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class ProfileViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<ProfileView> activityRule = new ActivityTestRule<>(ProfileView.class, true, false);

    @Mock
    FlowService flow;

    @Mock
    ProfileComponent.Builder builder;

    @Mock
    @Named("pictureObservable") Observable<Response<ProfileView, String>> picture;

    @Mock
    @Named("bannerObservable")
    Observable<Response<ProfileView, String>> banner;

    @Mock
    ContentResolver resolver;

    @Mock
    NetworkService network;

    @Mock
    CacheService cache;

    @Mock
    BusService bus;

    @Mock
    User user;


    private ProfileComponent profileComponent = new ProfileComponent() {
        @Override
        public void injectMembers(ProfileView instance) {
            instance.presenter = new ProfilePresenter(picture, banner, resolver, network, instance, cache, bus, user);
        }
    };

    @Before
    public void setUp() {
        when(builder.build()).thenReturn(profileComponent);
        when(builder.activityModule(any(ProfileComponent.ProfileModule.class))).thenReturn(builder);

        MockApp app = (MockApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.putActivityComponentBuilder(builder, ProfileView.class);
    }

    @Test
    public void init() {
        activityRule.launchActivity(new Intent());

    }

}