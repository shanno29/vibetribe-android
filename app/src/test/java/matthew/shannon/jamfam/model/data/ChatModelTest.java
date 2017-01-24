package matthew.shannon.jamfam.model.data;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ChatModelTest {

    @Test public void testChatModel() {
        List<User> owners = Arrays.asList(new User(), new User());
        List<Message> messages = Arrays.asList(new Message("idOne", "authorOne", "textOne", "relativeOne"), new Message("idTwo", "authorTwo", "textTwo", "relativeTwo"));

        Chat chat = new Chat();
        chat.set_id("id");
        chat.setCreatedAt("createdAt");
        chat.setUpdatedAt("updatedAt");
        chat.setRelative("relative");
        chat.setOwners(owners);
        chat.setMessages(messages);

        assertEquals("id", chat.get_id());
        assertEquals("createdAt", chat.getCreatedAt());
        assertEquals("updatedAt", chat.getUpdatedAt());
        assertEquals("relative", chat.getRelative());
        assertEquals(owners, chat.getOwners());
        assertEquals(messages, chat.getMessages());
    }

}