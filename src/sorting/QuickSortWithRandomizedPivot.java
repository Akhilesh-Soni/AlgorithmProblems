package sorting;


import java.util.Random;

public class QuickSortWithRandomizedPivot {
    private static void quickSortWithRandomPivot(int[] arr) {
        quickSortWithRandomPivotUtil(arr, 0, arr.length - 1);
    }

    private static void quickSortWithRandomPivotUtil(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partitionTheArray(arr, start, end);
            quickSortWithRandomPivotUtil(arr, start, pIndex - 1);
            quickSortWithRandomPivotUtil(arr, pIndex + 1, end);
        }
    }

    private static int partitionTheArray(int[] arr, int start, int end) {
        int pIndex = new Random().nextInt(end - start + 1) + start;
        swap(arr, end, pIndex);
        int pivot = arr[end];
        pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] arr, int i, int pIndex) {
        int temp = arr[i];
        arr[i] = arr[pIndex];
        arr[pIndex] = temp;
    }


    public static void main(String[] args) {
        int arr[] = {7, 2, 1, 6, 8, 5, 3, 4};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        quickSortWithRandomPivot(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
