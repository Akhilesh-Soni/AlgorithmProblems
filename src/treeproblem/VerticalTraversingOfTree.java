package treeproblem;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by akhileshsoni on 20-07-2017.
 */
public class VerticalTraversingOfTree {
    private static void printVerticalTraversing(TreeNode treeNode, Map<Integer, List<Integer>> map) {
        map = findVerticalTraversing(treeNode, map, 0);
        map.values().forEach(list -> {
            list.forEach(data -> System.out.print(data + "   "));
            System.out.println();
        });
    }

    private static Map<Integer, List<Integer>> findVerticalTraversing(TreeNode treeNode,
                                                                      Map<Integer, List<Integer>> map,
                                                                      int hd) {

        if (treeNode == null) return map;

        if (map.get(hd) != null) {
            List<Integer> list = map.get(hd);
            list.add(treeNode.getData());
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(treeNode.getData());
            map.put(hd, list);
        }
        findVerticalTraversing(treeNode.getLeft(), map, hd - 1);
        findVerticalTraversing(treeNode.getRight(), map, hd + 1);
        return map;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createBinaryTree();
        Map<Integer, List<Integer>> map = new HashMap<>();
        printVerticalTraversing(treeNode, map);
    }
}
