package treeproblem;

/**
 * Created by akhileshsoni on 11-06-2017.
 */
public class MergeTwoBinaryTrees {

    private static TreeNode mergeTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode newNode = new TreeNode(t1.getData() + t2.getData());
        newNode.setLeft(mergeTree(t1.getLeft(), t2.getLeft()));
        newNode.setRight(mergeTree(t1.getRight(), t2.getRight()));
        return newNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeNode.createBinaryTree();
        TreeNode.print(treeNode1);
        TreeNode treeNode2 = TreeNode.createBinaryTree();
        TreeNode.print(treeNode2);
        System.out.println(1);
        TreeNode.print(mergeTree(treeNode1, treeNode2));

    }

}
