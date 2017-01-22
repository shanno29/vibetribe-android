package matthew.shannon.jamfam.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("_id") @Expose private String _id;
    @SerializedName("text") @Expose private String text;
    @SerializedName("relative") @Expose private String relative;

    public Comment(String _id, String text, String relative) {
        this._id = _id;
        this.text = text;
        this.relative = relative;
    }

    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
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