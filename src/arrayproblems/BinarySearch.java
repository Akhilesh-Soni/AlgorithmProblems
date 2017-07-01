package arrayproblems;

/**
 * Created by akhileshsoni on 13-04-2017.
 */
public class BinarySearch {
    public static int findElement(int[] array, int key) {
        return findElementUtil(array, 0, array.length - 1, key);
    }

    private static int findElementUtil(int[] array, int l, int r, int key) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (array[mid] == key) {
            return mid;
        } else if (array[mid] < key) {
            return findElementUtil(array, mid + 1, r, key);
        } else {
            return findElementUtil(array, l, mid - 1, key);
        }
    }

    public static void main(String[] args) {
        int array[] = {2, 5, 7, 10, 12, 15, 18};
        System.out.println(findElement(array, 18));
    }
}
