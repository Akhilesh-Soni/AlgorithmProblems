package treeproblem;

/**
 * Create a BST from given in order and pre order.
 */
public class CreateBSTFromInOrderAndPreOrder {

    private static int preOrderIndex = 0;

    private static TreeNode createBST(int[] inOrder, int[] preOrder, int iS, int iE) {
        if (iS < iE) {
            int data = preOrder[preOrderIndex++];
            TreeNode treeNode = new TreeNode(data);
            int inOrderIndex = findIndex(inOrder, data);
            treeNode.setLeft(createBST(inOrder, preOrder, iS, inOrderIndex));
            treeNode.setRight(createBST(inOrder, preOrder, inOrderIndex + 1, iE));
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
        int[] preOrder = {100, 50, 30, 60, 55, 70, 150, 130, 170, 200};

        TreeNode treeNode = createBST(inOrder, preOrder, 0, inOrder.length);
        TreeNode.print(treeNode);
    }
}
