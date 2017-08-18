import java.util.Scanner;


public class RotateChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char array[] = {'a','b','c','d','e','f','g','h','i'};
		int k;
		int start = 0, end = array.length-1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Rotation value :-");
		k = sc.nextInt();
		
		while(k>0){
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			end--;
			start++;
			k--;
		}
		for(char t:array){
			System.out.print(t);
		}
	}

}
