package treeproblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary tree, write code to create a separate linked list for each level. 
 * You  should return an array of linked lists. 
 */
public class CreateASeparateLinkedListForEachLevel {

    private static ArrayList<LinkedList<TreeNode>> createLinkedListForEachLevel(TreeNode treeNode) {
        ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            ArrayList<TreeNode> tempQueue = new ArrayList<>();

            for (TreeNode tmp : queue) {
                tempQueue.add(tmp);
            }

            queue.removeAll(queue);
            LinkedList<TreeNode> list = new LinkedList<>();

            for (TreeNode n : tempQueue) {
                if (n.getLeft() != null) {
                    queue.add(n.getLeft());
                }
                if (n.getRight() != null) {
                    queue.add(n.getRight());
                }

                list.add(n);
            }
            arrayList.add(list);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createBinaryTree();
        TreeNode.print(treeNode);
        ArrayList<LinkedList<TreeNode>> arrayList = createLinkedListForEachLevel(treeNode);
        System.out.println();
        arrayList.forEach(treeNodes -> {
                    treeNodes.forEach(treeNode1 -> System.out.print(treeNode1.getData() + " "));
                    System.out.println();
                }

        );
    }
}
