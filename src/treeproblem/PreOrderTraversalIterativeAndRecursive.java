package treeproblem;


import java.util.Stack;

public class PreOrderTraversalIterativeAndRecursive {
    private static void preOrderTraverseRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.getData() + "   ");
        preOrderTraverseRecursive(treeNode.getLeft());
        preOrderTraverseRecursive(treeNode.getRight());
    }

    private static void preOrderTraverseIterative(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            System.out.print(treeNode.getData() + "   ");
            if (treeNode.getRight() != null) {
                stack.push(treeNode.getRight());
            }
            if (treeNode.getLeft() != null) {
                stack.push(treeNode.getLeft());
            }
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createBinarySearchTree();
        preOrderTraverseRecursive(treeNode);
        System.out.println();
        preOrderTraverseIterative(treeNode);
    }
}
