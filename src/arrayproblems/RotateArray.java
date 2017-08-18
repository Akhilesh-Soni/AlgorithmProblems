package arrayproblems;

/**
 * Created by akhileshsoni on 29-07-2017.
 */
public class RotateArray {
    private static void rotateArrayFromLeft(int[] arr, int k) {
        if (k > arr.length) {
            return;
        }
        reverseTheArray(arr, 0, k - 1);
        reverseTheArray(arr, k, arr.length - 1);
        reverseTheArray(arr, 0, arr.length - 1);
    }

    private static void reverseTheArray(int[] arr, int forward, int backward) {
        while (forward < backward) {
            int temp = arr[forward];
            arr[forward] = arr[backward];
            arr[backward] = temp;
            forward++;
            backward--;
        }
    }

    private static void rotateArrayFromRight(int[] arr, int k) {
        if (k > arr.length) {
            return;
        }
        reverseTheArray(arr,arr.length-k,arr.length-1);
        reverseTheArray(arr,0,arr.length-k-1);
        reverseTheArray(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        rotateArrayFromRight(arr, 2);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }
}
