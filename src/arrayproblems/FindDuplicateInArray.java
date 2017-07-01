package arrayproblems;

/**
 * Created by akhileshsoni on 10-04-2017.
 */
public class FindDuplicateInArray {
    private static void printDuplicateNumber(int[] a) {
        int length = a.length;
        System.out.println("The repeating elements are : ");

        for (int i = 0; i < length; i++) {
            int abs = Math.abs(a[i]);
            if (a[abs] > 0)
                a[abs] = -a[abs];
            else
                System.out.print(abs + " ");
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 1, 2};
        printDuplicateNumber(a);
    }
}
