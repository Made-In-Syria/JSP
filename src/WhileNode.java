import java.util.HashMap;


public class WhileNode extends TreeNode{

	    public boolean hasStep = false;
	    public String LoopVar;

	    @Override
	    public CallBack execute(HashMap<String, Value> vars) {
	    	CallBack last;
	    	//childs.get(0).execute();
	    	while ((Double)childs.get(0).execute(vars).result.Value != 0.) {
	    		last = childs.get(1).execute(vars);
	    		if (last.s == Stop.breaks)
	    			return new CallBack(Stop.normal, null);
	    		else if (last.s == Stop.returns)
	    			return last;
	    		//else if (last.s == Stop.continues)
	    			//
	    		//childs.get(2).execute();
	    	}
//	        Long step = new Long(1);
//	        if (hasStep) {
//	            step = (Long) ((Value) childs.get(childs.size() - 1).execute()).Value;
//	        }
//	        for (Long i = (Long) ((Value) childs.get(0).execute()).Value; i < (Long) ((Value) childs.get(1).execute()).Value;) {
//	            QBASIC.Vars.put(LoopVar, new Value(0, i));
//	            for (int c = 2; c < childs.size(); c++) {
//	                childs.get(c).execute();
//	            }
//	            i += step;
//	        }
	    	return new CallBack(Stop.normal,null);
	    }
	}