package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSortWithSinglePivot {

    private static void quickSortWithSinglePivot(int[] arr) {
        quickSortWithSinglePivotUtil(arr, 0, arr.length - 1);
    }

    private static void quickSortWithSinglePivotUtil(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partitionTheArray(arr, start, end);
            quickSortWithSinglePivotUtil(arr, start, pIndex - 1);
            quickSortWithSinglePivotUtil(arr, pIndex + 1, end);
        }
    }

    private static int partitionTheArray(int[] arr, int start, int end) {
        int pIndex = start;
        int pivot = arr[end];
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
        int arr[] = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }
        System.out.println();
        System.out.println("start " + System.currentTimeMillis());
        quickSortWithSinglePivot(arr);

        for (int i : arr) {
            System.out.println(i + " ");
        }
        System.out.println("end " + System.currentTimeMillis());

    }
}
