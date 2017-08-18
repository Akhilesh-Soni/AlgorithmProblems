package linkedlistproblems;

/**
 * Created by akhileshsoni on 29-07-2017.
 */
public class MergeTwoSortedLinkedList {
    private static LinkedList mergeTheLists(LinkedList linkedList1, LinkedList linkedList2) {

        Node node = mergeTheListsUtil(linkedList1.getHead().getNext(), linkedList2.getHead().getNext());
        linkedList1.getHead().setNext(node);
        return linkedList1;
    }

    private static Node mergeTheListsUtil(Node t1, Node t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Node temp = null;
        if (t1.getData() <= t2.getData()) {
            temp = t1;
            temp.setNext(mergeTheListsUtil(t1.getNext(), t2));
        } else {
            temp = t2;
            temp.setNext(mergeTheListsUtil(t1, t2.getNext()));
        }
        return temp;
    }

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(10);
        linkedList1.add(20);
        linkedList1.add(30);
        linkedList1.add(40);
        linkedList1.add(50);
        linkedList1.printAllNodes();

        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(5);
        linkedList2.add(15);
        linkedList2.add(25);
        linkedList2.add(35);
        linkedList2.printAllNodes();
        linkedList1 = mergeTheLists(linkedList1, linkedList2);
        linkedList1.printAllNodes();
    }
}
