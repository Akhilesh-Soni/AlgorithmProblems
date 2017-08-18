import java.util.Scanner;


public class Contain7Array {

	/**
	 * @param args
	 */
	public static boolean contains7(int array[], int startIndex){
		
		
		if(startIndex==array.length) {
			return false;
		}
		else if(array[startIndex]==7)
		{
			return true;
		}
		else {
			return contains7(array,(startIndex+1));
		}
	}
	public static int firstIndexof7(int array[], int startIndex){
		
		
		if(startIndex>=array.length) {
			return -1;
		}
		else if(array[startIndex]==7)
		{
			return startIndex;
		}
		else {
			return firstIndexof7(array,(startIndex+1));
		}
	}
	public static int lastIndexof7(int array[], int startIndex){
		
		
		if(startIndex>=array.length) {
			return -1;
		}
		else if(array[startIndex]==7)
		{
			return startIndex;
		}
		else {
			return lastIndexof7(array,(startIndex+1));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int array[] = new int[5];
		int startIndex = 0;
		int firstIndex = 0;
		int lastIndex = 0;
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		System.out.println("Enter the array:- ");
		for (int i = 0; i < array.length; i++) {
			array [i] = sc.nextInt();
		}
		flag = contains7(array,startIndex);
		firstIndex = firstIndexof7(array, startIndex);
		System.out.println("Contain 7 "+flag);
		System.out.println("First Index "+firstIndex);
		System.out.println("Last Index "+lastIndex);
	}

}
