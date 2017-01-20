package matthew.shannon.jamfam.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("spotify") @Expose
    private String spotify;

    @SerializedName("updatedAt") @Expose
    private String updatedAt;

    @SerializedName("title") @Expose
    private String title;

    @SerializedName("_id") @Expose
    private String _id;

    @SerializedName("createdAt") @Expose
    private String createdAt;

    @SerializedName("album") @Expose
    private String album;

    @SerializedName("owner") @Expose
    private User owner;

    @SerializedName("youtube") @Expose
    private String youtube;

    @SerializedName("longitude") @Expose
    private Double longitude;

    @SerializedName("latitude") @Expose
    private Double latitude;

    @SerializedName("artist") @Expose
    private String artist;

    @SerializedName("soundcloud") @Expose
    private String soundcloud;

    @SerializedName("artwork") @Expose
    private String artwork;

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String get_id() {
        return _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSoundcloud() {
        return soundcloud;
    }

    public void setSoundcloud(String soundcloud) {
        this.soundcloud = soundcloud;
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    @Override
    public String toString() {
        return "Track [spotify = " + spotify + ", updatedAt = " + updatedAt + ", title = " + title +
                ", _id = " + _id + ", createdAt = " + createdAt + ", album = " + album +
                ", owner = " + owner + ", youtube = " + youtube + ", longitude = " + longitude +
                ", latitude = " + latitude + ", artist = " + artist +
                ", soundcloud = " + soundcloud + ", artwork = " + artwork + "]";
    }

}