package matthew.shannon.jamfam.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowAudioManager;

import matthew.shannon.jamfam.BuildConfig;
import matthew.shannon.jamfam.service.meta.MetaContract;
import matthew.shannon.jamfam.service.meta.MetaView;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class MetaViewTest {

    private MetaView service;

    @Before
    public void setUp() {
        service = Robolectric.setupService(MetaView.class);

        service.presenter = new MetaContract.Presenter() {
            @Override
            public void getLastLocation() {

            }

            @Override
            public void getLocationUpdate() {

            }

            @Override
            public void lookUpTrack() {

            }

            @Override
            public void trackUpdate(String title, String album, String artist) {

            }

            @Override
            public void unsubscribe() {

            }
        };
    }

    @Test
    public void whenTheFragmentViewIsCreatedThenTheViewShouldBePopulated() {
        //service.onStartCommand(new Intent(), 0, 0);
        service.showToast("");
        service.onClientChange(true);
        service.onClientPlaybackStateUpdate(0);
        service.onClientPlaybackStateUpdate(0, 0, 0, 0);
        service.onClientTransportControlUpdate(0);

        service.onNotificationPosted(null);
        service.onNotificationPosted(null, null);

        service.onNotificationRemoved(null);
        service.onNotificationRemoved(null, null);


        //service.musicControls(new Event(Action.CONTROL_TRACK, 0));

        //service.onDestroy();

    }
}