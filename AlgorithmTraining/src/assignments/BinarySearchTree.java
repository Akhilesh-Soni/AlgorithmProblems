package assignments;

public class BinarySearchTree<T> {

	public T data;
	public BinarySearchTree<T> left;
	public BinarySearchTree<T> right;

	public BinarySearchTree(T data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}

	// Returns Total Number of element in tree
	public int size() {
		int size = 0;
		if (this == null) {
			return 0;
		}
		if (this.left == null && this.right == null) {
			return 1;
		}
		if (this.left != null) {
			size += this.left.size();
		}
		if (this.right != null) {
			size += this.right.size();
		}
		return size + 1;

	}

	// check if tree is empty or not
	public boolean isEmpty() {
		return this != null ? true : false;
	}

	//return min value of the tree
	public Integer min() {
		int min = (Integer)this.data;
		if (this == null) {
			return Integer.MAX_VALUE;
		}
		if(this.left == null && this.right == null){
			return min;
		}
		if(this.left!=null){
			min = Math.min(min, this.left.min());
		}
		if(this.right !=null){
			min = Math.min(min, this.right.min());
		}
		return min;
	}
	
	// Return Node if it present otherwise null
	public boolean findElement(int number) {

		if (((Integer) this.data) == number) {
			return true;
		}
		if (this.left == null && this.right == null) {
			return false;
		}
		if (this.left != null && number < (Integer) this.data) {
			return this.left.findElement(number);
		}
		if (this.right != null && number > (Integer) this.data) {
			return this.right.findElement(number);
		}

		return false;
	}

	// returns root value
	public Integer root() throws Exception {
		if (this == null) {
			BSTEmptyException bstEmptyException = new BSTEmptyException();
			throw bstEmptyException;
		}
		return (Integer) this.data;

	}

	// add the number at appropriate position
	public void addElement(T number) {
		if (this.left == null && (Integer) number <= (Integer) this.data) {
			this.left = new BinarySearchTree<>(number);
			System.out.println("\nThe Element is Added to the left of "
					+ this.data);
			return;
		}
		if (this.right == null && (Integer) number > (Integer) this.data) {
			this.right = new BinarySearchTree<>(number);
			System.out.println("\nThe Element is Added to the right of "
					+ this.data);
			return;
		}
		if ((Integer) number <= (Integer) this.data) {
			this.left.addElement(number);
			return;
		}
		if ((Integer) number > (Integer) this.data) {
			this.right.addElement(number);
			return;
		}
	}
	
	// remove the element from tree if it is present
	public void removeElement(int number) {

		BinarySearchTree<T> current = null;
		if ((Integer)this.data == number) {
			if (this.left == null && this.right == null) {
				return;
			}
			if(this.right != null){
				
				int temp = this.right.min();
				this.data = (T)this.right.min();
				BinarySearchTree<T> parent = null;
				parent = this.right;
				current = parent;
				while ((Integer)current.data!=temp) {
					parent = current;
					current = current.left;
				}
				
				if(current.right!=null){
					parent.left = current.right;
				}
				else {
					parent.left = null;
				}
				System.out.println("\nThe node "+ number+" is deleted from the tree");
				return;
			}

			return;
		}
		
		/*if the number is smaller than root data than we will find it in left
		 subtree
		*/		
		if (number < (Integer) this.data) {

			if (this.left == null) {
				System.out.println("\nThere is no node present in the tree");
				return;
			}
			
			/* if the node we are searching is left child of current accessing
			 node
			*/
			if ((Integer)this.left.data == number) {
				
				//the node is leaf node
				if(this.left.left == null && this.left.right == null){
					this.left = null;
					System.out.println("\nThe node "+ number+" is deleted from the tree");
					return;
				}
				
				//if the deletion node have both child
				if(this.left.left!=null && this.left.right!=null ){
					/*
					 * make the right child of deletion node to the left child
					 * of parent and left child of deletion node to left child of
					 * that node
					 */
					BinarySearchTree<T> left = this.left.left;
					BinarySearchTree<T> right = this.left.right;
					this.left = right;
					current = this.left;
					while (current.left!=null) {
						current = current.left;
					}
					current.left = left;
					System.out.println("\nThe node "+ number+" is deleted from the tree");
					return;
				}
				
				//if the deletion node have no right child
				if(this.left.right == null){
						this.left = this.left.left;
						System.out.println("\nThe node "+ number+" is deleted from the tree");
						return;
				}
				
				//if the deletion node have no left child
				if(this.left.right == null){
						this.left = this.left.right;
						System.out.println("\nThe node "+ number+" is deleted from the tree");
						return;
				}
				
			}
			this.left.removeElement(number);
		}
		
		/*if the number is greater than root data than we will find it in right
		 subtree
		*/
		if ((Integer) number > (Integer) this.data) {
			
			System.out.println("\nInside if right 1");
			if (this.right == null) {
				System.out.println("\nThere is no node present from the tree");
				return;
			}
			/* if the node we are searching is right child of current accessing
			 node
			*/
			if ((Integer)this.right.data == number) {
				System.out.println("\nInside if right 2");
				//the node is leaf node
				if(this.right.left == null && this.right.right == null){
					this.right = null;
					System.out.println("\nThe node "+ number+" is deleted from the tree");
					return;
				}
				
				//if the deletion node have both child
				if(this.right.left!=null && this.right.right!=null ){
					/*
					 * make the left child of deletion node to the right child
					 * of parent and right child of deletion node to right child of
					 * that node
					 */
					BinarySearchTree<T> left = this.right.left;
					BinarySearchTree<T> right = this.right.right;
					this.right = left;
					current = this.right;
					while (current.right!=null) {
						current = current.right;
					}
					current.right = right;
					System.out.println("\nThe node "+ number+" is deleted from the tree");
					return;
				}
				
				//if the deletion node have no right child
				if(this.right.right == null){
						this.right = this.right.left;
						System.out.println("\nThe node "+ number+" is deleted from the tree");
						return;
				}
				
				//if the deletion node have no left child
				if(this.right.left == null){
						this.right = this.right.right;
						System.out.println("\nThe node "+ number+" is deleted from the tree");
						return;
				}
				
			}
			this.right.removeElement(number);
		}
	}
}
