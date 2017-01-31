package matthew.shannon.jamfam.model;

import org.junit.Test;

import matthew.shannon.jamfam.model.data.FragType;

import static junit.framework.Assert.assertEquals;

public class FragTypeModelTest {

    @Test public void testMessageModel() {
        FragType fragType = new FragType(FragType.FRIENDS_TRACKS);
        assertEquals(FragType.FRIENDS_TRACKS, fragType.itemType);

    }

}