import java.util.Scanner;



public class TimeComplexity 
{

	
	public static void printPairsSumToZero(int[] input) {
		
		for (int i = 0; i < input.length; i++) {
			
			for (int j = i+1; j < input.length; j++) {
				
				if (input[i] + input[j] == 0) {
					
					System.out.println(input[i] + " " + input[j]);
				
				}
			
			}
		
		}
	
	}
	
	
	public static void printPairsSumToZero2(int[] input) {
		
		Recursion.mergeSort(input);
		
		int i = 0; 
		
		int j = input.length - 1;
		
		while (i < j) {
			
			if (input[i] + input[j] == 0) {
				
				System.out.println(input[i] + " " + input[j]);
				
				i++;
				
				j--;
			
			} else if (input[i] + input[j] < 0) {

				i++;
			
			} else {
				
				j--;
			
			}
		}
	}

	
	public static void nonZeroesFirst(int[] input) {
		
	int i = 0;
		
	int j = 0;
		
	while (j < input.length) {
			
		if (input[j] != 0) {
				
			input[i] = input[j];
				
				i++;
			
		}
			
		j++;
		
	}
		
		while (i < input.length) {
			input[i] = 0;
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] a= {-1,0,-2,1,2};
		printPairsSumToZero2(a);
		
		System.out.println("Enter size of array");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = n - i;
		}
		
		long startTime = System.currentTimeMillis();
		Recursion.mergeSort(input);
		long endTime = System.currentTimeMillis();
		System.out.println("Time by merge sort:" + (endTime - startTime));
		
		for (int i = 0; i < n; i++) {
			input[i] = n - i;
		}
		
		startTime = System.currentTimeMillis();
		Recursion.iSelectionSort(input);
		endTime = System.currentTimeMillis();
		System.out.println("Time by selection sort:" + (endTime - startTime));
		
		
	}
}
