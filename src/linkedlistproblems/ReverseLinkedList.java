package linkedlistproblems;

/**
 * Created by akhileshsoni on 20-04-2017.
 */
public class ReverseLinkedList {
    private static void reverseLinkedListWithoutChangingPointer(LinkedList linkedList) {
        int length = linkedList.size();
        int counter = 0;
        Node forward = linkedList.getHead().getNext();
        Node backward = null;
        while (counter != length / 2) {
            Node curr = forward.getNext();
            while (curr.getNext() != backward) {
                curr = curr.getNext();
            }
            backward = curr;
            int tempData = forward.getData();
            forward.setData(backward.getData());
            backward.setData(tempData);
            forward = forward.getNext();
            counter++;
        }
    }


    private static void reverseLinkedListChangingPointer(LinkedList linkedList) {
        Node last = reverseLinkedListChangingPointerUtil(linkedList.getHead(),
                linkedList.getHead().getNext());
        last.setNext(null);
    }

    private static Node reverseLinkedListChangingPointerUtil(Node head, Node node) {
        if (node.getNext() == null) {
            head.setNext(node);
            return node;
        }
        Node prev = reverseLinkedListChangingPointerUtil(head, node.getNext());
        prev.setNext(node);
        return node;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        linkedList.add(60);
        linkedList.printAllNodes();
        reverseLinkedListChangingPointer(linkedList);
        System.out.println();
        linkedList.printAllNodes();
    }
}
