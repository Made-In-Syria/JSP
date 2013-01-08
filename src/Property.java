import java.util.HashMap;
public class Property {

    public HashMap<String, Value> Fields;

    public Property() {
        this.Fields = new HashMap<String, Value>();
    }

    public Property(Property t) {
        this.Fields = new HashMap<String, Value>(t.Fields);
    }
}