package hackerearth;

import java.util.Scanner;

/**
 * Killjee and superdromes (Lowe)
 * Killjee has recently read about superdromes. Superdromes are those numbers which are palindromic in both binary and decimal representation.
 * <p>
 * The number represented in binary representation will be up to its most significant bit which is 1.
 * <p>
 * For example, 2 will be represented as {10}, 6 will be represented as {110} and so on.
 * <p>
 * Now killjee ask you to find number of Superdromes less than or equal to n for given n.
 */
public class SuperdromeNumbers {
    private static void printSuperDromeNumbers(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (isPalindrome(i)) {
                if (palindrome(i)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean palindrome(int num) {
        int rev = 0;
        int number = num;
        while (num != 0) {
            rev = (rev << 1) | (num & 1);
            num = num >> 1;
        }
        return rev == number;
    }

    private static boolean isPalindrome(long x) {
        if (x < 0)
            return false;

        long rem, revX = 0;
        long temp = x;
        while (temp > 0) {
            rem = temp % 10;
            revX = revX * 10 + rem;
            temp = temp / 10;
        }
        return revX == x;
    }


    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int q = sc.nextInt();
            for (int i = 1; i <= q; i++) {
                int number = sc.nextInt();
                printSuperDromeNumbers(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
