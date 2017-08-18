package linkedlistproblems;


public class SumOfLinkedList {
    private static LinkedList calculateSum(LinkedList linkedList1, LinkedList linkedList2) {
        int size1 = linkedList1.size();
        int size2 = linkedList2.size();
        if (size1 == size2) {
            int carry = calculateSumUtil(linkedList1.getHead().getNext(), linkedList2.getHead().getNext());
            if (carry > 0) {
                linkedList1.insertAtFirst(carry);
            }
            return linkedList1;
        }
        if (size1 > size2) {
            int diff = size1 - size2;
            Node temp = linkedList1.getHead().getNext();
            while (diff != 0) {
                temp = temp.getNext();
                diff--;
            }
            int carry = calculateSumUtil(temp, linkedList2.getHead().getNext());
            carry = propagateCarry(linkedList1.getHead().getNext(), temp, carry);
            linkedList1.insertAtFirst(carry);
            return linkedList1;
        } else {
            int diff = size2 - size1;
            Node temp = linkedList2.getHead().getNext();
            while (diff != 0) {
                temp = temp.getNext();
                diff--;
            }
            int carry = calculateSumUtil(linkedList1.getHead().getNext(), temp);
            carry = propagateCarry(linkedList2.getHead().getNext(), temp, carry);
            linkedList2.insertAtFirst(carry);
            return linkedList2;
        }
    }

    private static int propagateCarry(Node node, Node temp, int carry) {
        if (node == temp) {
            return carry;
        }
        carry = propagateCarry(node.getNext(), temp, carry);
        int sum = node.getData() + carry;
        carry = sum / 10;
        sum %= 10;
        node.setData(sum);
        return carry;
    }

    private static int calculateSumUtil(Node t1, Node t2) {
        if (t1 == null || t2 == null) {
            return 0;
        }
        int carry = calculateSumUtil(t1.getNext(), t2.getNext());
        int sum = t1.getData() + t2.getData() + carry;
        carry = sum / 10;
        sum %= 10;
        t1.setData(sum);
        return carry;
    }

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(9);
        linkedList1.add(8);
        linkedList1.add(7);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(7);
        linkedList2.add(9);

        LinkedList linkedList = calculateSum(linkedList1, linkedList2);
        linkedList.printAllNodes();
    }
}
