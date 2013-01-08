import java.util.HashMap;


public class ClassNode extends TreeNode{
	public String name;
	public HashMap<String, Value> params;

	@Override
	//return hashAA
	public CallBack execute(HashMap<String, Value> vars) {
		// TODO Auto-generated method stub
		return null;
	}

	public CallBack callFunction(String funcName, HashMap<String, Value> vars){
		return null;
	}

}
