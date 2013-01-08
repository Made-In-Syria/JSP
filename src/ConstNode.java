import java.util.HashMap;


public class ConstNode extends TreeNode {
	 Value value;

	    public ConstNode(Value value) {
	        this.value = value;
	    }

	    @Override
	    public CallBack execute(HashMap<String, Value> vars) {
	        return new CallBack(Stop.normal, value);
	    }
}
