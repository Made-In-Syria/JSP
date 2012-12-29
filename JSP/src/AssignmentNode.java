
import java.util.*;

public class AssignmentNode extends TreeNode {

    public Boolean isType = false;
    String var;
    public String FieldName;
    HashMap <String, Value> vars;

    public AssignmentNode(HashMap<String, Value> vars, String var) {
        this.var = var;
        this.vars = vars;
    }

    @Override
    public Object execute() {
        if (!isType) {
            if (var.charAt(var.length() - 1) == '$') {
                vars.put(var, (Value) childs.get(0).execute());
            } else if (var.charAt(var.length() - 1) == '!' || var.charAt(var.length() - 1) == '#') {
                vars.put(var, (Value) childs.get(0).execute());
            } else //(var.charAt(var.length()-1) == '&' || var.charAt(var.length()-1) == '%')
            {
                vars.put(var, (Value) childs.get(0).execute());
            }
        } else {
            ((Type) vars.get(var).Value).Fields.put(FieldName, (Value) childs.get(0).execute());
        }
        return null;
    }
}