package l4;

import java.util.Scanner;

public class BinarySearchTreeUse {

	/**
	 * @param args
	 */
	public static BinarySearchTree<Integer> insertIntoBST(BinarySearchTree<Integer> root,BinarySearchTree<Integer>newNode) {
		
		if(root == null){
			root = newNode;
		}
		else if (newNode.data  <= root.data) {
			if(root.left == null){
				root.left = newNode;
			}
			else {
				root.left =  insertIntoBST(root.left, newNode);
			}
		}
		else {
			if(root.right == null){
				root.right = newNode;
			}
			else {
				root.right =  insertIntoBST(root.right, newNode);
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

	public static BinarySearchTree<Integer> findLCA(BinarySearchTree<Integer>root, int a, int b) {
		if(root == null){
			return null;
		}
		if(root.data == a||root.data == b){
			return root;
		}
		if(a < root.data && b > root.data || a > root.data && b < root.data)
		{
			return root;
		}
		if(a < root.data && b < root.data){
			root = findLCA(root.left, a, b);
		}
		if(a > root.data && b >root.data){
			root = findLCA(root.right, a, b);
		}
		return root;
	}
	
	public static void printNodeInRange(BinarySearchTree<Integer>root,int r1,int r2) {
		if(root == null){
			return;
		}
		else if(r1 < root.data && root.data < r2) {
			System.out.print(root.data+"\t");
		}
		printNodeInRange(root.left, r1, r2);
		printNodeInRange(root.right, r1, r2);
	}

	public static int findPair(BinarySearchTree<Integer>root, int sum) {
		if(root == null)
		{
			return 0;
		}
		int sumLeft = 0,sumRight = 0;
		sumLeft = findPair(root.left, sum);
		sumRight = findPair(root.right, sum);
		if(root.data + sumLeft == sum){
			System.out.print("\nThe pair which sum is equal to "+sum+" is:- "+root.data +", "+sumLeft);
		}
		if(root.data + sumRight == sum){
			System.out.print("\nThe pair which sum is equal to "+sum+" is:- "+root.data +", "+sumRight);
		}
		if(sumLeft+sumRight == sum){
			System.out.print("\nThe pair which sum is equal to "+sum+" is:- "+sumLeft +", "+sumRight);
		}
		return root.data;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> root = null;
		BinarySearchTree<Integer> newNode = null;
		int number;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Node Value:- ");
		number = sc.nextInt();
		while (number != -1) {
			newNode = new BinarySearchTree<Integer>(number);
			root = insertIntoBST(root, newNode);
			System.out.print("\nEnter the Next Node:- ");
			number = sc.nextInt();
		}
		printBST(root);
/*		System.out.print("\nThe Size of BST:- "+BinarySearchTree.size(root));
		System.out.print("\nBST is Empty(true/false):- "+root.isEmpty());
		System.out.print("\nThe BST have node:- "+BinarySearchTree.findElement(root,7).data);
		System.out.print("\n The LCA of 50 and 70 is :- "+findLCA(root, 50, 70).data);
		System.out.print("\n The Node in range 50 and 150 is :- ");
		printNodeInRange(root, 50, 150);*/
		
		findPair(root, 110);
		
	}
}
