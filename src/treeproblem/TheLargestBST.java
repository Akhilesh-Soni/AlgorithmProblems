package treeproblem;

/**
 * Given a Binary tree find the largest BST subtree.  
 */
public class TheLargestBST {
    private static TreeNode findTheLargestBST(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (CheckBST.isBstWithSinglePointer(treeNode)) {
            return treeNode;
        }
        TreeNode leftSubBST = findTheLargestBST(treeNode.getLeft());
        TreeNode rightSubBST = findTheLargestBST(treeNode.getRight());

        if (leftSubBST != null && rightSubBST != null) {
            return TreeNode.heightOfTree(leftSubBST) > TreeNode.heightOfTree(rightSubBST) ?
                    leftSubBST : rightSubBST;
        }
        if (leftSubBST == null) {
            return rightSubBST;
        } else {
            return leftSubBST;
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createBinaryTree();
        TreeNode largestBstRoot = findTheLargestBST(treeNode);
        TreeNode.print(largestBstRoot);
    }

}
