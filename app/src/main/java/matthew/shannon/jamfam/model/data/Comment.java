package matthew.shannon.jamfam.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("text") @Expose
    private String text;

    @SerializedName("_id") @Expose
    private String _id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String get_id() {
        return _id;
    }


    @Override
    public String toString() {
        return "Comment [text = " + text + ", _id = " + _id + "]";
    }
}