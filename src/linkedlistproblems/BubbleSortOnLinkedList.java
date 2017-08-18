package linkedlistproblems;

/**
 * Created by akhileshsoni on 19-04-2017.
 */
public class BubbleSortOnLinkedList {

    private static void bubbleSortRecursive(LinkedList linkedList) {
        bubbleSortRecursiveUtil(linkedList.getHead().getNext(), null);
    }

    private static void bubbleSortRecursiveUtil(Node curr, Node last) {
        if (curr == last) {
            return;
        }
        Node temp = curr;
        while (temp.getNext() != last) {
            if (temp.getData() > temp.getNext().getData()) {
                int data = temp.getData();
                temp.setData(temp.getNext().getData());
                temp.getNext().setData(data);
            }
            temp = temp.getNext();
        }
        last = temp;
        bubbleSortRecursiveUtil(curr, last);
    }

    private static void bubbleSortIterative(LinkedList linkedList) {
        boolean swap;
        Node last = null;
        Node curr = linkedList.getHead().getNext();
        do {
            swap = false;
            while (curr.getNext() != last) {
                if (curr.getData() > curr.getNext().getData()) {
                    swap = true;
                    int data = curr.getData();
                    curr.setData(curr.getNext().getData());
                    curr.getNext().setData(data);
                }
                curr = curr.getNext();
            }
            last = curr;
            curr = linkedList.getHead().getNext();
        } while (swap);
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.add(10);
        linkedList.add(5);
        linkedList.add(35);
        linkedList.add(25);
        linkedList.printAllNodes();
        bubbleSortRecursive(linkedList);
        System.out.println();
        linkedList.printAllNodes();
    }
}
