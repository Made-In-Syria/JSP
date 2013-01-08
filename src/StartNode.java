import java.util.HashMap;


public class StartNode extends TreeNode {
	 @Override
	    public CallBack execute(HashMap<String, Value> vars) {
		 	CallBack last;
	        for (TreeNode t : childs) {
	            last = t.execute(vars);

	            if (last.s == Stop.returns){
	            	return last;
	            }

	            if (last.s == Stop.breaks || last.s == Stop.continues || last.s == Stop.returns)
	            	return last;
	        }
	        return new CallBack(Stop.normal,null);
	    }
}
