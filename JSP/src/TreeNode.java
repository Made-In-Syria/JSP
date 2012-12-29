
import java.util.ArrayList;

public abstract class TreeNode {

    protected ArrayList<TreeNode> childs = new ArrayList<TreeNode>();

    public abstract Object execute();

    public void addChild(TreeNode node) {
        childs.add(node);
    }
}