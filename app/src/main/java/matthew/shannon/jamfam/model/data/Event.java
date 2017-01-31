package matthew.shannon.jamfam.model.data;

public class Event {

    private int type;
    private Object object;

    public Event() {
        this(0);
    }

    public Event(int type) {
        this(type, null);
    }

    public Event(int type, Object object) {
        this.object = object;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
