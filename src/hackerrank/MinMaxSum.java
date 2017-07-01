package hackerrank;

import java.util.Scanner;

/**
 * Created by akhileshsoni on 17-06-2017.
 */
public class MinMaxSum {


    private static long[] findMinMaxSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        long[] result = new long[2];
        long sum = 0L;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
            sum += i;
        }
        result[0] = sum - max;
        result[1] = sum - min;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for (int arr_i = 0; arr_i < 5; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        long result[] = findMinMaxSum(arr);
        for (long l : result) {
            System.out.print(l + "");
        }
    }
}
