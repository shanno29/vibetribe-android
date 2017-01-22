package matthew.shannon.vibetribe;

import org.junit.Test;
import matthew.shannon.jamfam.model.data.Event;
import static junit.framework.Assert.assertEquals;

public class EventModelTest {

    @Test public void testEvent() {
        Event event = new Event();
        event.setType(0);
        event.setObject(null);

        assertEquals(0, event.getType());
        assertEquals(null, event.getObject());
    }

}