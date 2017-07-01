package linkedlistproblems;

/**
 * Created by akhileshsoni on 20-04-2017.
 */
public class ReverseLinkedList {
    private static void reverseLinkedList(LinkedList linkedList) {

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(50);
        linkedList.add(30);
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(60);
        linkedList.add(40);
        linkedList.add(70);
        linkedList.printAllNodes();
        reverseLinkedList(linkedList);
    }
}
