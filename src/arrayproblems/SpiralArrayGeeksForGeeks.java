package arrayproblems;

/**
 * Created by akhileshsoni on 13-04-2017.
 */
public class SpiralArrayGeeksForGeeks {

    private static void printMatrixInSpiralManner(int[][] matrix) {
        printMatrixInSpiralMannerUtil(matrix, matrix.length, matrix[0].length);
    }

    private static void printMatrixInSpiralMannerUtil(int[][] matrix, int rowLength, int colLength) {
        int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */

        while (k < rowLength && l < colLength) {
            // Print the first row from the remaining rows
            for (i = l; i < colLength; ++i) {
                System.out.print(matrix[k][i] + " ");
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < rowLength; ++i) {
                System.out.print(matrix[i][colLength - 1] + " ");
            }
            colLength--;

            // Print the last row from the remaining rows */
            if (k < rowLength) {
                for (i = colLength - 1; i >= l; --i) {
                    System.out.print(matrix[rowLength - 1][i] + " ");
                }
                rowLength--;
            }

            // Print the first column from the remaining columns */
            if (l < colLength) {
                for (i = rowLength - 1; i >= k; --i) {
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        printMatrixInSpiralManner(matrix);
    }
}
