package assignments;



public class Assignment3 {

	
	public static Node<Integer> selectionSort(Node<Integer> head){
		for(Node<Integer> current = head; current!=null; current= current.next){
			Node<Integer> min = current;
			for(Node<Integer> temp = current.next; temp!=null; temp = temp.next){
				if(min.data > temp.data){
					min = temp;
				}
			}
			//swaps the min node with the node in its actual position
			Node<Integer> temp = new Node<Integer>(current.data);
			current.data = min.data;
			min.data = temp.data;
		}
		return head;
	}
	
	public static void reverseWithRecursion(Node<Integer> head)
	{
		if(head==null) {
			return;
		}
		
		if(head.next == null){
			System.out.println(head.data);
			return;
		} 
		
		Integer data = head.data;
		reverseWithRecursion(head.next);
		System.out.println(data);
	}
		
	public static Node<Integer> reverseWithOutRecursion(Node<Integer> head)
	{
		
		if(head == null) {
			return null;
		}
		
		if(head.next == null){
			return head;
		}
		
		Node<Integer> tmp1,tmp2,newHead=null;
		
		while(head.next != null){
			tmp1 = head;
			head = head.next;
			if(newHead == null){
				newHead = tmp1;
				newHead.next = null;
			}else{
				tmp2 = newHead;
				newHead = tmp1;
				newHead.next = tmp2;
				
			}
		}
		
		//Swapping
		tmp1 = newHead;
		newHead = head;
		newHead.next =tmp1;
		
		return newHead;
	}
	
	public static Node<Integer> insertionSort(Node<Integer> head) {
		 
		if (head == null || head.next == null)
			return head;
 
		Node<Integer> newHead = new Node<Integer>(head.data);
		Node<Integer> temp = head.next;
 
		while (temp != null) {
 
			Node<Integer> innerPointer = newHead;
			Node<Integer> next = temp.next;
 
			if (temp.data <= newHead.data) {
				Node<Integer> oldHead = newHead;
				newHead = temp;
				newHead.next = oldHead;
			} else {
				while (innerPointer.next != null) {
 
					if (temp.data > innerPointer.data && temp.data<= innerPointer.next.data) {
						Node<Integer> oldNext = innerPointer.next;
						innerPointer.next = temp;
						temp.next = oldNext;
					}
 
					innerPointer = innerPointer.next;
				}
 
				if (innerPointer.next == null && temp.data > innerPointer.data) {
					innerPointer.next = temp;
					temp.next = null;
				}
			}
			temp = next;
		}
 
		return newHead;
	}
	
	public static Node<Integer> removeDuplicateFromSortedList(Node<Integer> head){
		
		if(head==null){
			return null;
		}
		
		Node<Integer> currentNode = head;
		Integer currentData = currentNode.data;
		while(head.next!=null){
			if(currentData == head.next.data){
				if(head.next.next!=null){
					head.next=head.next.next;
				}else{
					head.next=null;
				}
			}else{
				head = head.next;
				currentData = head.data;
			}
		}
		return currentNode;
	}
	
	public static Integer midofList(Node<Integer> head)
	{
		if(head == null){
			return null;
		}
			
		if(head.next== null){
			return head.data;
		}
		Node<Integer> oddPointer,evenPointer,tmp;
		tmp = head.next;
		oddPointer = head;
		evenPointer = head.next;
		while(true){
			
			if(tmp.next == null)
			{
				return oddPointer.data;
			}
			else if(tmp.next.next == null)
			{
				oddPointer = oddPointer.next;
				return oddPointer.data;
			}
			else{
				tmp = tmp.next.next;
				oddPointer = oddPointer.next;
				evenPointer = evenPointer.next.next;
			}
			
		}
		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Node<Integer> head = null;
			LinkedList ll = new LinkedList();
			head = ll.takeLinkedListInput();
			ll.print(head);
//			head= selectionSort(head);
//			head =  insertionSort(head);
//			System.out.print("\nThe Linked List after sorting:- ");
//			ll.print(head);
//			head = removeDuplicateFromSortedList(head);
//			System.out.print("\nAfter Removing duplicates :- ");
//			ll.print(head);
//			int mid = midofList(head);
//			System.out.print("\nThe mid of the Linked List is:- "+mid);
			
	}

}