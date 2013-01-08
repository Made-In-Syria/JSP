import java.util.HashMap;


public class IfNode extends TreeNode {

    public boolean hasElse = false;

    @Override
    public CallBack execute(HashMap<String, Value> vars) {
        if ((Double)childs.get(0).execute(vars).result.Value != 0.) {
            return childs.get(1).execute(vars);
        } else {
            for (int i = 2; i < childs.size() - 1; i++) {
                if ((Double)(childs.get(i++).execute(vars).result).Value != 0.) {
                    return childs.get(i).execute(vars);
                }
            }
            if (hasElse) {
                return childs.get(childs.size() - 1).execute(vars);
            }
        }
        return new CallBack(Stop.normal, null);
    }
}