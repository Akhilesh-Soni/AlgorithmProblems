import java.util.HashMap;
import java.util.Scanner;
import java.util.Scanner;


public class LinkedList {

	public static void main(String[] args) {
		Node<Integer> head = takeLinkedListInput();
		head = bubbleSort(head);
		//head = evenBeforeOdd(head);
		print(head);
	}

	public static int length(Node<Integer> head) {
		return (head == null) ? 0 : 1 + length(head.next);
	}

	public static Node<Integer> bubbleSort(Node<Integer> head) {
		int n = length(head);

		int i = 0;
		while (i < n) {

			Node<Integer> prev = null;
			Node<Integer> current = head;
			while (current.next != null) {
				if (current.data > current.next.data) {
					if (prev != null) {
						Node<Integer> next = current.next;
						Node<Integer> nextNext = current.next.next;
						prev.next = next;
						current.next = nextNext;
						next.next = current;
						prev = next;
					} else {
						Node<Integer> next = current.next;
						current.next = next.next;
						next.next = current;
						prev = next;
						head = prev;
					}
				} else {
					prev = current;
					current = current.next;
				}
			}
			i++;
		}
		return head;
	}

	public static Node<Integer> evenBeforeOdd(Node<Integer> head) {
		Node<Integer> evenHead = null;
		Node<Integer> evenTail = null;
		Node<Integer> oddHead = null;
		Node<Integer> oddTail = null;

		while (head != null) {
			if (head.data % 2 == 0) {
				if (evenHead == null) {
					evenHead = head;
					evenTail = head;
				} else {
					evenTail.next = head;
					evenTail = head;
				}
			} else {
				if (oddHead == null) {
					oddHead = head;
					oddTail = head;
				} else {
					oddTail.next = head;
					oddTail = head;
				}
			}
			head = head.next;
		}
		if (evenHead == null)
			return oddHead;

		if (oddTail != null)
			oddTail.next = null;

		evenTail.next = oddHead;
		return evenHead;

	}


	public static Node<Integer> insertAtN(Node<Integer> head, int position, int number) {

		Node<Integer> newNode = new Node<>(number);

		if (position == 0) {
			newNode.next = head;
			return newNode;
		}

		int i = 1;
		Node<Integer> temp = head;
		while (i < position) {
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}


	public static void print(Node<Integer> head) {
		while (head != null) {
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.println();
	}

	public static Node<Integer> takeLinkedListInput() {
		Node<Integer> head = null;
		Node<Integer> tail = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter next element");
		int nextElement = s.nextInt();

		while (nextElement != -1) {
			Node<Integer> nextNode = new Node<>(nextElement);

			if (head == null) {
				head = nextNode;
				tail = nextNode;
			} else {
				tail.next = nextNode;
				tail = nextNode;
			}
			System.out.println("Enter next element");

			nextElement = s.nextInt();
		}
		s.close();
		return head;
	}


}
