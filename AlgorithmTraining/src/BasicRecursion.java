import java.util.Scanner;


public class BasicRecursion {

	/**
	 * @param args
	 */
	public static int sumofDigits(int a) {
		if(a == 0){
			return 0;
		}
		return a%10 + sumofDigits(a/10);
	}
	
	public static int factorial(int a) {
		if(a == 0){
			return 1;
		}
		return a*factorial(a-1);
	}
	
	public static int fibonacci(int a) {
		if(a<2){
			return a;
		}
		return fibonacci(a-1)+fibonacci(a-2);
	}	
	
	public static boolean searchString(String input, String searchString) {
		
		if(input.length()<4){
			return false;
		}
		if(input.substring(0, 4).equals(searchString)){
			return true;
		}
		return searchString(input.substring(4), searchString);
	}
	
	public static void printArray(int array[],int startIndex) {
		if(startIndex > array.length-1){
			return;
		}
		System.out.print(array[startIndex]+"\t");
		printArray(array, startIndex+1);
	}
	
	public static void printReverseArrayVersion1(int array[],int startIndex) {
		if(startIndex < 0){
			return;
		}
		System.out.print(array[startIndex]+"\t");
		printReverseArrayVersion1(array, startIndex-1);
	}
	
	public static void printReverseArrayVersion2(int array[],int startIndex) {
		if(startIndex > array.length-1){
			return;
		}
		printReverseArrayVersion2(array, startIndex+1);
		System.out.print(array[startIndex]+"\t");
	}
	
	public static int findMinimum(int array[],int startIndex) {
		
		if(startIndex >= array.length-1)
		{
			return array[startIndex];
		}
		int min = findMinimum(array, startIndex+1);
		if(min > array[startIndex]){
			min = array[startIndex]; 
		}
		return min;
	}
	
	public static int  bunnyEars2(int n) {
		
		int sum = 0;
		if(n == 0){
			return 0;
		}
		if(n % 2 == 0){
			sum += 3+bunnyEars2(n-1);
		}
		else {
			sum+= 2+bunnyEars2(n-1);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter The Number :- ");
		a = sc.nextInt();
/*		System.out.print("\nThe Sum of digits is :- "+sumofDigits(a));
		System.out.print("\nThe Factorial of number is :- "+factorial(a));
		System.out.print("\nThe "+a+"th element of Fibonacci series is :- "+fibonacci(a));
*/		System.out.print("\nThe Sum of Ears is :- "+bunnyEars2(a)+"\n");

/*		String input,searchString;
		boolean flag;
		System.out.print("Enter The Input String :- ");
		input = sc.nextLine();
		System.out.print("Enter The Search String :- ");
		searchString = sc.nextLine();
		flag = searchString(input, searchString);
		if (flag) {
			System.out.print("The String "+input+" contains "+searchString);
		}else {
			System.out.print("The String "+input+" does not contains "+searchString);	
		}
*/		
		int array[];
		array = InputArray.inputArray();
		System.out.print("\nThe Element of Array is:- " );
		printArray(array,0);
		System.out.print("\nThe minimum element is :- "+findMinimum(array,0));
/*		System.out.print("\nThe Element of Array in revese order(version1):- " );
		printReverseArrayVersion1(array, array.length-1);
		System.out.print("\nThe Element of Array in revese order(version2):- " );
		printReverseArrayVersion2(array, 0);*/
	}

}
