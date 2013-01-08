import java.util.HashMap;


public class PrintNode extends TreeNode {

    @Override
    public CallBack execute(HashMap<String, Value> vars) {
        for (TreeNode t : childs) {
            System.out.println(t.execute(vars).result.Value);
        }
        return new CallBack(Stop.normal, null);
    }
}