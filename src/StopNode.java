import java.util.HashMap;

public class StopNode extends TreeNode{

	public Stop type;// = Stop.normal;
	@Override
	public CallBack execute(HashMap<String, Value> vars) {

		if (type == Stop.returns)
			{
				if (childs.size()>0){
					return new CallBack(Stop.returns, childs.get(0).execute(vars).result);
				}
				return new CallBack(Stop.returns, new Value(0,(Double)0.));
			}
		else if (type == Stop.continues)
			return new CallBack(Stop.continues, null);
		else
			return new CallBack(Stop.breaks, null);
	}

}
