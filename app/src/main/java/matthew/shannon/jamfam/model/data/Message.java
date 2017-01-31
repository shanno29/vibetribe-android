package matthew.shannon.jamfam.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("relative")
    @Expose
    private String relative;

    public Message(String _id, String author, String text, String relative) {
        this._id = _id;
        this.author = author;
        this.text = text;
        this.relative = relative;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRelative() {
        return relative;
    }

    public void setRelative(String relative) {
        this.relative = relative;
    }

}