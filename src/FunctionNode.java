import java.awt.List;
import java.util.HashMap;

public class FunctionNode extends TreeNode{

	public String name;
	public List params = new List();

	@Override
	public CallBack execute(HashMap<String, Value> vars) {
		// set functoin name
		vars.put(name, new Value(2,this));
		return new CallBack(Stop.normal, null);
	}

	public CallBack call(HashMap<String, Value> vars){
		//
		//CallBack b = childs.get(0).execute(vars);
		return childs.get(0).execute(vars);
	}

//	public void setParams(){
//		int i=1;
//	}
}
