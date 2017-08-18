import java.util.Scanner;


public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int array[] = new int[5];
		int min,minIndex;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the elements:-");
		for (int index = 0;  index< array.length; index++) {
			array[index] = sc.nextInt();
		}
		System.out.println("The elements are:-");
		for (int index = 0;  index< array.length; index++) {
		System.out.println(""+array[index]);
		}
		
		for (int index1 = 0; index1 < array.length-1; index1++) {
			min = array[index1];
			minIndex = index1;
			for (int index2 = index1+1; index2 < array.length; index2++) {
				if(min>array[index2]){
					min = array[index2];
					minIndex = index2;
				}
			}    
			int temp = array[index1];
			array[index1] = min;
			array[minIndex] = temp;
		}
		System.out.println("After sorting the elements are:-");
		for (int index = 0;  index< array.length; index++) {
			System.out.println(""+array[index]);
		}
		
		String inString = null;
		System.out.println("Enter the String:-");
		inString = sc.next();
		System.out.println("The String is:-"+inString);
		int length = inString.length();
		int forward = 0; 
		int backward = length-1;
		boolean flag = true;
		for (int index1 = 0; index1 < (length/2); index1++) {
		
			if(inString.charAt(forward)==inString.charAt(backward)){
				forward++;
				backward--;
			}
			else
			{
				flag = false;
			}
		}
		if(flag){
			System.out.println(inString+" is pailendrome");
		}
		else {
			System.out.println(inString+" is not pailendrome");
		}
	}

}
