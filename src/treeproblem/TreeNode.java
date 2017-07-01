package treeproblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by akhileshsoni on 11-06-2017.
 */
public class TreeNode<T> {
    private T data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static void print(TreeNode<Integer> root) {
        if (root == null)
            return;
        String toBeprinted = root.data + ":";
        if (root.left != null)
            toBeprinted += root.left.data + ",";

        if (root.right != null)
            toBeprinted += root.right.data + ",";
        System.out.println(toBeprinted);

        print(root.left);
        print(root.right);
    }

    public static TreeNode<Integer> takeInputLevelWise() {
        System.out.println("Enter root data");
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);

        // Nodes for which I haven't taken children info yet
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.remove();
            } catch (Exception e) {
                System.out.println("Cant come here");
                return null;
            }
            System.out.println("Enter left child for " + currentNode.data);
            int leftData = s.nextInt();
            if (leftData != -1) {
                TreeNode<Integer> left = new TreeNode<>(leftData);
                pendingNodes.add(left);
                currentNode.left = left;
            }

            System.out.println("Enter right child for " + currentNode.data);
            int rightData = s.nextInt();
            if (rightData != -1) {
                TreeNode<Integer> right = new TreeNode<Integer>(rightData);
                pendingNodes.add(right);
                currentNode.right = right;
            }
        }
        return root;
    }

}
