package l4;

public class BinarySearchTree<T> {

	public T data;
	public BinarySearchTree<T> left;
	public BinarySearchTree<T> right;

	public BinarySearchTree(T data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	
	//Returns Total Number of element in tree
	public static int size(BinarySearchTree<Integer>root){
		if(root == null){
			return 0;
		}
		return 1+size(root.left)+size(root.right);
	}
	
	//check if tree is empty or not
	public boolean isEmpty() {
		return this != null?true:false;
	}
	
	//Return Node if it present otherwise null
	public static BinarySearchTree<Integer> findElement(BinarySearchTree<Integer> root,int number) {
		if(root == null){
			return null;
		}
		if((root.data) == number){
			return root;
		}
		return number < root.data?findElement(root.left,number):findElement(root.right,number);
	}
	
	//returns root value
	public Integer root() throws Exception {
		if(this == null){
			BSTEmptyException bstEmptyException = new BSTEmptyException();
			throw bstEmptyException;
		}
		return (Integer) this.data;
		
	}
	
	//add the number at appropriate position
	public void addElement(int number) {
		if(number < (Integer)this.data){
			if(this.left == null){
				this.left = ((BinarySearchTree<T>) new BinarySearchTree<Integer>(number));
			}
		}
	}
	
}
