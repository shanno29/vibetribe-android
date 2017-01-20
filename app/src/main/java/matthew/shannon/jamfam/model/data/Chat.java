package matthew.shannon.jamfam.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Chat {

    @SerializedName("updatedAt") @Expose
    private String updatedAt;

    @SerializedName("_id") @Expose
    private String _id;

    @SerializedName("createdAt") @Expose
    private String createdAt;

    @SerializedName("owners") @Expose
    private List<User> owners;

    @SerializedName("message") @Expose
    private List<Message> message;

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

    public List<Message> getMessages() {
        return message;
    }

    @Override
    public String toString() {
        return "Chat [updatedAt = " + updatedAt + ", _id = " + _id + ", createdAt = " + createdAt +
                ", owners = " + owners + ", messages = " + message + "]";
    }
}