package matthew.shannon.jamfam.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("aboutme") @Expose
    private String aboutme;

    @SerializedName("state") @Expose
    private String state;

    @SerializedName("password") @Expose
    private String password;

    @SerializedName("passwordTwo") @Expose
    private String passwordTwo;

    @SerializedName("token") @Expose
    private String token;

    @SerializedName("city") @Expose
    private String city;

    @SerializedName("updatedAt") @Expose
    private String updatedAt;

    @SerializedName("picture") @Expose
    private String picture;

    @SerializedName("username") @Expose
    private String username;

    @SerializedName("_id") @Expose
    private String _id;

    @SerializedName("email") @Expose
    private String email;

    @SerializedName("createdAt") @Expose
    private String createdAt;

    @SerializedName("age") @Expose
    private String age;

    @SerializedName("gender") @Expose
    private String gender;

    @SerializedName("fullname") @Expose
    private String fullname;

    @SerializedName("client") @Expose
    private String client;

    @SerializedName("version") @Expose
    private String version;

    @SerializedName("banner") @Expose
    private String banner;

    @SerializedName("type") @Expose
    private String type;

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getPasswordTwo() {
        return passwordTwo;
    }

    public void setPasswordTwo(String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User [aboutme = " + aboutme + ", state = " + state + ", password = " + password +
                ", city = " + city + ", updatedAt = " + updatedAt + ", picture = " + picture +
                ", username = " + username + ", _id = " + _id + ", email = " + email +
                ", createdAt = " + createdAt + ", age = " + age + ", gender = " + gender +
                ", fullname = " + fullname + ", banner = " + banner + "]";
    }

}