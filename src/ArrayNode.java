import java.util.HashMap;


public class ArrayNode extends TreeNode{

	HashMap<String, Value> Array;
	@Override
	public CallBack execute(HashMap<String, Value> vars) {
		Array = new HashMap<String, Value>();
		Double i = 0.0;
		for(TreeNode t : childs)
		{
			Array.put(i.toString(), t.execute(vars).result);
			i++;
		}		
		return new CallBack(Stop.normal, new Value(5, Array));
	}

}
