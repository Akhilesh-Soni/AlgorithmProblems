package hackerrank;


import java.util.Scanner;

public class PlusMinus {

    private static float[] findHowMuchNumbersArePlusAndMinusAndZeros(int n, int[] array) {
        float result[] = new float[3];
        int positiveNumbers = 0, negativeNumbers = 0, zeros = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] > 0) {
                positiveNumbers++;
            } else if (array[i] < 0) {
                negativeNumbers++;
            } else {
                zeros++;
            }
        }
        result[0] = (float) positiveNumbers / n;
        result[1] = (float) negativeNumbers / n;
        result[2] = (float) zeros / n;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        float[] result = findHowMuchNumbersArePlusAndMinusAndZeros(n, array);
        for (int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }
    }
}
