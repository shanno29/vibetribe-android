package matthew.shannon.jamfam.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Chat {

    @SerializedName("_id") @Expose private String _id;
    @SerializedName("createdAt") @Expose private String createdAt;
    @SerializedName("updatedAt") @Expose private String updatedAt;
    @SerializedName("relative") @Expose private String relative;
    @SerializedName("owners") @Expose private List<User> owners;
    @SerializedName("messages") @Expose private List<Message> messages;

    public Chat() {}

    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
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

    public List<User> getOwners() {
        return owners;
    }
    public void setOwners(List<User> owners) {
        this.owners = owners;
    }

    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}