package l4;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTreeUse {
	
	public static class DoubleInt {
		int height;
		int diameter;
	}
	
	public static class DoubleData {
		int largest;
		int secondLargest;
	}
	
	public static class BalanceData {
		boolean flag;
		int height;
	}
	
	public static class PreOrderIndex{
	
		public static int preIndex;
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public static int size(BinaryTreeNode<Integer>root){
		if(root == null){
			return 0;
		}
		return 1+size(root.left)+size(root.right);
	}
	
	public static DoubleInt diameterFaster(BinaryTreeNode<Integer> root) {
		if (root == null) {
			DoubleInt output = new DoubleInt();
			output.diameter = 0;
			output.height = 0;
			return output;
		}
		DoubleInt leftDouble = diameterFaster(root.left);
		DoubleInt rightDouble = diameterFaster(root.right);
		int height = Math.max(leftDouble.height, rightDouble.height) + 1;
		int diameter = Math.max(leftDouble.height + rightDouble.height, Math.max(rightDouble.diameter, leftDouble.diameter));
		DoubleInt output = new DoubleInt();
		output.diameter = diameter;
		output.height = height;
		return output;
	}

	public static int diameter(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int leftDia = diameter(root.left);
		int rightDia = diameter(root.right);
		return Math.max(leftHeight + rightHeight, Math.max(leftDia, rightDia));
		
	}

	public static void preorder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void postorder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}

	public static void inorder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
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

	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		System.out.println("Enter root data");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		// Nodes for which I haven't taken children info yet
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes  = new QueueUsingLL<>();
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
			int leftData  = s.nextInt();
			if (leftData != -1) {
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftData);
				pendingNodes.enqueue(left);
				currentNode.left = left;
			}

			System.out.println("Enter right child for " + currentNode.data);
			int rightData  = s.nextInt();
			if (rightData != -1) {
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightData);
				pendingNodes.enqueue(right);
				currentNode.right = right;
			}
		}
		return root;
	}

	public static int min(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(root.data, Math.min(min(root.left), min(root.right)));
	}
	
	public static int max(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(max(root.left), max(root.right)));
	}

	public static boolean isBST(BinaryTreeNode<Integer> root, int min, int max) {
		if (root == null)
			return true;
		
		if (root.data < min || root.data > max)
			return false;
		
		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
	}	
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null)
			return true;
		if (root.left != null) {
			if (root.data < max(root.left)) {
				return false;
			}
		}
		if (root.right != null) {
			if (root.data > min(root.right)) {
				return false;
			}
		}
		return isBST(root.left) && isBST(root.right);
	}
	
	public static BinaryTreeNode<Integer> findSuccessor(BinaryTreeNode<Integer> root, int node) {
		if (root == null)
			return null;
		
		if (root.data == node) {
			if (root.right != null) {
				BinaryTreeNode<Integer> output = root.right;
				while (output.left != null) {
					output = output.left;
				}
				return output;
			} else {
				return null;
			}
		}
		
		if (node < root.data) {
			BinaryTreeNode<Integer> output = findSuccessor(root.left, node);
			if (output == null) {
				return root;
			} else {
				return output;
			}
		} else {
			BinaryTreeNode<Integer> output = findSuccessor(root.right, node);
			return output;
		}
		
	}
	
	public static boolean findNode(BinaryTreeNode<Integer> root,int number) {
		
		boolean flag = false;
		if(root != null){
			if(root.data == number){
				flag = true;
				return flag;
			}
			if( findNode(root.left,number)?(flag = true):findNode(root.right, number)?(flag = true):(flag = false));
		}
		return flag;
	}
	
	public static int countLeafNode(BinaryTreeNode<Integer> root) {
		int count = 0;
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null ){
			return 1;
		}
		count = countLeafNode(root.left);
		count += countLeafNode(root.right);
		return count;
	}

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

	public static boolean checkBST(BinaryTreeNode<Integer>root) {
		
		if(root == null){
			return true;
		}
		
		if(root.left !=null){
				if(root.left.data<root.data){
					return true;
				}
		}
		if(root.right !=null){
			if(root.right.data>root.data){
				return true;
			}
		}
		
		return checkBST(root.left)&&checkBST(root.right);
	}
	
	public static int justGreater(BinaryTreeNode<Integer> root,int number) {
		
		int justGreater = 0;
		if(root == null){
			return justGreater;
		}
		justGreater = root.data;
		
		int justGreaterL = justGreater(root.left, number);
		if (justGreaterL!=0) {
			if(justGreaterL >= number && justGreater < justGreaterL){
				justGreater = justGreaterL;
			}
		}
		int justGreaterR = justGreater(root.right, number);
		if (justGreaterR!=0) {
			if(justGreaterR >= number && justGreater > justGreaterR ){
				justGreater = justGreaterR;
			}
		}
		System.out.print("\n"+justGreater);
		return justGreater;
			
	}
	
	public static DoubleData secondlargest(BinaryTreeNode<Integer> root) {
		
		DoubleData output = new DoubleData();
		if(root == null){
			output.largest = 0;
			output.secondLargest = 0;
			return output;
		}	
		DoubleData outputL = secondlargest(root.left);
		if(outputL.largest < root.data){
			outputL.secondLargest = outputL.largest;
			outputL.largest = root.data;
		}
		else if(outputL.secondLargest<root.data) {
			outputL.secondLargest = root.data;
		}
		output = outputL;
		System.out.print("\n"+output.largest+"\t"+output.secondLargest);
		
		DoubleData outputR = secondlargest(root.right);
		if(output.largest < outputR.largest){
			output.secondLargest = output.largest;
			output.largest = outputR.largest;
		}
		else if(output.secondLargest<outputR.largest) {
			output.secondLargest = outputR.largest;
		}
		System.out.print("\n"+output.largest+"\t"+output.secondLargest);
		return output;
	}

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

	public static BinaryTreeNode<Integer> createBinaryTreeFromInPre(int inOrder[], int preOrder[],int inStart,int inEnd) {
				
			 
			  if(inStart > inEnd)
			     return null;
			 
			  /* Pick current node from Preorder traversal using preIndex
			    and increment preIndex */
			  /*We have used PreOrderIndex class to make index of preorder array global*/
			 BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preOrder[PreOrderIndex.preIndex++]);
			 
			  /* If this node has no children then return */
			  if(inStart == inEnd)
			    return root;
			 
			  /* Else find the index of this node in Inorder traversal */
			  int i = 0;
			  while (inOrder[i]!=root.data) {
				i++;
			}
			  
			  /* Using index in Inorder traversal, construct left and
			     right subtress */
			  root.left = createBinaryTreeFromInPre(inOrder, preOrder, inStart, i-1);
			  root.right = createBinaryTreeFromInPre(inOrder, preOrder, i+1, inEnd);
			 
			  return root;
			
		}

	public static BinaryTreeNode<Integer> createBinaryTreeFromInPost(int inOrder[], int preOrder[],int inStart,int inEnd) {
		
		 
		  if(inStart > inEnd)
		     return null;
		 
		  /* Pick current node from Preorder traversal using preIndex
		    and increment preIndex */
		  /*We have used PreOrderIndex class to make index of preorder array global*/
		 BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preOrder[PreOrderIndex.preIndex--]);
		 
		  /* If this node has no children then return */
		  if(inStart == inEnd)
		    return root;
		 
		  /* Else find the index of this node in Inorder traversal */
		  int i = 0;
		  while (inOrder[i]!=root.data) {
			i++;
		}
		  
		  /* Using index in Inorder traversal, construct right and
		     \left subtress */

		  root.right = createBinaryTreeFromInPost(inOrder, preOrder, i+1, inEnd);
		 
		  root.left = createBinaryTreeFromInPost(inOrder, preOrder, inStart, i-1);
		  return root;
		
	}

	public static void prinNodeWDNHS(BinaryTreeNode<Integer> root) {
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null){
			return;
		}
		if (root.left!=null&&root.right==null) {
			System.out.print(root.left.data+"\t");
			prinNodeWDNHS(root.left);
		}
		if (root.right!=null&&root.left==null) {
			System.out.print(root.right.data+"\t");
			prinNodeWDNHS(root.right);
		}
		if(root.left!=null && root.right!=null){
			prinNodeWDNHS(root.left);
			prinNodeWDNHS(root.right);
		}
	}
	
	public static BinaryTreeNode<Integer> createDuplicates(BinaryTreeNode<Integer> root) {
		
		if(root == null){
			return null;
		}
		BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(root.data);
		if(root.left!=null){
			root.left = createDuplicates(root.left);
		}
		if(root.right!=null){
			root.right = createDuplicates(root.right);
		}
		newRoot.left = root.left;
		root.left = newRoot;
		
		return root;
	}

	public static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> root, int a, int b ) {
		if(root == null){
			return null;
		}
		if(root.data == a || root.data == b){
			return root;
		}
		BinaryTreeNode<Integer> left = null;
		BinaryTreeNode<Integer> right = null;
		if(root.left != null){
			left =  findLCA(root.left, a, b);
		}
		if(root.right !=null){
			right = findLCA(root.right, a, b);
		}
		if(left == null && right == null ){
			return null;
		}
		if(left!=null&&right == null){
			return left;
		}
		if(right!=null&&left == null){
			return right;
		}
		return root;
	}

	public static BinaryTreeNode<Integer> findLargestBST(BinaryTreeNode<Integer> root){
	
		if(root == null){
			return null;
		}
		if(root.left == null && root.right == null){
			return root;
		}
		BinaryTreeNode<Integer> left = null;
		BinaryTreeNode<Integer> right = null;
		if(root.left!=null){
			left = findLargestBST(root.left);
		}
		if(root.right!=null){
			right = findLargestBST(root.right);
		}
		if(left == null && right == null){
			return root;
		}
		if(left != null && right != null){
			//if left.data is less than root.data and right.data is greater than root.data
			if(left.data<= root.data && root.data < right.data){
				return root;
			}
			
			//if size of left subtree is greater than size of right subtree than largest subtree is left otherwise right subtree 
			if(size(left)>size(right)){
				return left;
			}
			else {
				return right;
			}
		}
		if(left!=null){
			if(left.data <= root.data){
				return root;
			}
		}
		if(right!=null){
			if(right.data > root.data){
				return root.right;
			}
		}
		
		return root;
		
	}

	public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root) {
		if(root == null){
			return null;
		}
		if(root.left == null && root.right == null){
			return null;
		}
		if (root.left == null) {
			if (root.right.left == null && root.right.right == null){
				root.left = null;
				root.right = null;
				return root;
			}
		}
		if (root.right == null) {
			if (root.left.left == null && root.left.right == null){
				root.left = null;
				root.right = null;
				return root;
			}
		}
		if (root.left.left == null && root.left.right == null
				&& root.right.left == null && root.right.right == null) {
			root.left = null;
			root.right = null;
			return root;
		}
		root.left = removeLeaf(root.left);
		root.right = removeLeaf(root.right);
		
		return root;
	}

	
	public static void main(String args[]) {
//		boolean flag;
//		System.out.print("\nEnter First tree:\n");
		BinaryTreeNode<Integer> root1 = takeInputLevelWise();
//		System.out.print("\nEnter Second tree:\n");
//		BinaryTreeNode<Integer> root2 = takeInputLevelWise();
		print(root1);
		System.out.print("\n");
		preorder(root1);
		System.out.print("\n");
		inorder(root1);
		System.out.print("\n");
		postorder(root1);
		//print(root2);
//		flag = findNode(root,5);
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
	/*	root1 = findLargestBST(root1);
		System.out.print("\nThe Largest BST in Binary Tree is :-\n");
		print(root1);*/
		/*root1 = removeLeaf(root1);
		System.out.print("\nAfter removing leaf nodes Binary Tree is :-\n");
		print(root1);*/
	}
		
}
