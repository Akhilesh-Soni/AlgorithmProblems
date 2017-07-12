package treeproblem;


import java.util.Stack;

public class PostOrderTraversalIterativeAndRecursive {
    private static void postOrderTraversalRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrderTraversalRecursive(treeNode.getLeft());
        postOrderTraversalRecursive(treeNode.getRight());
        System.out.print(treeNode.getData() + "   ");
    }

    private static void postOrderTraversalIterative(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = treeNode;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            } else {
                TreeNode temp = stack.peek().getRight();
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.getData() + "   ");
                    /*If the node is itself a right child of some node than print the parent node
                    * as well, because the right child has been processed.*/
                    while (!stack.isEmpty() && temp == stack.peek().getRight()) {
                        temp = stack.pop();
                        System.out.print(temp.getData() + "   ");
                    }
                } else {
                    curr = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createBinarySearchTree();
        postOrderTraversalRecursive(treeNode);
        System.out.println();
        postOrderTraversalIterative(treeNode);
    }
}
