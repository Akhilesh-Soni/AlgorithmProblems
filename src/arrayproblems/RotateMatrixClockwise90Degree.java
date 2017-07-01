package arrayproblems;

public class RotateMatrixClockwise90Degree {
    private static void rotateMatrix(int[][] matrix) {
        rotateMatrixUtil(matrix, 0, matrix.length - 1, 0);
    }

    private static void rotateMatrixUtil(int[][] matrix, int i, int j, int cycleCount) {
        if (cycleCount != matrix.length / 2) {
            int lastIndex = matrix.length - 1 - cycleCount;
            while (i < lastIndex) {
                int temp = matrix[cycleCount][i];
                matrix[cycleCount][i] = matrix[j][cycleCount];
                matrix[j][cycleCount] = matrix[lastIndex][j];
                matrix[lastIndex][j] = matrix[i][lastIndex];
                matrix[i][lastIndex] = temp;
                i++;
                j--;
            }
            cycleCount++;
            i = cycleCount;
            j = lastIndex;
            rotateMatrixUtil(matrix, i, j, cycleCount);
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        System.out.println("Matrix before rotating");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        rotateMatrix(matrix);
        System.out.println("Matrix after rotating");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

}
