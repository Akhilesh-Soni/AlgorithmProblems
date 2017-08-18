package linkedlistproblems;

/**
 * Created by akhileshsoni on 19-07-2017.
 */
public class MidPoint {

    private static void printMidPoint(LinkedList linkedList) {
        Node fast = linkedList.getHead().getNext();
        Node slow = linkedList.getHead().getNext();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        System.out.println("\n" + slow.getData());
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
        printMidPoint(linkedList);
    }
}
