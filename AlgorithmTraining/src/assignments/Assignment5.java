package assignments;

import java.util.Scanner;
import java.util.TreeSet;

public class Assignment5 {

	// store head and tail of linkedList
	public static class HeadandTail {
		Node<Integer> head;
		Node<Integer> tail;
	}
	
	public static BinarySearchTree<Integer> insertIntoBST(
			BinarySearchTree<Integer> root, BinarySearchTree<Integer> newNode) {

		if (root == null) {
			root = newNode;
		} else if (newNode.data <= root.data) {
			if (root.left == null) {
				root.left = newNode;
			} else {
				root.left = insertIntoBST(root.left, newNode);
			}
		} else {
			if (root.right == null) {
				root.right = newNode;
			} else {
				root.right = insertIntoBST(root.right, newNode);
			}
		}

		return root;
	}

	public static void printBST(BinarySearchTree<Integer> root) {
		if (root == null)
			return;
		String toBeprinted = root.data + ":";
		if (root.left != null)
			toBeprinted += root.left.data + ",";
		else {
			toBeprinted += "null,";
		}
		if (root.right != null)
			toBeprinted += root.right.data;
		else {
			toBeprinted += " null";
		}
		System.out.println(toBeprinted);

		printBST(root.left);
		printBST(root.right);

	}

	
	//Convert the BST into Sorted Linked List
	public static HeadandTail convertBSTtoSortedLinkedList(
			BinarySearchTree<Integer> root) {
		if (root == null) {
			return null;
		}
		HeadandTail leftSubtree = new HeadandTail();
		HeadandTail rightSubtree = new HeadandTail();

		if (root.left != null) {
			leftSubtree = convertBSTtoSortedLinkedList(root.left);
			leftSubtree.tail.next = new Node<Integer>(root.data);
			leftSubtree.tail = leftSubtree.tail.next;
		}else {
			leftSubtree.head = new Node<Integer>(root.data);
			leftSubtree.tail = leftSubtree.head;
		}
		if (root.right != null) {
			rightSubtree = convertBSTtoSortedLinkedList(root.right);
			leftSubtree.tail.next = rightSubtree.head;
			leftSubtree.tail = rightSubtree.tail;
		}
		return leftSubtree;
	}
	
	
	//convert the sorted array to BST
	public static BinarySearchTree<Integer> convertSortedArraytoBST(int array[],int start,int end) {
		if(start>end){
			return null;
		}
		
		int mid = ((start+end)/2);
		BinarySearchTree<Integer> root = new BinarySearchTree<Integer>(array[mid]);
	
		root.left = convertSortedArraytoBST(array,start,mid-1);
		
		root.right = convertSortedArraytoBST(array, mid+1, end);
		return root;
	}
	
	
	
	public static BinarySearchTree<Integer> findLCA(
			BinarySearchTree<Integer> root, int a, int b) {
		if (root == null) {
			return null;
		}
		if (root.data == a || root.data == b) {
			return root;
		}
		if (a < root.data && b > root.data || a > root.data && b < root.data) {
			return root;
		}
		if (a < root.data && b < root.data) {
			root = findLCA(root.left, a, b);
		}
		if (a > root.data && b > root.data) {
			root = findLCA(root.right, a, b);
		}
		return root;
	}

	public static void printNodeInRange(BinarySearchTree<Integer> root, int r1,
			int r2) {
		if (root == null) {
			return;
		} else if (r1 < root.data && root.data < r2) {
			System.out.print(root.data + "\t");
		}
		printNodeInRange(root.left, r1, r2);
		printNodeInRange(root.right, r1, r2);
	}

	public static int findPair(BinarySearchTree<Integer> root, int sum) {
		if (root == null) {
			return 0;
		}
		int sumLeft = 0, sumRight = 0;
		sumLeft = findPair(root.left, sum);
		sumRight = findPair(root.right, sum);
		if (root.data + sumLeft == sum) {
			System.out.print("\nThe pair which sum is equal to " + sum
					+ " is:- " + root.data + ", " + sumLeft);
		}
		if (root.data + sumRight == sum) {
			System.out.print("\nThe pair which sum is equal to " + sum
					+ " is:- " + root.data + ", " + sumRight);
		}
		if (sumLeft + sumRight == sum) {
			System.out.print("\nThe pair which sum is equal to " + sum
					+ " is:- " + sumLeft + ", " + sumRight);
		}
		return root.data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> root = null;
/*		BinarySearchTree<Integer> newNode = null;
		int number;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Node Value:- ");
		number = sc.nextInt();
		while (number != -1) {
			newNode = new BinarySearchTree<Integer>(number);
			root = insertIntoBST(root, newNode);
			System.out.print("\nEnter the Next Node:- ");
			number = sc.nextInt();
		}*/
		
		int array[] = {30,50,55,60,65,70,100,120,130,140,150,200,300,400};
		root = convertSortedArraytoBST(array, 0, array.length-1);
		printBST(root);
		
		/*System.out.print("\n The LCA of 50 and 70 is :-\n ");
		printBST(findLCA(root, 50, 70));*/
		/*System.out.print("\nThe Size of BST:- " + root.size());
		System.out.println("\nThe BST have node 7 :- " + root.findElement(7));
		root.addElement(6);
		printBST(root);
		System.out.print("\nThe Size of BST:- " + root.size());
		*/
		//root.removeElement(128);
		//printBST(root);
		/*
		 * System.out.print("\nBST is Empty(true/false):- "+root.isEmpty());
		 * System.out.print("\n The Node in range 50 and 150 is :- ");
		 * printNodeInRange(root, 50, 150);
		 * 
		 * 
		 * findPair(root, 110);
		 */
		/*HeadandTail headandTail = convertBSTtoSortedLinkedList(root);
		Node<Integer> currentNode = headandTail.head;
		while (currentNode!=null) {
			System.out.print(currentNode.data+"-->");
			currentNode = currentNode.next;
		}*/
	}

}
