package matthew.shannon.vibetribe.model.data;

import org.junit.Test;

import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.data.User;

import static junit.framework.Assert.assertEquals;

public class TrackModelTest {

    @Test public void testTrackModel() {
        User owner = new User();
        Track track = new Track();
        track.set_id("id");
        track.setTitle("title");
        track.setArtist("artist");
        track.setAlbum("album");
        track.setLatitude(4.20);
        track.setLongitude(4.20);
        track.setSpotify("spotify");
        track.setSoundcloud("soundcloud");
        track.setYoutube("youtube");
        track.setArtwork("artwork");
        track.setOwner(owner);
        track.setCreatedAt("createdAt");
        track.setUpdatedAt("updatedAt");
        track.setRelative("relative");

        assertEquals("id", track.get_id());
        assertEquals("title", track.getTitle());
        assertEquals("artist", track.getArtist());
        assertEquals("album", track.getAlbum());
        assertEquals(4.20, track.getLatitude());
        assertEquals(4.20, track.getLongitude());
        assertEquals("spotify", track.getSpotify());
        assertEquals("soundcloud", track.getSoundcloud());
        assertEquals("youtube", track.getYoutube());
        assertEquals("artwork", track.getArtwork());
        assertEquals(owner, track.getOwner());
        assertEquals("createdAt", track.getCreatedAt());
        assertEquals("updatedAt", track.getUpdatedAt());
        assertEquals("relative", track.getRelative());
    }

}