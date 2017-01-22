package matthew.shannon.jamfam.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("_id") @Expose private String _id;
    @SerializedName("title") @Expose private String title;
    @SerializedName("artist") @Expose private String artist;
    @SerializedName("album") @Expose private String album;
    @SerializedName("latitude") @Expose private Double latitude;
    @SerializedName("longitude") @Expose private Double longitude;
    @SerializedName("spotify") @Expose private String spotify;
    @SerializedName("soundcloud") @Expose private String soundcloud;
    @SerializedName("youtube") @Expose private String youtube;
    @SerializedName("artwork") @Expose private String artwork;
    @SerializedName("owner") @Expose private User owner;
    @SerializedName("createdAt") @Expose private String createdAt;
    @SerializedName("updatedAt") @Expose private String updatedAt;
    @SerializedName("relative") @Expose private String relative;

    public Track() {}

    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }

    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getSpotify() {
        return spotify;
    }
    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    public String getSoundcloud() {
        return soundcloud;
    }
    public void setSoundcloud(String soundcloud) {
        this.soundcloud = soundcloud;
    }

    public String getYoutube() {
        return youtube;
    }
    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getArtwork() {
        return artwork;
    }
    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRelative() {
        return relative;
    }
    public void setRelative(String relative) {
        this.relative = relative;
    }

}