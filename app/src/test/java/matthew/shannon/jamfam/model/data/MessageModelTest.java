package matthew.shannon.jamfam.model.data;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MessageModelTest {

    @Test public void testMessageModel() {
        Message message = new Message("id", "author", "text", "relative");
        assertEquals("id", message.get_id());
        assertEquals("author", message.getAuthor());
        assertEquals("text", message.getText());
        assertEquals("relative", message.getRelative());

        message.set_id("new id");
        message.setAuthor("new author");
        message.setText("new text");
        message.setRelative("new relative");
        assertEquals("new id", message.get_id());
        assertEquals("new author", message.getAuthor());
        assertEquals("new text", message.getText());
        assertEquals("new relative", message.getRelative());

    }

}