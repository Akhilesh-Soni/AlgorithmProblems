package assignments;

public class temp {

	/*// if one of them is not BST than including root it is also not a
	// subtree
	if (!leftSubtree.flag
			|| !rightSubtree.flag
			|| (leftSubtree.max > root.data || root.data >= rightSubtree.min)) {

		if (leftSubtree.max > root.data && root.data > rightSubtree.min) {
			// if leftSubtree is BST
			if (leftSubtree.flag) {
				
				 * if leftSubtree's root value is less than root's value and if
				 * leftSubtree's max value is less than root's value than it is
				 * the BST and discard rightSubtree otherwise leftSubtree is the
				 * only largest BST
				 
				if (leftSubtree.root.data <= root.data
						&& leftSubtree.max <= root.data) {
					root.right = null;
					largestBST.root = root;
					largestBST.max = leftSubtree.max;
					largestBST.size = 1 + leftSubtree.size;
					largestBST.flag = true;
					return largestBST;
				}

			}

			// if rightSubtree is BST
			if (rightSubtree.flag) {
				
				 * if rightSubtree's root value is greater than root's value and
				 * if rightSubtree's min value is greater than root's value than
				 * it is the BST and discard leftSubtree otherwise rightSubtree
				 * is the only largest BST
				 
				if (rightSubtree.root.data < root.data
						&& rightSubtree.min > root.data) {
					root.left = null;
					largestBST.root = root;
					largestBST.min = rightSubtree.min;
					largestBST.size = 1 + rightSubtree.size;
					largestBST.flag = true;
					return largestBST;
				}

				else {
					largestBST.root = rightSubtree.root;
					largestBST.min = rightSubtree.min;
					largestBST.size = rightSubtree.size;
					largestBST.flag = true;
					return largestBST;
				}
			}
			else {
			largestBST.root = root;
			largestBST.flag = false;
			largestBST.size = 1 + leftSubtree.size + rightSubtree.size;
			return largestBST;
			}
		}

		
	}

	
	 * if leftSubtree's max value is less than root's value and
	 * rightSubtree's min value is greater than root's value than make
	 * largestBST's root = root because it will be the largest tree
	 * otherwise make largestBST's flag = false
	 
	if (leftSubtree.max <= root.data && root.data < rightSubtree.min) {

		largestBST.root = root;
		largestBST.max = max(root);
		largestBST.min = min(root);
		largestBST.size = 1 + leftSubtree.size + rightSubtree.size;
		largestBST.flag = true;
		return largestBST;
	}*/

}
