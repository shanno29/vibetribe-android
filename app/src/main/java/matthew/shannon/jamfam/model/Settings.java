package matthew.shannon.jamfam.model;


public class Settings {
    private String description;
    private String value;

    public Settings(String description, String value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
