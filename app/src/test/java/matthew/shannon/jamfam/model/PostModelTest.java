package matthew.shannon.jamfam.model;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class PostModelTest {

    @Test public void testPostModel() {
        List<User> owners = Arrays.asList(new User(), new User());
        List<Comment> comments = Arrays.asList(new Comment("idOne", "textOne", "relativeOne"), new Comment("idTwo", "textTwo", "relativeTwo"));

        Post post = new Post();
        post.set_id("id");
        post.setCreatedAt("createdAt");
        post.setUpdatedAt("updatedAt");
        post.setRelative("relative");
        post.setOwners(owners);
        post.setComments(comments);

        assertEquals("id", post.get_id());
        assertEquals("createdAt", post.getCreatedAt());
        assertEquals("updatedAt", post.getUpdatedAt());
        assertEquals("relative", post.getRelative());
        assertEquals(owners, post.getOwners());
        assertEquals(comments, post.getComments());
    }

}