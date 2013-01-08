import java.util.HashMap;


public class ObjectNode extends TreeNode{
	public String name;
	HashMap<String, Value> params; 

	@Override
	public CallBack execute(HashMap<String, Value> vars) {
		//System.out.print(name);
		params = (HashMap<String, Value>) vars.get(name).Value;
		return childs.get(0).execute(params);
	}

}
