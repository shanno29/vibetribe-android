package matthew.shannon.jamfam.feature.meta;


import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.concurrent.TimeoutException;

import matthew.shannon.jamfam.MockApp;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.local.bus.BusService;
import matthew.shannon.jamfam.model.local.cache.CacheService;
import matthew.shannon.jamfam.model.local.flow.FlowService;
import matthew.shannon.jamfam.model.remote.location.LocationService;
import matthew.shannon.jamfam.model.remote.network.NetworkService;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class MetadataViewTest {

    @Rule
    public final ServiceTestRule mServiceRule = new ServiceTestRule();


    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    LocationService location;

    @Mock
    NetworkService network;

    @Mock
    CacheService cache;

    @Mock
    BusService bus;

    @Mock
    Track track;

    @Mock
    FlowService flow;

    @Mock
    MetadataComponent.Builder builder;

    private MetadataComponent metadataComponent = new MetadataComponent() {
        @Override
        public void injectMembers(MetadataView instance) {
            instance.presenter = new MetadataPresenter(location, network, cache, bus, instance, track);
        }
    };

    @Before
    public void setUp() {

    }

    @Test
    public void testWithStartedService() throws TimeoutException {
        mServiceRule.startService(new Intent(InstrumentationRegistry.getTargetContext(), MetadataView.class));
        when(builder.build()).thenReturn(metadataComponent);
        when(builder.serviceModule(any(MetadataComponent.MetadataModule.class))).thenReturn(builder);

        MockApp app = (MockApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.putServiceComponentBuilder(builder, MetadataView.class);

    }

}