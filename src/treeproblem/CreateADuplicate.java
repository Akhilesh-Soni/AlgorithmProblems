package treeproblem;

/**
 * For each node in a binary search tree,
 * create a new duplicate node, and insert the  duplice as the left child of the original node
 */
public class CreateADuplicate {
    private static void createDuplicateOfNodes(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        createDuplicateOfNodes(treeNode.getLeft());
        createDuplicateOfNodes(treeNode.getRight());
        TreeNode duplicateNode = new TreeNode(treeNode.getData());
        duplicateNode.setLeft(treeNode.getLeft());
        treeNode.setLeft(duplicateNode);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createBinarySearchTree();
        TreeNode.print(treeNode);
        createDuplicateOfNodes(treeNode);
        TreeNode.print(treeNode);
    }
}
