
import java.util.HashMap;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class AssignmentNode extends TreeNode {

    String var;
    public TreeNode index;
    public boolean isIndex = false;
    public String Type;

    public AssignmentNode(String var) {
        this.var = var;
    }

    @Override
    public CallBack execute(HashMap<String, Value> vars) {
    	Value v = childs.get(0).execute(vars).result;
    	int type = v.Type;
    	Value result = null;
    	
    	Object left = null;
    	if (isIndex) {
    		HashMap<String, Value> array;
    		array = (HashMap<String, Value>) vars.get(var).Value;
    		if (array.get(index.execute(vars).result.Value.toString()) != null)
    			left = array.get(index.execute(vars).result.Value.toString()).Value;
    	} else {
    		if (vars.get(var) != null)
    			left = vars.get(var).Value;
    	}
    	//if Number
    	if(type == 0)
    	{
    		Double temp = null;
    		Double temp2 = (Double)v.Value;

    		if (left != null)
    			temp = (Double)(left);
    		if(temp == null)
    			temp = new Double(0);


    			if (Type.equals("+="))
    				temp = temp + temp2;
    			if (Type.equals("-="))
    				temp = temp - temp2;
    			if (Type.equals("*="))
    				temp = temp * temp2;
    			if (Type.equals("/="))
    				temp = temp / temp2;
    			if (Type.equals("%="))
    				temp = temp % temp2;
    			if (Type.equals("="))
    				temp = temp2;

    			Value newV= new Value(0, temp);
    			result = newV;

    	}
    	//if String
    	else
    		if(type == 1)
    	{
    		String temp2 = (String)v.Value;
    		String temp = null;
    		if (vars.get(var) != null)
    			temp = (String)left;
    			if (temp == null)
    				temp = "";

    			if (Type.equals("+=")){
    				temp = temp + temp2;
    			} else if (Type.equals("=")){
	    				temp = temp2;
    			}else{
	    				//throw new exption
	    		}
    			Value newV= new Value(1, temp);
    			result = newV;
    	} else {
    		if (Type.equals("=")){
    			result = v;
    		} else {
    			// bad assignment
    		}
    	}
    	if (isIndex) {
    		HashMap<String, Value> array;
    		if (vars.get(var) == null)
    			array = new HashMap<String, Value>();
    		else
    			array = (HashMap<String, Value>)vars.get(var).Value;
    		//System.out.println(result.Value);
    		//System.out.println(index.execute(vars).result.Value.toString());
    		array.put(index.execute(vars).result.Value.toString(), result);
    		if (vars.get(var) == null)
    			vars.put(var, new Value(5, array));
    	} else { 
    		vars.put(var, result);
    	}

        
        return new CallBack(Stop.normal, null);
    }
}