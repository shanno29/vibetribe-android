package matthew.shannon.jamfam.model.data;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CommentModelTest {

    @Test public void testCommentModel() {
        Comment comment = new Comment("id", "text", "relative");
        assertEquals("id", comment.get_id());
        assertEquals("text", comment.getText());
        assertEquals("relative", comment.getRelative());

        comment.set_id("new id");
        comment.setText("new text");
        comment.setRelative("new relative");
        assertEquals("new id", comment.get_id());
        assertEquals("new text", comment.getText());
        assertEquals("new relative", comment.getRelative());
    }

}