package arrayproblems;

/**
 * Created by akhileshsoni on 13-04-2017.
 */
public class SpiralArray {

    private static void printMatrixInSpiralManner(int[][] matrix) {
        printMatrixInSpiralMannerUtil(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, 0);
    }

    private static void printMatrixInSpiralMannerUtil(int[][] matrix, int row,
                                                      int col, int m, int n, int count) {
        int i, j, k, l;
        checkIfAllNumberPrinted(count, m, n);
        for (i = row; i <= n - row; i++) {
            count++;
            System.out.print(matrix[row][i] + " ");
        }
        i--;
        for (j = col + 1; j <= m - col; j++) {
            count++;
            System.out.print(matrix[j][i] + " ");
        }
        j--;
        for (k = i - 1; k >= col; k--) {
            count++;
            System.out.print(matrix[j][k] + " ");
        }
        k++;
        for (l = j - 1; l >= row + 1; l--) {
            count++;
            System.out.print(matrix[l][k] + " ");
        }
        printMatrixInSpiralMannerUtil(matrix, ++row, ++col, m, n, count);
    }

    private static void checkIfAllNumberPrinted(int count, int m, int n) {
        if (count == (m + 1) * (n + 1)) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}};
        printMatrixInSpiralManner(matrix);
    }
}
