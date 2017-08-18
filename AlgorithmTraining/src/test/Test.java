package test;

public class Test {
	
	

	
	public static String reverseString(String input, char code[][]) {
		
		if(input.length() == 0){
			return "";
		}

		char temp = input.charAt(0);
		for (int i = 0; i < code.length; i++) {
			char[] cs = code[i];
			for (int j = 0; j < cs.length; j++) {
				if(temp == code[i][j]){
					return  "Press "+i+","+(j+1)+" times\n"+reverseString(input.substring(1), code);
				}
			}
		}
		return null;
	}
	
	public static Node<Integer> threeRarrange(Node<Integer>head) {
		
		
		Node<Integer> aHead = null;
		Node<Integer> aTail = null;
		Node<Integer> bHead = null;
		Node<Integer> bTail = null;
		Node<Integer> cHead = null;
		Node<Integer> cTail = null;
	
		while (head!=null) {
			if (head.data % 3 == 0) {
				if (aHead == null) {
					aHead = head;
					aTail = head;
				} else {
					aTail.next = head;
					aTail = head;
				}
			} 
			else if (head.data%3 == 1) {
				if(bHead == null){
					bHead = head;
					bTail = head;
				}else {
					bTail.next = head;
					bTail = head;
				}
			}
			else {
				if (cHead == null) {
					cHead = head;
					cTail = head;
				}else {
					cTail.next = head;
					cTail = head;
				}
			}
			head = head.next;
		}
		if(cHead!=null){
			cTail.next = null;
		}
		
		if(aHead == null){
			if(bHead == null){
				return cHead;
			}else {
				bTail.next = cHead;
				return bHead;
			}
		}
		if(aHead !=null){
			if(bHead == null){
				aTail.next = cHead;
				return aHead;
			}else {
				aTail.next = bHead;
				bTail.next = cHead;
				return aHead;
			}
		}
		return aHead;
	}
	
	public static void printFirstNodeatlevel(BinaryTreeNode<Integer>root) throws Exception {
			  
		if(root == null){
			return;
		}
		QueueUsingLL<BinaryTreeNode<Integer>>queue = new QueueUsingLL<>();
		queue.enqueue(root);
		System.out.print(root.data+"	");
		
	}
	
	public static int findCombination(int a[], int b[]) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			count += findCombination(a, b,i,0); 
		}
		return count;
	}
	
	
	private static int findCombination(int[] a, int[] b, int indexofa, int indexofb) {
		// TODO Auto-generated method stub
		
		if(indexofa == a.length || indexofb == b.length)
		{
			return 1;
		}
		if(a[indexofa] < b[indexofb]){
			return 1+findCombination(b, a, indexofb+1, indexofa+1);
		}
		else {
			return findCombination(a, b, indexofa, indexofb+1);
		}
	}

	public static void  main(String []args) throws Exception {
		
		
		/*char code[][] = { { ' ' }, { ' ' }, { 'a', 'b', 'c' },
				{ 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
				{ 'w', 'x', 'y', 'z' }, };

		System.out.print(reverseString("fdasf", code));*/
		
		/*Linked List Question,
		LinkedList ll = new LinkedList();
		Node<Integer> head = ll.takeLinkedListInput();
		ll.print(head);
		head = threeRarrange(head);
		System.out.print("\n");
		ll.print(head);*/
		
	/*	Print Left Most Node in tree*/
		BinaryTreeNode<Integer> root = null;
		root = BinaryTreeUse.takeInputLevelWise();
		BinaryTreeUse.print(root);
		printFirstNodeatlevel(root);
		
		
		/*int a[] =  {1,3,5,7,9};
		int b[] = {2,4,6,7};
		System.out.print(findCombination(a, b));*/
		
	}
}
