package test;

import java.util.Scanner;

public class BinaryTreeUse {
	
	
	// Return height of tree
	public static int heightofTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
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
	

}
