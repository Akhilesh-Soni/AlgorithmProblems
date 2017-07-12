package treeproblem;

import java.util.Scanner;

public class FindNextLargestInTree {
    private static int nextLargest = Integer.MAX_VALUE;

    //It will return the next largest value if present in tree
    // else will return 2147483647
    /*
    * The basic idea behind this algo is to search
    * all over the tree in pre order manner.
    * */
    private static int findNextLargestValue(TreeNode root, int number) {
        if (root == null) {
            return nextLargest;
        }
        if (number < root.getData() && nextLargest > root.getData()) {
            nextLargest = root.getData();
        }
        findNextLargestValue(root.getLeft(), number);
        findNextLargestValue(root.getRight(), number);
        return nextLargest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = TreeNode.createBinaryTree();
        while (true) {
            int number = sc.nextInt();
            System.out.println(findNextLargestValue(root, number));
            nextLargest = Integer.MAX_VALUE;
        }
    }
}
