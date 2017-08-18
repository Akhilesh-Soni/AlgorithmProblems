package treeproblem;

import java.util.ArrayList;

/**
 * Given a binary tree and a number, return true if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given number.
 * Return false if no such path can be found.
 */
public class RootToLeafPathSum {
    private static boolean checkIfPathExist(TreeNode treeNode, int key, ArrayList<TreeNode> list) {
        if (treeNode == null) {
            return false;
        }
        if (treeNode.getData() == key) {
            if (treeNode.getLeft() == null && treeNode.getRight() == null) {
                list.add(treeNode);
                return true;
            } else {
                return false;
            }
        }
        list.add(treeNode);
        boolean leftFlag = checkIfPathExist(treeNode.getLeft(), key - treeNode.getData(), list);
        if (!leftFlag) {
            boolean rightFlag = checkIfPathExist(treeNode.getRight(), key - treeNode.getData(), list);
            if (!rightFlag) {
                list.remove(treeNode);
            } else {
                return true;
            }
        } else {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createBinaryTree();
        ArrayList<TreeNode> list = new ArrayList<>();
        boolean flag = checkIfPathExist(treeNode, 23, list);
        if (flag) {
            list.forEach(treeNode1 -> System.out.print(treeNode1.getData() + "-->"));
        }
    }
}
