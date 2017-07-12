package arrayproblems;

/**
 * Created by akhileshsoni on 13-04-2017.
 */
public class SpiralArray {

    private static void printMatrixInSpiralManner(int[][] matrix) {
        printMatrixInSpiralMannerUtil(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private static void printMatrixInSpiralMannerUtil(int[][] matrix, int rowIterator,
                                                      int colIterator, int rowLength, int colLength) {
        int i, j, k, l;
        if (rowIterator < rowLength && colIterator < colLength) {
            for (i = colIterator; i < colLength - colIterator; i++) {
                System.out.print(matrix[colIterator][i] + " ");
            }
            for (j = rowIterator; j < rowLength - rowIterator; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            for (k = colLength - colIterator - 1; k >= colIterator; k--) {
                System.out.print(matrix[rowIterator + 1][k] + " ");
            }
            for (l = rowLength - rowIterator - 1; l >= rowIterator + 1; l--) {
                System.out.print(matrix[l][rowIterator] + " ");
            }
            printMatrixInSpiralMannerUtil(matrix, ++rowIterator, ++colIterator, rowLength, colLength);
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3},
                {6, 7, 8},
                {9, 10, 11}};
        printMatrixInSpiralManner(matrix);
    }
}
