
import java.util.HashMap;

public class VariableNode extends TreeNode {

    public Boolean isType = false;
    public String var, FieldName;
    public int type = 0;


    @Override
    public CallBack execute(HashMap<String, Value> vars) {
        if (isType) {
        	return new CallBack(Stop.normal,((Property) vars.get(var).Value).Fields.get(FieldName));
        } else if (!vars.containsKey(var)) {
        	return new CallBack(Stop.normal,vars.get(var));
        	// throw exption var undefined
        } else {
        	Value v;
        	Value r;
        	Double result;
        	if (type == 1){
        		v = vars.get(var);
        		result = (Double)v.Value;
        		v.Value=((Double)v.Value)+1;
        		vars.put(var, v);
        		r = new Value(v.Type, result);
        		return new CallBack(Stop.normal,r);
        	}else if (type == 2){
        		v = vars.get(var);
        		result = (Double)v.Value;
        		v.Value=(Double)v.Value-1;
        		vars.put(var, v);
        		r = new Value(v.Type, result);
        		return new CallBack(Stop.normal,r);
        	}else if (type == 3){
        		v = vars.get(var);
        		v.Value=(Double)v.Value+1;
        		result = (Double)v.Value;
        		vars.put(var, v);
        		r = new Value(v.Type, result);
        		return new CallBack(Stop.normal,r);
        	}else if (type == 4){
        		v = vars.get(var);
        		v.Value=(Double)v.Value-1;
        		result = (Double)v.Value;
        		vars.put(var, v);
        		r = new Value(v.Type, result);
        		return new CallBack(Stop.normal,r);
        	} else if (type == 5) {
        		String t = childs.get(0).execute(vars).result.Value.toString();
        		HashMap<String, Value> array;
        		array = (HashMap<String, Value>)vars.get(var).Value;
        		return new CallBack(Stop.normal,array.get(t));
        	}
        	return new CallBack(Stop.normal,vars.get(var));
        }
    }
}