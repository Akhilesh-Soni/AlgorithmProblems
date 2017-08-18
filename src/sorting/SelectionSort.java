package sorting;

/**
 * Created by akhileshsoni on 19-07-2017.
 */
public class SelectionSort {

    private static void selectionSortRecursive(int[] arr) {
        selectionSortRecursiveUtil(arr, 0);
    }

    private static void selectionSortRecursiveUtil(int[] arr, int i) {
        int len = arr.length - 1;
        if (i == len) {
            return;
        }
        int min = arr[i];
        int minIndex = i;
        for (int j = i + 1; j < len; j++) {
            if (arr[j] < min) {
                min = arr[j];
                minIndex = j;
            }
        }
        int temp = arr[i];
        arr[i] = min;
        arr[minIndex] = temp;
        selectionSortRecursiveUtil(arr, ++i);

    }

    private static void selectionSortIterative(int[] arr) {
        int length = arr.length;
        for (int i = 0; i <= length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j <= length - 1; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {15, 20, 5, 10, 45, 25, 35};
        for (int i : arr) {
            System.out.print(i + "    ");
        }
        selectionSortRecursive(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + "    ");
        }
    }
}
