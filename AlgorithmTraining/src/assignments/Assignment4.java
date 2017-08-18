package assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Assignment4 {

	/**
	 * @param args
	 */
	//used to store largest and secondLargest value
	public static class DoubleData {
		int largest;
		int secondLargest;
	}
	
	//used to store height(1,0,-1) of tree as well as balance of tree (true if height = 1,0,-1 else false)
	public static class BalanceData {
		boolean flag;
		int height;
	}
	
	//store the index of preorder or postorder array
	public static class Index{
		
		public static int index;
	}
	
	//store the data of largestBST
	public static class LargestBSTData {
	
		BinaryTreeNode<Integer> root;
		int min;
		int max;
		int size;
		boolean  flag;
	}
	
	//return the number of nodes of tree
	public static int size(BinaryTreeNode<Integer>root){
		if(root == null){
			return 0;
		}
		return 1+size(root.left)+size(root.right);
	}
	
	//return min value of the tree
	public static int min(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(root.data, Math.min(min(root.left), min(root.right)));
	}
	
	//return max value of the tree
	public static int max(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(max(root.left), max(root.right)));
	}

	//Return height of tree
	public static int heightofTree(BinaryTreeNode<Integer> root) {
		if(root == null){
			return 0;
		}
		
		return 1 + Math.max(heightofTree(root.left), heightofTree(root.right));
	}
	
	// take inputs
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		System.out.println("Enter root data");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		// Nodes for which I haven't taken children info yet
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (Exception e) {
				System.out.println("Cant come here");
				return null;
			}
			System.out.println("Enter left child for " + currentNode.data);
			int leftData = s.nextInt();
			if (leftData != -1) {
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(
						leftData);
				pendingNodes.enqueue(left);
				currentNode.left = left;
			}

			System.out.println("Enter right child for " + currentNode.data);
			int rightData = s.nextInt();
			if (rightData != -1) {
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(
						rightData);
				pendingNodes.enqueue(right);
				currentNode.right = right;
			}
		}
		return root;
	}

	// print nodes of tree
	public static void print(BinaryTreeNode<Integer> root) {
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

		print(root.left);
		print(root.right);
	}
	
	//create mirror image of given tree
	public static BinaryTreeNode<Integer> mirrorTreeImage(BinaryTreeNode<Integer>root) {
		BinaryTreeNode<Integer> temp;
		if(root == null){
			return null;
		}
		if(root.left == null && root.right == null)
		{
			return root;
		}
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorTreeImage(root.left);
		mirrorTreeImage(root.right);
		return root;
	}
	
	//check if Binary tree is BST or not
	public static boolean isBST(BinaryTreeNode<Integer>root) {
		
		if(root == null){
			return true;
		}
		if(root.left == null && root.right == null){
			return true;
		}
		boolean leftFlag = isBST(root.left);
		boolean rightFlag = isBST(root.right);
		
		if(leftFlag&&rightFlag){
			if(root.left != null && root.right!=null){
				if(max(root.left) <= root.data && root.data < min(root.right)){
					return true;
				}
				else{
					return false;
				}
			}
			if(root.left == null){
				if(root.data < min(root.right)){
					return true;
				}
			}
			if(root.right == null){
				if(max(root.left) <= root.data){
					return true;
				}
			}
		}
		return false;
	}
	
	//count leafNodes of tree
	public static int countLeafNode(BinaryTreeNode<Integer> root) {
		int count = 0;
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return 1;
		}
		if(root.left!=null){
			count = countLeafNode(root.left);
		}
		if(root.right!=null){
			count += countLeafNode(root.right);
		}
		return count;
	}
	
	//checks if both tree are same or not
	public static boolean isTreeSame(BinaryTreeNode<Integer>root1,BinaryTreeNode<Integer>root2 ) {
		
		boolean flag = false;
		if(root1 == null || root2 == null){
			return true;
		}
		if(root1.data == root2.data){
			flag = true;
			if (isTreeSame(root1.left, root2.left)?(isTreeSame(root1.right, root2.right)?(flag=true):(flag=false)):(flag = false));
		}
		return flag;
	}

	//find just greater number than given number
	public static int justGreater(BinaryTreeNode<Integer> root, int number) {

		int justGreater = 0;
		if (root == null) {
			return justGreater;
		}
		justGreater = root.data;

		int justGreaterL = justGreater(root.left, number);
		if (justGreaterL != 0) {
			if (justGreaterL >= number && justGreater < justGreaterL) {
				justGreater = justGreaterL;
			}
		}
		int justGreaterR = justGreater(root.right, number);
		if (justGreaterR != 0) {
			if (justGreaterR >= number && justGreater > justGreaterR) {
				justGreater = justGreaterR;
			}
		}
		
		return justGreater;

	}

	//find second largest in the tree
	public static DoubleData secondlargest(BinaryTreeNode<Integer> root) {

		DoubleData output = new DoubleData();
		if (root == null) {
			output.largest = 0;
			output.secondLargest = 0;
			return output;
		}
		DoubleData outputL = secondlargest(root.left);
		if (outputL.largest < root.data) {
			outputL.secondLargest = outputL.largest;
			outputL.largest = root.data;
		} else if (outputL.secondLargest < root.data) {
			outputL.secondLargest = root.data;
		}
		output = outputL;
		System.out.print("\n" + output.largest + "\t" + output.secondLargest);

		DoubleData outputR = secondlargest(root.right);
		if (output.largest < outputR.largest) {
			output.secondLargest = output.largest;
			output.largest = outputR.largest;
		} else if (output.secondLargest < outputR.largest) {
			output.secondLargest = outputR.largest;
		}
		System.out.print("\n" + output.largest + "\t" + output.secondLargest);
		return output;
	}

	//check balance of tree if 1,-1,0 return true otherwise false
	public static BalanceData checkBalance(BinaryTreeNode<Integer> root) {
		BalanceData balanceData = new BalanceData();
		if (root == null) {
			balanceData.flag = true;
			balanceData.height = 0;
			return balanceData;
		}

		BalanceData balanceDataLeft = checkBalance(root.left);
		BalanceData balanceDataRight = checkBalance(root.right);
		if (balanceDataLeft.height - balanceDataRight.height == 0
				|| balanceDataLeft.height - balanceDataRight.height == 1
				|| balanceDataLeft.height - balanceDataRight.height == -1) {
			balanceData.height = 1+(balanceDataLeft.height>balanceDataRight.height?balanceDataLeft.height:balanceDataRight.height);
			balanceData.flag = true;
		}
		return balanceData;
	}
	
	//create duplicate of each node and attach it to node's left side
	public static BinaryTreeNode<Integer> createDuplicates(
			BinaryTreeNode<Integer> root) {

		if (root == null) {
			return null;
		}
		BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(root.data);
		if (root.left != null) {
			root.left = createDuplicates(root.left);
		}
		if (root.right != null) {
			root.right = createDuplicates(root.right);
		}
		newRoot.left = root.left;
		root.left = newRoot;

		return root;
	}

	//print nodes who does not have sibling
	public static void prinNodeWDNHS(BinaryTreeNode<Integer> root) {
			if (root == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				return;
			}
			if (root.left != null && root.right == null) {
				System.out.print(root.left.data + "\t");
				prinNodeWDNHS(root.left);
			}
			if (root.right != null && root.left == null) {
				System.out.print(root.right.data + "\t");
				prinNodeWDNHS(root.right);
			}
			if (root.left != null && root.right != null) {
				prinNodeWDNHS(root.left);
				prinNodeWDNHS(root.right);
			}
		}

	//creates binary tree from inorder and preorder
	public static BinaryTreeNode<Integer> createBinaryTreeFromInPre(
			int inOrder[], int preOrder[], int inStart, int inEnd) {

		if (inStart > inEnd)
			return null;

		/* Pick current node from Preorder traversal using preIndex and
		   increment preIndex
		
		 * We have used PreOrderIndex class to make index of preorder array
		   global
		*/
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(
				preOrder[Index.index++]);

		/* If this node has no children then return */
		if (inStart == inEnd)
			return root;

		/* Else find the index of this node in Inorder traversal */
		int i = 0;
		while (inOrder[i] != root.data) {
			i++;
		}

		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		root.left = createBinaryTreeFromInPre(inOrder, preOrder, inStart, i - 1);
		root.right = createBinaryTreeFromInPre(inOrder, preOrder, i + 1, inEnd);

		return root;

	}
	
	//creates binary tree from inorder and postorder
	public static BinaryTreeNode<Integer> createBinaryTreeFromInPost(
			int inOrder[], int postOrder[], int inStart, int inEnd) {

		if (inStart > inEnd)
			return null;

		/* Pick current node from Postorder traversal using preIndex and
		   increment preIndex
		 * We have used Index class to make index of postorder array
		   global
		*/
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(
				postOrder[Index.index--]);

		/* If this node has no children then return */
		if (inStart == inEnd)
			return root;

		/* Else find the index of this node in Inorder traversal */
		int i = 0;
		while (inOrder[i] != root.data) {
			i++;
		}

		/*
		 * Using index in Inorder traversal, construct right and \left subtress
		 */
		
		root.right = createBinaryTreeFromInPost(inOrder, postOrder, i + 1, inEnd);

		root.left = createBinaryTreeFromInPost(inOrder, postOrder, inStart,
				i - 1);
		return root;
	}

	/*
	* Find the lowest common ancestor of any two nodes present in tree, Here we
	 * are assuming that the nodes are present in tree otherwise first we will
	 * find that if they are present in tree or not
	 */

	public static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> root,
			int a, int b) {
		if (root == null) {
			return null;
		}
		if (root.data == a || root.data == b) {
			return root;
		}
		BinaryTreeNode<Integer> left = null;
		BinaryTreeNode<Integer> right = null;
		if (root.left != null) {
			left = findLCA(root.left, a, b);
		}
		if (root.right != null) {
			right = findLCA(root.right, a, b);
		}
		if (left == null && right == null) {
			return null;
		}
		if (left != null && right == null) {
			return left;
		}
		if (right != null && left == null) {
			return right;
		}
		return root;
	}

	//find largest binary search tree in binary tree 
	public static LargestBSTData findLargestBST(
			BinaryTreeNode<Integer> root) {
		LargestBSTData largestBST = new LargestBSTData();
		if (root == null) {
			return largestBST;
		}
		
		/*
		 * if root.left  is null and root.right is null then return
		 * root,because root is the only one node and it, itself a BST
		 */
		if (root.left == null && root.right == null) {
			largestBST.root = root;
			largestBST.min = root.data;
			largestBST.max = root.data;
			largestBST.size = 1;
			largestBST.flag = true;
			return largestBST;
		}
		
		LargestBSTData leftSubtree = findLargestBST(root.left);
		LargestBSTData rightSubtree = findLargestBST(root.right);
		
		if(leftSubtree.root==null&&rightSubtree.flag){
			
			/* 
			 * if rightSubtree's min value is greater than root's value than
			 * including root it is the largest BST otherwise leftSubtree is 
			 * only largest BST 
			 */
			if (rightSubtree.min > root.data) {
				largestBST.root = root;
				largestBST.min = min(root);
				largestBST.max = max(root);
				largestBST.size = 1 + rightSubtree.size;
				largestBST.flag = true;
				return largestBST;
			}
			else {
				largestBST.root = rightSubtree.root;
				largestBST.size = rightSubtree.size;
				largestBST.flag = false;
				return largestBST;
			}
		}
		
		if (rightSubtree.root == null && leftSubtree.flag) {

			/*
			 * if lesftSubtree's max value is smaller than root's value than
			 * including root it is the largest BST otherwise leftSubtree is the
			 * only largest BST
			 */
			if (leftSubtree.max < root.data) {
				largestBST.root = root;
				largestBST.min = min(root);
				largestBST.max = max(root);
				largestBST.size = 1 + leftSubtree.size;
				largestBST.flag = true;
				return largestBST;
			} else {
				largestBST.root = leftSubtree.root;
				largestBST.size = leftSubtree.size;
				largestBST.flag = false;
				return largestBST;
			}
		}

		
		/*
		 * if leftSubtree's max value is less than root's value and
		 * rightSubtree's min value is greater than root's value than make
		 * largestBST's root = root because it will be the largest tree
		 * otherwise make largestBST's flag = false
		*/ 
		if (leftSubtree.max <= root.data && root.data < rightSubtree.min) {

			largestBST.root = root;
			largestBST.max = max(root);
			largestBST.min = min(root);
			largestBST.size = 1 + leftSubtree.size + rightSubtree.size;
			largestBST.flag = true;
			return largestBST;
		}
		
		else {
			if(leftSubtree.flag&&rightSubtree.flag){
				if(leftSubtree.size >= rightSubtree.size){
					largestBST.root = leftSubtree.root;
					largestBST.flag = false;
					return largestBST;
				}
				else {
					largestBST.root = rightSubtree.root;
					largestBST.flag = false;
					return largestBST;
				}
			}
			if(leftSubtree.flag){
				largestBST.root = leftSubtree.root;
				largestBST.flag = true;
				largestBST.size = leftSubtree.size;
				return largestBST;
			}
			if(rightSubtree.flag){
				largestBST.root = rightSubtree.root;
				largestBST.flag = true;
				largestBST.size = rightSubtree.size;
				return largestBST;
			}
		}
		return largestBST;
	}	

	//create seperateLinkList for each level
	public static ArrayList<Node<Integer>> seperateLinkedList(BinaryTreeNode<Integer> root) {
		ArrayList<Node<Integer>> list = new ArrayList<>();
		QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			
			Node<Integer> head = null;
			Node<Integer>tail = null;
			int nodeAtDepth = queue.size();
			while (nodeAtDepth>0) {
				try {
					root = queue.dequeue();	
				} catch (Exception e) {}
				Node<Integer> currentNode = new Node<Integer>(root.data);
				if(head == null){
					head = currentNode;
					tail = head;
				}
				else {
					tail.next = currentNode;
					tail = tail.next;
				}
				if(root.left != null){
					queue.enqueue(root.left); 
				}
				if (root.right!=null) {
					queue.enqueue(root.right);
				}
				nodeAtDepth--;
			}
			list.add(head);
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag;
//		System.out.print("\nEnter First tree:\n");
		BinaryTreeNode<Integer> root1 = takeInputLevelWise();
//		System.out.print("\nEnter Second tree:\n");
//		BinaryTreeNode<Integer> root2 = takeInputLevelWise();
		print(root1);
		//System.out.print("\nThe height of tree :- "+heightofTree(root1));
		//System.out.print("\nThe number of leaf node :- "+countLeafNode(root1));
		//print(root2);
//		flag = findNode(root,5);
		System.out.print("\n The Given tree is BST :- "+isBST(root1) );
		/*root1 = mirrorTreeImage(root1);
		System.out.println("\n After mirroring the tree...");
		print(root1);*/
		
//		System.out.print("\nThe Number of leaf Node is :- "+countLeafNode(root));
/*		flag = isBST(root1);
		if(flag){
			System.out.print("\nThe tree are Same");
		}
		else {
			System.out.print("\nThe tree are not same");
		}
*/		
//		System.out.print("\nJust Greater number in tree :- "+ justGreater(root1,7));
/*		DoubleData output = secondlargest(root1);
		System.out.print("\nThe Second Largest Number is:- "+output.secondLargest);*/	
/*		BalanceData output = checkBalance(root1);
		if(output.flag){
			System.out.print("\nThe tree is balanced");
		}
		else {
			System.out.print("\nThe tree is not balanced");
		}*/
		/*int inOrder[] = {3,12,6,4,7,10,11,5,2,8};
		int preOrder[] = {10,12,3,4,6,7,5,11,2,8};
		int postOrder[] = {3,6,7,4,12,11,8,2,5,10};
		root1 = createBinaryTreeFromInPre(inOrder, preOrder,0,inOrder.length-1);
		PreOrderIndex.preIndex = preOrder.length-1;
		root1 = createBinaryTreeFromInPost(inOrder, postOrder, 0, inOrder.length-1);
		print(root1);*/
/*		System.out.print("\nThe node that does not have any sibling:- ");
		prinNodeWDNHS(root1);*/
/*		System.out.print("\nAfter duplication the tree is:-\n");
		print(createDuplicates(root1));*/
/*		BinaryTreeNode<Integer>root2 = findLCA(root1, 4, 7);
		System.out.print("The Lowest common ancestor of 4 and 7:-"+root2.data);
		root2 = findLCA(root1, 3, 4);
		System.out.print("\nThe Lowest common ancestor of 3 and 4:-"+root2.data);*/
	/*	LargestBSTData largestBST = findLargestBST(root1);
		System.out.print("\nThe Largest BST in Binary Tree is :-\n");
		print(largestBST.root);*/
		/*root1 = removeLeaf(root1);
		System.out.print("\nAfter removing leaf nodes Binary Tree is :-\n");
		print(root1);*/
		/*System.out.println("The Seperate LinkedList of eachlevel...");
		ArrayList<Node<Integer>> list = seperateLinkedList(root1);
		for (Iterator<Node<Integer>> iterator = list.iterator(); iterator.hasNext();) {
			Node<Integer> node = (Node<Integer>) iterator.next();
			while (node!=null) {
				System.out.print(node.data+"-->");
				node = node.next;
			}
			System.out.println();
		}*/

	}

}
