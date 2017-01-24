package matthew.shannon.jamfam.model.data;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class UserModelTest {

    @Test public void testUserModel() {
        User user = new User();
        user.set_id("id");
        user.setEmail("email");
        user.setUsername("username");
        user.setPassword("password");
        user.setPasswordTwo("passwordTwo");
        user.setType("type");
        user.setVersion("version");
        user.setFullname("fullname");
        user.setToken("token");
        user.setCity("city");
        user.setState("state");
        user.setAge("age");
        user.setGender("gender");
        user.setAboutme("aboutme");
        user.setAvatar("avatar");
        user.setBanner("banner");

        assertEquals("id", user.get_id());
        assertEquals("email", user.getEmail());
        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("passwordTwo", user.getPasswordTwo());
        assertEquals("type", user.getType());
        assertEquals("version", user.getVersion());
        assertEquals("fullname", user.getFullname());
        assertEquals("token", user.getToken());
        assertEquals("city", user.getCity());
        assertEquals("state", user.getState());
        assertEquals("age", user.getAge());
        assertEquals("gender", user.getGender());
        assertEquals("aboutme", user.getAboutme());
        assertEquals("avatar", user.getAvatar());
        assertEquals("banner", user.getBanner());
    }

}