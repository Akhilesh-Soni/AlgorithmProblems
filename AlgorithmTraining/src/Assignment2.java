import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Assignment2 {

	public static ArrayList<Integer> intersectionOfArrays(int[] a,
			int[] b) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (a.length <= b.length) {
			Assignment1.mergeSort(a);
			for (int i = 0; i < b.length; i++) {
				if (binarySearch(a, 0, a.length, b[i]) == true) {
					result.add(b[i]);
				}
			}

		} else {
			Assignment1.mergeSort(b);
			for (int i = 0; i < a.length; i++) {
				if (binarySearch(b, 0, b.length, a[i]) == true) {
					result.add(a[i]);
				}
			}
		}
		return result;
	}

	public static boolean binarySearch(int[] arr, int start,
			int end, int searchElement) {

		if (start < end) {
			int mid = start + (end - start) / 2;
			if (searchElement < arr[mid]) {
				return binarySearch(arr, start, mid, searchElement);

			} else if (searchElement > arr[mid]) {
				return binarySearch(arr, mid + 1, end, searchElement);

			} else {
				return true;
			}
		}
		return false;
	}

	public static void printSpiralArray(int[][] array, int rowCount,
			int colCount, int i, int j, ArrayList<Integer> output) {
		// TODO Auto-generated method stub

		if (rowCount == 0 || colCount == 0) {
			return;
		} 
		if (rowCount == 1 || colCount == 1) {
			if (rowCount == 1) {
				int tmpCount = 0;
				while (tmpCount < colCount) {
					output.add(array[i][j + tmpCount]);
					tmpCount++;

				}
			} else {

				int tmpCount = 0;
				while (tmpCount < rowCount) {
					output.add(array[i + tmpCount][j]);
					tmpCount++;
				}
			}
		} else {

			int count = 0;
			
			//start from top right corner
			while (count < colCount) {
				output.add(array[i][j + count]);
				count++;
			}

			//start from top Left corner
			count = 0;
			while (count < rowCount - 1) {
				output.add(array[i + count + 1][j + colCount - 1]);
				count++;
			}

			//start from bottom right corner
			count = 0;
			while (count < colCount - 1) {
				output.add(array[i + rowCount - 1][j + colCount - 2 - count]);
				count++;
			}
			
			//start from bottom left corner
			count = 0;
			while (count < rowCount - 2) {
				output.add(array[i + rowCount - 2 - count][j]);
				count++;
			}
			// print left array
			printSpiralArray(array, rowCount - 2, colCount - 2, i + 1, j + 1,
					output);
		}// end of else

	}

	public static void printSubSetofArray(int[] a, int count, ArrayList<Integer> output) {

		if (a.length == 0) {
			System.out.print(" ");
			return;
		}

		else {
			if (count == 0) {
				System.out.println(" ");
				if (count + 1 <= a.length)
					printSubSetofArray(a, count + 1, output);
				return;
			} else {
				ArrayList<Integer> currentArray = new ArrayList<>();
				if (count == 1) {
					for (int j = 0; j < a.length; j++) {
						System.out.println(a[j]);
						currentArray.add(a[j]);
					}

				} else {
					for (int i = output.size() + 1 - count, j = 0; i > 0; j++, i--) {
						int tmp = output.get(j);
						int current = a[j + count];
						tmp = tmp * 10 + current;
						currentArray.add(tmp);
						System.out.println(tmp);
					}
				}
				if (count < a.length)
					printSubSetofArray(a, count + 1, currentArray);
				return;
			}
		}
	}

		public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[],b[];
		System.out.print("\nEnter The First Array\n");
		a = InputArray.inputArray();
		System.out.print("\nEnter The Second Array\n");
		b = InputArray.inputArray();
		ArrayList<Integer> resultSet = new ArrayList<Integer>();
		resultSet = intersectionOfArrays(a,b);

		System.out.print("\nThe Intersection of Arrays is:- ");

		// result arrived
		for (int i = 0; i < resultSet.size(); i++) {
			System.out.print(resultSet.get(i)+"\t");
		}
	}
}
