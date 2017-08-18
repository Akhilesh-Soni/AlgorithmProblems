package BitManipulation;

import java.util.Scanner;

/**
 * Created by akhileshsoni on 29-07-2017.
 */
public class CheckIfNumberIsPowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n != 0 && ((n & (n - 1)) == 0));
    }
}
