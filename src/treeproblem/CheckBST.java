package treeproblem;


public class CheckBST {
    private static int previousValue;

    public static boolean isBstWithSinglePointer(TreeNode treeNode) {
        previousValue = Integer.MIN_VALUE;
        return isBstUtilWithSinglePointer(treeNode);
    }

    private static boolean isBstUtilWithSinglePointer(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        if (isBstUtilWithSinglePointer(treeNode.getLeft())) {
            if (previousValue < treeNode.getData()) {
                previousValue = treeNode.getData();
                return isBstUtilWithSinglePointer(treeNode.getRight());
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createBinaryTree();
        TreeNode.print(treeNode);
        System.out.println("Height Of Tree " + TreeNode.heightOfTree(treeNode));
        System.out.println("Diameter Of Tree " + TreeNode.diameter(treeNode));
        System.out.println(CheckBST.isBstWithSinglePointer(treeNode));
    }
}
