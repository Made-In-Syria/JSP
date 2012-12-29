
public class Value {

    public int Type;	//0:Int & Long 1:Single & Double 2: String
    public Object Value;

    public Value(int type, Object value) {
        this.Type = type;
        this.Value = value;
    }
}