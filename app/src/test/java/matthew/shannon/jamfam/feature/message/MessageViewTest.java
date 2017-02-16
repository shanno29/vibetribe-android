package matthew.shannon.jamfam.feature.message;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import matthew.shannon.jamfam.BuildConfig;

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class, sdk=23)
public class MessageViewTest {

    private MessageView messageView;

    @Before
    public void setUp() {
        messageView = Robolectric.setupActivity(MessageView.class);
    }

    @Test
    public void shouldStartNextActivityWhenButtonIsClicked() {
        messageView.onDestroy();
    }



}
