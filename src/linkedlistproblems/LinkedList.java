package linkedlistproblems;

/**
 * Created by akhileshsoni on 19-04-2017.
 */
public class LinkedList {
    private Node head;

    public LinkedList() {
        head = new Node(0);
    }

    public Node getHead() {
        return this.head;
    }

    public boolean add(int data) {
        Node node = new Node(data);
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
        return true;
    }

    public void printAllNodes() {
        Node temp = head.getNext();
        if (temp == null) {
            return;
        }
        do {
            System.out.print(temp.getData());
            System.out.print("->");
            temp = temp.getNext();
        } while (temp != null);
        System.out.print("null"+"\n");
    }

    public boolean insertAtFirst(int data) {
        Node node = new Node(data);
        Node temp = head.getNext();
        head.setNext(node);
        node.setNext(temp);
        return true;
    }

    public boolean insertAtLast(int data) {
        Node node = new Node(data);
        Node temp = head.getNext();
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
        return true;
    }

    public boolean insertAtPosition(int position, int data) {
        Node node = new Node(data);
        Node temp = head.getNext();

        if (head == null) {
            Node head = new Node(data);
            head.setNext(head);
            return true;
        }
        if (position == 0) {
            node.setNext(temp);
            head.setNext(node);
            return true;
        }
        int count = 0;
        while (temp.getNext() != null && count != position - 1) {
            temp = temp.getNext();
            count++;
        }
        Node next = temp.getNext();
        temp.setNext(node);
        node.setNext(next);
        return true;
    }

    public boolean deleteNode(int data) {
        Node temp = head.getNext();
        Node previous = head;
        while (temp != null && temp.getData() != data) {
            previous = temp;
            temp = temp.getNext();
        }
        if (temp == null) {
            return false;
        }
        previous.setNext(temp.getNext());
        return true;
    }

    public int size() {
        Node temp = this.head.getNext();
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public boolean findNode(int data) {
        Node temp = head.getNext();
        while (temp != null && temp.getData() != data) {
            temp = temp.getNext();
        }
        return temp != null;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        linkedList.printAllNodes();
        System.out.println("\nSize " + linkedList.size());
        linkedList.insertAtFirst(5);
        System.out.println();
        linkedList.printAllNodes();
        linkedList.insertAtLast(60);
        System.out.println();
        linkedList.printAllNodes();
        linkedList.insertAtPosition(7, 70);
        System.out.println();
        linkedList.printAllNodes();
        linkedList.deleteNode(70);
        System.out.println();
        linkedList.printAllNodes();
        System.out.println("\n" + linkedList.findNode(5));
    }
}
