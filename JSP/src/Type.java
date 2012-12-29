
import java.util.HashMap;

public class Type {

    public HashMap<String, Value> Fields;

    public Type() {
        this.Fields = new HashMap<String, Value>();
    }

    public Type(Type t) {
        this.Fields = new HashMap<String, Value>(t.Fields);
    }
}