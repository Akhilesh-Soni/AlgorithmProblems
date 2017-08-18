import java.util.Scanner;


public class PolynomialEvaluation {

	/**
	 * @param args
	 */
	
	public static int[] inputArray()
	{
		int n;
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter the size of a:- ");
		n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the element of a:- ");
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		return a;
	}
	public static int polynomialEvaluation(int a[]) {
		int sum = 0;
		int x = 5;
		int p=1;
		for (int i = 0; i < a.length; i++) {
			sum +=a[i]*p;
			p = x*p;
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[];
		int sum;
		a = inputArray();
		sum = polynomialEvaluation(a);
		System.out.println("the Sum is :- "+sum);

	}

}
