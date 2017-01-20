package matthew.shannon.vibetribe;

import android.os.Build;
import org.junit.Test;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

@Config(sdk = Build.VERSION_CODES.KITKAT)
public class UsefulUtilsTest {

    @Test
    public void testSum_standard() {
        assertEquals(6, UsefulUtils.sum(1, 2, 3));
    }

    @Test
    public void testSum_empty() {
        assertEquals(0, UsefulUtils.sum());
    }
}