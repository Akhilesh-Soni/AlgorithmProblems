package treeproblem;

/**
 * Create a BST from given in order and post order.
 */
public class CreateBSTFromInOrderAndPostOrder {

    private static int postOrderIndex = 9;

    private static TreeNode createBST(int[] inOrder, int[] preOrder, int iS, int iE) {
        if (iS < iE) {
            int data = preOrder[postOrderIndex--];
            TreeNode treeNode = new TreeNode(data);
            int inOrderIndex = findIndex(inOrder, data);
            treeNode.setRight(createBST(inOrder, preOrder, inOrderIndex + 1, iE));
            treeNode.setLeft(createBST(inOrder, preOrder, iS, inOrderIndex));
            return treeNode;
        }
        return null;
    }

    private static int findIndex(int[] inOrder, int data) {
        int i;
        for (i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == data) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] inOrder = {30, 50, 55, 60, 70, 100, 130, 150, 170, 200};
        int[] postOrder = {30, 55, 70, 60, 50, 130, 200, 170, 150, 100};

        TreeNode treeNode = createBST(inOrder, postOrder, 0, inOrder.length);
        TreeNode.print(treeNode);
    }
}
