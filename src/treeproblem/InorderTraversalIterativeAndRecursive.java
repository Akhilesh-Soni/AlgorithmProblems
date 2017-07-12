package treeproblem;


import java.util.Stack;

public class InorderTraversalIterativeAndRecursive {
    private static void inorderTraverseIterative(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null) {
            stack.push(treeNode);
            treeNode = treeNode.getLeft();
        }
        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            System.out.print(treeNode.getData() + "   ");
            if (treeNode.getRight() != null) {
                treeNode = treeNode.getRight();
                while (treeNode != null) {
                    stack.push(treeNode);
                    treeNode = treeNode.getLeft();
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createBinarySearchTree();
        inorderTraverseIterative(treeNode);
        System.out.println();
        inorderTraverseRecursive(treeNode);
    }

    private static void inorderTraverseRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inorderTraverseIterative(treeNode.getLeft());
        System.out.print(treeNode.getData() + "   ");
        inorderTraverseIterative(treeNode.getRight());
    }
}
