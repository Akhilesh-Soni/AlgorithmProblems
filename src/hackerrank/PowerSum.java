package hackerrank;

import java.util.Scanner;

/**
 * Created by akhileshsoni on 18-06-2017.
 */
public class PowerSum {
    private static int findNumberOfWaysToRepresentTheGivenNumber(int n, int power) {
        return findNumberOfWaysToRepresentTheGivenNumberUtil(n, power, 1, 0, 0);
    }

    private static int findNumberOfWaysToRepresentTheGivenNumberUtil(int n, int power, int count, int sum, int total) {
        if (Math.pow(count, power) > n) {
            return 0;
        } else if (sum == n) {
            total++;
        }
        sum += Math.pow(count, power);
        findNumberOfWaysToRepresentTheGivenNumberUtil(n, power, ++count, sum, total);
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int power = sc.nextInt();

        System.out.println(findNumberOfWaysToRepresentTheGivenNumber(n, power));
    }
}
