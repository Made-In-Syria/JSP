
public class IfNode extends TreeNode {

    public boolean hasElse = false;

    @Override
    public Object execute() {
        if ((Boolean) childs.get(0).execute()) {
            childs.get(1).execute();
        } else {
            for (int i = 2; i < childs.size() - 1; i++) {
                if ((Boolean) childs.get(i++).execute()) {
                    childs.get(i).execute();
                    return null;
                }
            }
            if (hasElse) {
                childs.get(childs.size() - 1).execute();
            }
        }
        return null;
    }
}