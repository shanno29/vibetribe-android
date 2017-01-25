package matthew.shannon.jamfam.feature.message;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import matthew.shannon.jamfam.MockApp;
import matthew.shannon.jamfam.model.local.flow.FlowService;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class MessageViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<MessageView> activityRule = new ActivityTestRule<>(MessageView.class, true, false);

    @Mock
    FlowService flow;

    @Mock
    MessageComponent.Builder builder;

    private MessageComponent messageComponent = new MessageComponent() {
        @Override
        public void injectMembers(MessageView instance) {
            instance.presenter = new MessagePresenter(instance, flow);
        }
    };

    @Before
    public void setUp() {
        when(builder.build()).thenReturn(messageComponent);
        when(builder.activityModule(any(MessageComponent.MessageModule.class))).thenReturn(builder);

        MockApp app = (MockApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.putActivityComponentBuilder(builder, MessageView.class);
    }

    @Test
    public void init() {
        activityRule.launchActivity(new Intent());
    }

}