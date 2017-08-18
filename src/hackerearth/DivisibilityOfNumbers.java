package hackerearth;

import java.util.Scanner;

/**
 * HP is doing research in mathematics . After doing lots of research, she struck in a problem . She found four numbers n,a, b and c .Now, She wants to know how many number exists which are less than or equal to n and are divisible by a ,b or c .
 * <p>
 * Input : First line contains 't' denoting numbers of test cases
 * <p>
 * Next t lines contains 4 integers denoting n,a,b and c separated by space
 * <p>
 * Output : 't' lines containing the count of the numbers which are divisible a,b,c
 */
public class DivisibilityOfNumbers {

    private static int countNumberWhichAreDivisibleBy(long n, long a, long b, long c) {
        int count = 0;
        long min = findMinimumNumber(a, b, c);
        for (long i = min; i <= n; i++) {
            if (getNumber(a, i) == 0) {
                count++;
            } else if (getNumber(b, i) == 0) {
                count++;
            } else if (getNumber(c, i) == 0) {
                count++;
            }
        }
        return count;
    }

    private static long getNumber(long divisor, long dividend) {
        if (isDivisorPowerOfTwo(divisor)) {
            return fastModulo(dividend, divisor);
        } else {
            while (dividend >= divisor) {
                dividend -= divisor;
            }
            return dividend;
        }
    }

    public static long fastModulo(long dividend, long divisor) {
        return dividend & (divisor - 1);
    }

    private static boolean isDivisorPowerOfTwo(long divisor) {
        return divisor != 0 && ((divisor & (divisor - 1)) == 0);
    }


    private static long findMinimumNumber(long a, long b, long c) {
        return (a <= b) ? ((a <= c) ? a : c) : ((b <= c) ? b : c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        for (int i = 0; i < queries; i++) {
            long n = sc.nextInt();
            long a = sc.nextInt();
            long b = sc.nextInt();
            long c = sc.nextInt();
            long count = countNumberWhichAreDivisibleBy(n, a, b, c);
            System.out.println(count);
        }
    }
}
