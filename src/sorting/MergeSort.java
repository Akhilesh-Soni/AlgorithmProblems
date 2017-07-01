package sorting;

/**
 * Created by akhileshsoni on 09-04-2017.
 */
public class MergeSort {
    public static void mergeSort(int[] a) {
        int length = a.length;
        if (length < 2) {
            return;
        }

        int mid = length / 2;
        int leftArray[] = new int[mid];
        int rightArray[] = new int[length - mid];
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = a[i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = a[i + mid];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        mergeArrays(a, leftArray, rightArray);
    }

    private static void mergeArrays(int[] a, int[] leftArray, int[] rightArray) {
        int lengthOfLeftArray = leftArray.length;
        int lengthOfRightArray = rightArray.length;
        int leftArrayPointer = 0;
        int rightArrayPointer = 0;
        int arrayPointer = 0;
        while (leftArrayPointer < lengthOfLeftArray && rightArrayPointer < lengthOfRightArray) {
            if (leftArray[leftArrayPointer] < rightArray[rightArrayPointer]) {
                a[arrayPointer] = leftArray[leftArrayPointer];
                leftArrayPointer++;
            } else {
                a[arrayPointer] = rightArray[rightArrayPointer];
                rightArrayPointer++;
            }
            arrayPointer++;
        }
        while (leftArrayPointer < lengthOfLeftArray) {
            a[arrayPointer] = leftArray[leftArrayPointer];
            leftArrayPointer++;
            arrayPointer++;
        }
        while (rightArrayPointer < lengthOfRightArray) {
            a[arrayPointer] = rightArray[rightArrayPointer];
            rightArrayPointer++;
            arrayPointer++;
        }
    }

    public static void main(String[] args) {
        int a[] = {-7, 4, -3, 2, 2, -8, -2, 3, 3, 7, -2, 3, -2};
        mergeSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
