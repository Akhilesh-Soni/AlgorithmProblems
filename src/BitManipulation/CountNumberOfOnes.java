package BitManipulation;

import java.util.Scanner;

/**
 * Count the number of ones in the binary representation of the given number.
 */
public class CountNumberOfOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            System.out.println(getCountOfOnes(sc.nextInt()));
        }
    }

    private static int getCountOfOnes(int n) {
        int count = 0;
        while (n != 0) {
            n = n & n - 1;
            count++;
        }
        return count;
    }
}
