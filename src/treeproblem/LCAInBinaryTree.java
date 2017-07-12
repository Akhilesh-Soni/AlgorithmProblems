package treeproblem;

/**
 * Find LCA(Lowest Common Ancestor) of two elements in a Binary Tree.
 *  Read about  LCA if you are having doubts about the definition. 
 */
public class LCAInBinaryTree {
    private static TreeNode findLCAOfTwoNodes(TreeNode treeNode, int key1, int key2) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.getData() == key1 || treeNode.getData() == key2) {
            return treeNode;
        }
        TreeNode leftLCA = findLCAOfTwoNodes(treeNode.getLeft(), key1, key2);
        TreeNode rightLCA = findLCAOfTwoNodes(treeNode.getRight(), key1, key2);
        if (leftLCA != null && rightLCA != null) {
            return treeNode;
        }
        if (leftLCA != null) {
            return leftLCA;
        } else {
            return rightLCA;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createBinaryTree();
        TreeNode lca = findLCAOfTwoNodes(treeNode, 110, 85);
        System.out.println(lca != null ? lca.getData() : -1);
    }
}
