package matthew.shannon.jamfam.model.data;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ActionModelTest {

    @Test public void testMessageModel() {
        Action action = new Action(Action.REFRESH);
        assertEquals(Action.REFRESH, action.action);

    }

}