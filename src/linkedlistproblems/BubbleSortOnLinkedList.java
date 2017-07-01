package linkedlistproblems;

/**
 * Created by akhileshsoni on 19-04-2017.
 */
public class BubbleSortOnLinkedList {

    private static void bubbleSort(LinkedList linkedList) {
        int length = 1;
        Node counter = linkedList.getHead().getNext();
        while (counter.getNext() != null) {
            counter = counter.getNext();
            length++;
        }
        Node k = null;
        for (int i = 0; i < length; i++) {
            Node j = linkedList.getHead().getNext();
            while (j.getNext() != k) {
                Node jNext = j.getNext();
                if (j.getData() > jNext.getData()) {
                    int temp = j.getData();
                    j.setData(jNext.getData());
                    jNext.setData(temp);
                }
                j = jNext;
            }
            k = j;
        }
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
        bubbleSort(linkedList);
        System.out.println();
        linkedList.printAllNodes();
    }
}
