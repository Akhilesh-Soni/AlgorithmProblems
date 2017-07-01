package sorting;

/**
 * Created by akhileshsoni on 09-04-2017.
 */
public class BubbleSort {
    private static void bubbleSort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    private static void bubbleSortRecursive(int[] a, int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        bubbleSortRecursive(a, n - 1);
    }

    public static void main(String[] args) {
        int a[] = {933, 412, 238, 4343, 542, 2345, 2355, 7867, 36351};
        bubbleSortRecursive(a, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
