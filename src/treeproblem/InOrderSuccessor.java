package treeproblem;

import java.util.Scanner;

/**
 * Find Inorder successor in BST;
 */
public class InOrderSuccessor {

    private static TreeNode findInOrderSuccessor(TreeNode treeNode, int key) {
        return findInOrderSuccessorUtil(treeNode, key, null);
    }

    private static TreeNode findInOrderSuccessorUtil(TreeNode treeNode, int key, TreeNode successor) {

        if (treeNode == null) {
            return null;
        }
        if (key == treeNode.getData()) {
            if (treeNode.getRight() != null) {
                return getNodeWithMinimumKey(treeNode.getRight());
            } else if (successor != null && successor.getData() > treeNode.getData()) {
                return successor;
            }
        } else if (key < treeNode.getData()) {
            return findInOrderSuccessorUtil(treeNode.getLeft(), key, treeNode);
        } else {
            return findInOrderSuccessorUtil(treeNode.getRight(), key, successor);
        }
        return successor;
    }

    private static TreeNode getNodeWithMinimumKey(TreeNode treeNode) {
        if (treeNode.getLeft() == null && treeNode.getRight() == null) {
            return treeNode;
        } else if (treeNode.getLeft() != null) {
            return getNodeWithMinimumKey(treeNode.getLeft());
        } else {
            return getNodeWithMinimumKey(treeNode.getRight());
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode treeNode = TreeNode.createBinarySearchTree();
        System.out.println("Enter the key :-");
        int key = sc.nextInt();
        TreeNode successor = findInOrderSuccessor(treeNode, key);
        System.out.println(successor != null ? successor.getData() : "Successor Not Found.");
    }
}
