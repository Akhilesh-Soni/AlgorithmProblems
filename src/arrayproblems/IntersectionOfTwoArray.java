package arrayproblems;

import sorting.MergeSort;

/**
 * Created by akhileshsoni on 13-04-2017.
 */
public class IntersectionOfTwoArray {
    private static int[] findIntersectionOfTwoArray(int[] arr1, int[] arr2) {
        if (arr1.length < arr2.length) {
            MergeSort.mergeSort(arr1);
            return findIntersectionOfTwoArrayUtil(arr1, arr2);
        } else {
            MergeSort.mergeSort(arr2);
            return findIntersectionOfTwoArrayUtil(arr2, arr1);
        }
    }

    private static int[] findIntersectionOfTwoArrayUtil(int[] arr1, int[] arr2) {
        int[] intersectionOfArray = new int[arr1.length];
        int index = 0;
        for (int i : arr2) {
            if (BinarySearch.findElement(arr1, i) >= 0) {
                intersectionOfArray[index++] = i;
            }
        }
        return intersectionOfArray;
    }

    public static void main(String[] args) {
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};

        int outputArray[] = findIntersectionOfTwoArray(arr1, arr2);
        for (int i : outputArray) {
            System.out.println(i);
        }
    }
}
