package matthew.shannon.jamfam.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {

    @SerializedName("updatedAt") @Expose
    private String updatedAt;

    @SerializedName("_id") @Expose
    private String _id;

    @SerializedName("createdAt") @Expose
    private String createdAt;

    @SerializedName("owners") @Expose
    private List<User> owners;

    @SerializedName("comments") @Expose
    private List<Comment> comments;

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String get_id() {
        return _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public List<User> getOwners() {
        return owners;
    }

    public List<Comment> getComments() {
        return comments;
    }


    @Override
    public String toString() {
        return "Post [updatedAt = " + updatedAt + ", _id = " + _id + ", createdAt = " + createdAt +
                ", owners = " + owners + ", comments = " + comments + "]";
    }
}