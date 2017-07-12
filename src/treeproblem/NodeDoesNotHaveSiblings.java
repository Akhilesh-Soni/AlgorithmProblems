package treeproblem;

/*Given a binary tree print all nodes that don’t have a sibling*/
public class NodeDoesNotHaveSiblings {
    private static void printAllNodesWhoDoesNotHaveSiblings(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printAllNodesWhoDoesNotHaveSiblings(treeNode.getLeft());
        printAllNodesWhoDoesNotHaveSiblings(treeNode.getRight());
        if (treeNode.getLeft() != null && treeNode.getRight() == null) {
            System.out.println(treeNode.getLeft().getData());
        }
        if (treeNode.getRight() != null && treeNode.getLeft() == null) {
            System.out.println(treeNode.getRight().getData());
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createBinaryTree();
        printAllNodesWhoDoesNotHaveSiblings(treeNode);
    }

}
