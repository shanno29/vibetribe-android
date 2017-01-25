package matthew.shannon.jamfam.model.data;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FragTypeModelTest {

    @Test public void testMessageModel() {
        FragType fragType = new FragType(FragType.FRIENDS_TRACKS);
        assertEquals(FragType.FRIENDS_TRACKS, fragType.itemType);

    }

}