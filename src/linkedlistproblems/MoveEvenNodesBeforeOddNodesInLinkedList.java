package linkedlistproblems;

/**
 * Created by akhileshsoni on 19-04-2017.
 */
public class MoveEvenNodesBeforeOddNodesInLinkedList {


    private static void moveEvenNodesBeforeOdd(LinkedList linkedList) {
        Node odd = linkedList.getHead().getNext();
        odd = increaseOdd(odd);
        Node current = odd;
        while (current != null) {
            if (current.getData() % 2 == 0) {
                swapData(odd, current);
                odd = increaseOdd(odd);
            }
            current = current.getNext();
        }
    }

    private static Node increaseOdd(Node odd) {
        while (odd != null && odd.getData() % 2 == 0) {
            odd = odd.getNext();
        }
        return odd;
    }

    private static void swapData(Node oddData, Node currentData) {
        int temp = currentData.getData();
        currentData.setData(oddData.getData());
        oddData.setData(temp);
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.printAllNodes();
        moveEvenNodesBeforeOdd(linkedList);
        System.out.println();
        linkedList.printAllNodes();
    }
}
