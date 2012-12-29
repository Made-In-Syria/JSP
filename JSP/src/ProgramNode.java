
public class ProgramNode extends TreeNode {

    @Override
    public Object execute() {

        for (TreeNode t : childs) {
            t.execute();
        }
        return null;
    }
}