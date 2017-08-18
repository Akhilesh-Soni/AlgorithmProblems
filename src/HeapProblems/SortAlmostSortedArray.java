package HeapProblems;

import java.util.Arrays;

/**
 * Created by akhileshsoni on 28-07-2017.
 */
public class SortAlmostSortedArray {
    private static void sortTheArray(int[] arr, int k) {
        int[] temp = Arrays.copyOf(arr, k);
        MinHeap minHeap = new MinHeap(temp);
        minHeap.buildMinHeap();
        int index = 0;
        for (int i = k; i < arr.length; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }
        while (k > 0) {
            arr[index++] = minHeap.poll();
            k--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 6, 3, 12, 56, 8};
        int k = 3;
        for (int i : arr) {
            System.out.print(i + "    ");
        }
        sortTheArray(arr, k);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + "    ");
        }
    }
}
