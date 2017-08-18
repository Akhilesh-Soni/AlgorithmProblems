package linkedlistproblems;

/**
 * Created by akhileshsoni on 19-07-2017.
 */
public class SelectionSortOnLinkedList {

    private static void selectionSortRecursive(LinkedList linkedList) {
        selectionSortRecursiveUtil(linkedList.getHead().getNext());
    }

    private static void selectionSortRecursiveUtil(Node outerNode) {
        if (outerNode.getNext() == null) {
            return;
        }

        Node minNode = outerNode;
        Node curr = outerNode.getNext();
        while (curr != null) {
            if (curr.getData() < minNode.getData()) {
                minNode = curr;
            }
            curr = curr.getNext();
        }
        int tempData = minNode.getData();
        minNode.setData(outerNode.getData());
        outerNode.setData(tempData);
        selectionSortRecursiveUtil(outerNode.getNext());
    }

    private static void selectionSortIterative(LinkedList linkedList) {
        Node outerNode = linkedList.getHead().getNext();
        while (outerNode.getNext() != null) {
            Node minNode = outerNode;
            Node innerNode = outerNode.getNext();
            while (innerNode != null) {
                if (innerNode.getData() < minNode.getData()) {
                    minNode = innerNode;
                }
                innerNode = innerNode.getNext();
            }
            int tempData = minNode.getData();
            minNode.setData(outerNode.getData());
            outerNode.setData(tempData);
            outerNode = outerNode.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.add(20);
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(45);
        linkedList.add(25);
        linkedList.add(35);
        linkedList.printAllNodes();
        selectionSortRecursive(linkedList);
        System.out.println();
        linkedList.printAllNodes();
    }
}
