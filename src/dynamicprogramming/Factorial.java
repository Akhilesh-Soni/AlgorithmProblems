package dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Given an integer N, print the factorial of the N (mod 10^9+7).
 * <p>
 * Input:
 * First line contains one integer, T, number of test cases.
 * Each test case contains one integer N.
 * <p>
 * Output:
 * For each test case you need to print the factorial of N (mod 10^9+7).
 */
public class Factorial {
    private static BigInteger findFactorial(int n, BigInteger[] array) {
        if (array[n] != null) {
            return array[n];
        }
        BigInteger val = BigInteger.valueOf(n).multiply(findFactorial(n - 1, array));
        array[n] = val;
        return array[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        BigInteger array[] = new BigInteger[1_00_000];
        array[0] = BigInteger.ONE;
        array[1] = BigInteger.ONE;
        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            BigInteger output = findFactorial(n, array);
            System.out.println(output.mod(BigInteger.valueOf(1000000007)).longValue());
        }
    }
}
