import java.util.ArrayList;


public class Recursion {

	public static void merge(int[] a, int[] b, int[] output) {

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				output[k] = a[i];
				i++;
				k++;
			} else {
				output[k] = b[j];
				k++;
				j++;
			}
		}

		while (i < a.length) {
			output[k] = a[i];
			i++;
			k++;
		}

		while (j < b.length) {
			output[k] = b[j];
			k++;
			j++;
		}
		return;
	}

	public static void mergeSort(int[]  input) {
		if (input.length <= 1) {
			return;
		}

		int mid = (input.length)/2;
		int a[] = new int[mid];
		int b[] = new int[input.length - mid];

		for (int i = 0; i < mid; i++) {
			a[i] = input[i];
		}

		for (int i = mid; i < input.length; i++) {
			b[i - mid] = input[i];
		}

		mergeSort(a);
		mergeSort(b);
		merge(a,b, input);

	}

	public static void iSelectionSort(int[] a) {
		for (int startIndex = 0; startIndex < a.length; startIndex++) {
			int minIndex = startIndex;
			int min = a[startIndex];
			for (int i = startIndex + 1; i < a.length; i++) {
				if (a[i] < min) {
					min = a[i];
					minIndex = i;
				}
			}
			a[minIndex] = a[startIndex];
			a[startIndex] = min;
		}
	}

	public static void selectionSort(int[] a, int startIndex) {
		if (startIndex >= a.length - 1) {
			return;
		}

		int minIndex = startIndex;
		int min = a[startIndex];
		for (int i = startIndex + 1; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
				minIndex = i;
			}
		}
		a[minIndex] = a[startIndex];
		a[startIndex] = min;
		selectionSort(a, startIndex + 1);
	}


	public static void towerOfHanoi(char a, char b, char c, int n) {
		if (n == 1) {
			System.out.println("move the 1st ring from " + a + " to " + c);
			return;
		}
		
		towerOfHanoi(a, c, b, n - 1);
		System.out.println("move the " + n + "th ring from " + a + " to " + c);
		towerOfHanoi(b, a, c, n-1);
	}
	
	public static ArrayList<String> subsequences(String input) {
		if (input.length() == 0) {
			ArrayList<String> output = new ArrayList<>();
			output.add("");
			return output;
		}

		ArrayList<String> smallerOutput = subsequences(input.substring(1));
		int size = smallerOutput.size();
		for (int i = 0; i < size; i++) {
			smallerOutput.add(input.charAt(0) + smallerOutput.get(i));
		}
		return smallerOutput;
	}

	public static boolean containsX(int[] a, int x, int startIndex) {
		if (startIndex >= a.length) {
			return false;
		}

		if (a[startIndex] == x) {
			return true;
		}
		return containsX(a, x, startIndex + 1);
	}

	public static int lastIndexX(int[] a, int x, int startIndex) {
		if (startIndex >= a.length) {
			return -1;
		}

		int smallerArrayOutput = lastIndexX(a, x, startIndex + 1);
		if (smallerArrayOutput != -1)
			return smallerArrayOutput;

		if (a[startIndex] == x)
			return startIndex;
		else
			return -1;

	}

	public static int firstIndexX(int[] a, int x, int startIndex) {
		if (startIndex >= a.length) {
			return -1;
		}

		if (a[startIndex] == x) {
			return startIndex;
		}
		return firstIndexX(a, x, startIndex + 1);
	}

	// checks if a is sorted from startIndex till the end
	public static boolean isSorted(int a[], int startIndex) {
		if (startIndex == a.length - 1 || startIndex == a.length)
			return true;

		if (a[startIndex] > a[startIndex + 1]) {
			return false;
		}
		return isSorted(a, startIndex + 1);
	}

	public static int factorial(int n) {
		if (n == 0)
			return 1;

		return n * factorial(n - 1);
	}

	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		return fib(n-1) + fib(n-2);

	}

	public static void main(String[] args) {
		int a[] = {5,4,3,2,1};
//		mergeSort(a);
//		for (int i :a) {
//			System.out.println(i);
//		}
//
//		System.out.println(isSorted(a, 0));
//		ArrayList<String> answer = subsequences("abc");
//		for (String s:answer) {
//			System.out.println(s);
//		}
		towerOfHanoi('A', 'B', 'C', 5);
	}

}
