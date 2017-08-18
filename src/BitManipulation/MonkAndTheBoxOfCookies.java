package BitManipulation;

import java.util.Scanner;

/**
 * Suzie came over to Monk's place today with a box of Monk's favorite cookies!
 * But Monk has to play a game with her in order to win the cookies.
 * Suzie takes out N balls from her bag, each ball having an integer on it. All the integers are 32-bit.
 * She places all these balls in a box and closes it.
 * The game starts by Monk choosing an integer from 0 to 31, representing a bit position.
 * It is called as Monk's chosen bit.
 * Post this, Suzie draws 1 balls from the box randomly and notes the integers on them.
 * The rule is simple, Monk wins if Monk's chosen bit is set in the binary representation of the drawn ball. Help Monk choose a bit that maximizes his probability of winning the game!
 * If there are multiple bit positions having the same probability, choose the smallest one.
 * <p>
 * Input:
 * The first line consists of an integer T. T test cases follow.
 * The first line of each testcase consists of an integer N.
 * In next N lines, each line will contain 1 integer denoting the integers on the ball.
 * <p>
 * Output:
 * For each testcase, print the answer in a single line.
 */
public class MonkAndTheBoxOfCookies {
    private static int getMostPromisingBitPosition(int[] arr) {
        int bitPosition = 0;
        int bits[] = new int[32];
        for (int number : arr) {
            for (int i = 0; i < bits.length; i++) {
                if (i < number) {
                    if ((number & (1 << i)) > 0) {
                        bits[i] += 1;
                    }
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < bits.length; i++) {
            if (bits[bitPosition] < bits[i]) {
                bitPosition = i;
            }
        }
        return bitPosition;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
            int bitPosition = getMostPromisingBitPosition(arr);
            System.out.println(bitPosition);
        }
    }
}
