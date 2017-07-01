package hackerrank;

import java.util.Scanner;

public class DifferenceBetweenDiagonals {
    private static int findDifferenceOfDiagonals(int n, int[][] matrix) {
        int sumOfDiagonal1 = 0;
        int sumOfDiagonal2 = 0;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            sumOfDiagonal1 += matrix[i][i];
        }
        for (int i = 0; i < n; i++) {
            sumOfDiagonal2 += matrix[i][j];
            j--;
        }
        return Math.abs(sumOfDiagonal1 - sumOfDiagonal2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(findDifferenceOfDiagonals(n, matrix));
    }
}
