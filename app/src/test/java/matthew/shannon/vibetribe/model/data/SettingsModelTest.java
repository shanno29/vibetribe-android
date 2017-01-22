package matthew.shannon.vibetribe.model.data;

import org.junit.Test;
import matthew.shannon.jamfam.model.data.Settings;
import static junit.framework.Assert.assertEquals;

public class SettingsModelTest {

    @Test public void testSettingsModel() {
        Settings settings = new Settings("description", "value");
        assertEquals("description", settings.getDescription());
        assertEquals("value", settings.getValue());

        settings.setDescription("new description");
        settings.setValue("new value");
        assertEquals("new description", settings.getDescription());
        assertEquals("new value", settings.getValue());
    }

}