import java.util.Scanner;


public class InputArray {

	/**
	 * @param args
	 */
	public static int[] inputArray()
	{
		int n;
		Scanner sc  = new Scanner(System.in);
		System.out.print("Enter the size of array:- ");
		n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the element of array:- ");
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
//		System.out.print("The element of array is:- ");
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i]+"	");
//		}
		System.out.println();;
		return a;
	}

}
