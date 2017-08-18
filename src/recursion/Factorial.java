package recursion;

/**
 * Created by akhileshsoni on 31-07-2017.
 */
public class Factorial {

    private static int factorialOfNumber(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
            fact %= 1000000007;
        }
        return fact;
    }

    public static void main(String[] args) {
        System.out.println(factorialOfNumber(52));
    }
}
