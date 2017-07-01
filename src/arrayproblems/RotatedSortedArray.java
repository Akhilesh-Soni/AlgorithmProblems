package arrayproblems;

/**
 * Created by akhileshsoni on 09-04-2017.
 */
public class RotatedSortedArray {

    private static int findKByWhichArrayIsRotated(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                count++;
            } else {
                count++;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {5, 6, 7, 2, 3, 4};
        System.out.println(findKByWhichArrayIsRotated(a));
    }
}
