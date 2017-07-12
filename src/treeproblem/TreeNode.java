package treeproblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by akhileshsoni on 11-06-2017.
 */
public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
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

    //It will print the tree in level wise ordering
    public static void print(TreeNode root) {
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

    //It will create a binary tree
    public static TreeNode createBinaryTree() {
        System.out.println("Enter root data");
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();
        TreeNode root = new TreeNode(rootData);

        // Nodes for which I haven't taken children info yet
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode currentNode;
            try {
                currentNode = pendingNodes.remove();
            } catch (Exception e) {
                System.out.println("Cant come here");
                return null;
            }
            System.out.println("Enter left child for (Enter -1 to exit)" + currentNode.data);
            int leftData = s.nextInt();
            if (leftData != -1) {
                TreeNode left = new TreeNode(leftData);
                pendingNodes.add(left);
                currentNode.left = left;
            }

            System.out.println("Enter right child for (Enter -1 to exit)" + currentNode.data);
            int rightData = s.nextInt();
            if (rightData != -1) {
                TreeNode right = new TreeNode(rightData);
                pendingNodes.add(right);
                currentNode.right = right;
            }
        }
        return root;
    }

    //It will create a BST
    public static TreeNode createBinarySearchTree() {
        System.out.println("Enter the root data :");
        Scanner scanner = new Scanner(System.in);
        TreeNode treeNode = new TreeNode(scanner.nextInt());
        System.out.println("Enter the next data(Enter -1 to exit):");
        int data = scanner.nextInt();
        while (data != -1) {
            TreeNode childNode = new TreeNode(data);
            createBSTIterative(treeNode, childNode);
            System.out.println("Enter the next data(Enter -1 to exit):");
            data = scanner.nextInt();
        }
        return treeNode;
    }

    private static void createBSTIterative(TreeNode treeNode, TreeNode childNode) {
        TreeNode temp = treeNode;
        while (temp != null) {
            if (childNode.getData() < temp.getData()) {
                if (temp.getLeft() != null) {
                    temp = temp.getLeft();
                } else {
                    temp.setLeft(childNode);
                    break;
                }
            } else {
                if (temp.getRight() != null) {
                    temp = temp.getRight();
                } else {
                    temp.setRight(childNode);
                    break;
                }
            }

        }
    }

    private static void createBinarySearchTreeRecursiveUtil(TreeNode treeNode, TreeNode childNode) {
        if (childNode.getData() < treeNode.getData()) {
            if (treeNode.getLeft() != null) {
                createBinarySearchTreeRecursiveUtil(treeNode.getLeft(), childNode);
            } else {
                treeNode.setLeft(childNode);
            }
        } else {
            if (treeNode.getRight() != null) {
                createBinarySearchTreeRecursiveUtil(treeNode.getRight(), childNode);
            } else {
                treeNode.setRight(childNode);
            }
        }
    }

    //It will print the heightOfTree
    public static int heightOfTree(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(heightOfTree(treeNode.getLeft()),
                heightOfTree(treeNode.getRight())) + 1;
    }

    //It will print the diameter of the tree.
    public static int diameter(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int lHeight = heightOfTree(treeNode.getLeft());
        int rHeight = heightOfTree(treeNode.getRight());

        int lDiameter = diameter(treeNode.getLeft());
        int rDiameter = diameter(treeNode.getRight());

        return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
    }
}
