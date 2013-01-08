
import java.util.ArrayList;
import java.util.HashMap;

public abstract class TreeNode {

    protected ArrayList<TreeNode> childs = new ArrayList<TreeNode>();

    public abstract CallBack execute(HashMap<String, Value> vars);

    public void addChild(TreeNode node) {
        childs.add(node);
    }
}