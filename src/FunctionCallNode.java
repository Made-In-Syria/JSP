import java.awt.List;
import java.util.HashMap;


public class FunctionCallNode extends TreeNode {
	public String name;
	int type = 0;
	HashMap<String, Value> params = new HashMap<String, Value>();


	@Override
	public CallBack execute(HashMap<String, Value> vars) {
		params = new HashMap<String, Value>();
		Value v;
		List l;
		v = vars.get(name);



		if (type==0){
			l = ((FunctionNode)v.Value).params;
			int i = 0;
			for (TreeNode t : childs) {
				//System.out.println((Double) t.execute(vars).result.Value);
				params.put(l.getItem(i), t.execute(vars).result );
				i++;
			}
			for(String key : vars.keySet())
			{
				//TODO: Stupid first condition
				if(vars.get(key)!=null && vars.get(key).Type==2)
					params.put(key, vars.get(key));
			}
			return ((FunctionNode)vars.get(name).Value).call(params);
		} else if (type==2){
			params.putAll(vars);
			l = ((FunctionNode)v.Value).params;
			int i = 0;
			for (TreeNode t : childs) {
				//System.out.println((Double) t.execute(vars).result.Value);
				params.put(l.getItem(i), t.execute(vars).result );
				i++;
			}
			return ((FunctionNode)vars.get(name).Value).call(params);
		} else {

			FunctionNode clas;
			FunctionNode cons = null;
			clas = (FunctionNode)v.Value;
			for (TreeNode t : clas.childs.get(0).childs){
				//System.out.println(t.getClass());
				if (t.getClass().toString().equals("class FunctionNode") && ((FunctionNode)t).name.equals(name)){
					cons = (FunctionNode)t;
					break;
				}
			}
			l = cons.params;
			int i = 0;
			if (!cons.childs.isEmpty()) {
				for (TreeNode t : childs) {
					//System.out.println((Double) t.execute(vars).result.Value);
					params.put(l.getItem(i), t.execute(vars).result );
					i++;
				}
			}
			for(String key : vars.keySet())
			{
				if(vars.get(key).Type==2)
					params.put(key, vars.get(key));
			}
			if (cons != null){
				clas.call(params);
				cons.call(params);
				
//				System.out.print("coco");
				return new CallBack(Stop.normal, new Value(4, params));
				
			} else {
				return new CallBack(Stop.normal, null);
			}
		}
	}
}
