package arrayproblems;

import sorting.MergeSort;

/**
 * Created by akhileshsoni on 13-04-2017.
 */
public class UnionOfTwoArray {
    private static int[] findUnionOfTwoArray(int[] arr1, int[] arr2) {
        if (arr1.length < arr2.length) {
            MergeSort.mergeSort(arr1);
            return findUnionOfTwoArrayUtil(arr1, arr2);
        } else {
            MergeSort.mergeSort(arr2);
            return findUnionOfTwoArrayUtil(arr2, arr1);
        }
    }

    private static int[] findUnionOfTwoArrayUtil(int[] arr1, int[] arr2) {
        int[] unionOfArray = new int[arr1.length + arr2.length];
        int index = 0;
        for (int i : arr1) {
            unionOfArray[index++] = i;
        }
        for (int i : arr2) {
            if (BinarySearch.findElement(arr1, i) < 0) {
                unionOfArray[index++] = i;
            }
        }
        return unionOfArray;
    }

    public static void main(String[] args) {
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};

        int outputArray[] = findUnionOfTwoArray(arr1, arr2);
        for (int i : outputArray) {
            System.out.println(i);
        }
    }
}
