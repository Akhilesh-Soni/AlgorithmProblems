package hackerearth;

import java.util.Scanner;

/**
 * Flipping a Bit (binary digit) means changing from 0 to 1 and from 1 to 0.
 * An operation OP(i) of bit flipping is defined on a binary number as follows:
 * Performing OP(i) would result into flipping of each ith bit from the starting (i>0).
 * An n-bit number is given as input and two operations OP(j) and OP(k) are applied on it one after the other.
 * Objective is to tell how many bits will remain the same after applying these two operations.
 */
public class FlippingBit {
    private static int flipTheBits(String s, int j, int k) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int j = sc.nextInt();

        int k = sc.nextInt();
        int count = flipTheBits(s, j, k);
        System.out.println();
    }
}
