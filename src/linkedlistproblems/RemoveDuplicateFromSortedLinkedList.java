package linkedlistproblems;

/**
 * Created by akhileshsoni on 19-07-2017.
 */
public class RemoveDuplicateFromSortedLinkedList {
    private static void removeDuplicates(LinkedList linkedList) {
        Node curr = linkedList.getHead().getNext();
        while (curr.getNext() != null) {
            while (curr.getData() == curr.getNext().getData()) {
                curr.setNext(curr.getNext().getNext());
            }
            curr = curr.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(4);
        linkedList.add(4);
        linkedList.add(8);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.printAllNodes();
        System.out.println();
        removeDuplicates(linkedList);
        linkedList.printAllNodes();
    }
}
