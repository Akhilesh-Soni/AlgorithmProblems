package l4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Tree {
	
	public static void print(TreeNode<Integer> root) {
		String s = root.data + ":";
		for (TreeNode<Integer> child: root.children) {
			s += child.data + ",";
		}
		System.out.println(s);
		for (TreeNode<Integer> child : root.children) {
			print(child);
		}
	}
	
	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root");
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<>();
		root.data = rootData;
		
		QueueUsingLL<TreeNode<Integer>> queue = new QueueUsingLL<>();
		queue.enqueue(root);
		
		while (!queue.isEmpty()) {
			TreeNode<Integer> firstNode;
			try {
				firstNode = queue.dequeue();
			} catch (Exception e) {
				return null;
			}
			System.out.println("Enter number of children of " + firstNode.data);
			int childCount = s.nextInt();
			for (int i = 0; i < childCount; i++) {
				System.out.println("Enter next child of " + firstNode.data);
				int childData = s.nextInt();
				TreeNode<Integer> child = new TreeNode<>();
				child.data = childData;
				
				firstNode.children.add(child);
				queue.enqueue(child);
			}
		}
		return root;
	}
	
	public static int count(TreeNode<Integer> root) {
		int count = 0;
		for (TreeNode<Integer> child: root.children) {
			count += count(child);
		}
		return 1 + count;
	}
	
	public static TreeNode<Integer> takeInput() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root");
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<>();
		root.data = rootData;
		System.out.println("Enter number of Children");
		int numChild = s.nextInt();
		for (int i = 0; i < numChild; i++) {
			root.children.add(takeInput());
		}
		return root;
	}

	public static int  heightofTree(TreeNode<Integer> root) {
		int max = 0;
		for (TreeNode<Integer> child : root.children) {
			if(max<heightofTree(child)){
				max = heightofTree(child);
			}
		}
		return 1+max;
	}
	
	public static int greatestElement(TreeNode<Integer> root) {
		int largest = root.data;
		for (TreeNode<Integer> child : root.children) {
			if(largest<greatestElement(child)){
				largest = greatestElement(child);		
			}
		}
		return largest;	
	}
	
	public static int numberofNodeGreater(TreeNode<Integer> root,int value) {
		int count = 0;
		if(root.data>value){
			count++;
		}
		for (TreeNode<Integer> child : root.children) {
			count += numberofNodeGreater(child, value);
		}
		return count;	
	}
	
	public static void printNodeatDepth(TreeNode<Integer> root,int depth) {
		
		if(depth>heightofTree(root)){
			System.out.print("\nThe depth is not exist");
		}
		else {
		
			if(depth>0){
				depth--;
			}
			for (TreeNode<Integer> child : root.children) {
				if(depth>0){
					printNodeatDepth(child, depth);
				}
				else
				{
					System.out.print(child.data+"\t");
					printNodeatDepth(child, depth);
				}
			}
		}	
	}


	public static void main(String[] args) {
		// 1 2 2 3 2 4 5 2 6 7 0 0 0 0 
		TreeNode<Integer> root = takeInputLevelWise();
		print(root);
		//System.out.println("Height "+heightofTree(root));
		//System.out.println("largest "+greatestElement(root));
		//System.out.println("Number of Nodes Greater than 4:- "+numberofNodeGreater(root, 4));
		printNodeatDepth(root, 1);
		
	}

}
