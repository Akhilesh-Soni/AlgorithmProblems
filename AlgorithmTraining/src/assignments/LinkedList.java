package assignments;
import java.util.HashMap;
import java.util.Scanner;

public class LinkedList {


	public Node <Integer> takeLinkedListInput() {

		Node<Integer> head = null;
		Node<Integer> tail = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter next element");
		int nextElement = sc.nextInt();

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

			nextElement = sc.nextInt();
		}
		return head;
	}

	public static int length(Node<Integer> head) {
		return (head == null) ? 0 : 1 + length(head.next);
	}

	
	public void print(Node<Integer> head) {
		while (head != null) {
			System.out.print(head.data + "-->");
			head = head.next;
		}
	}
}
