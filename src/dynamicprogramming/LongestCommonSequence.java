package dynamicprogramming;


public class LongestCommonSequence {
    private static int findTheLengthOfLongestCommonSequence(char[] str1, char[] str2) {
        int matrix[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }


    private static void printTheLongestCommonSequence(char[] str1, char[] str2) {
        int rowIterator, colIterator;
        int matrix[][] = new int[str1.length + 1][str2.length + 1];
        for (rowIterator = 1; rowIterator < matrix.length; rowIterator++) {
            for (colIterator = 1; colIterator < matrix[rowIterator].length; colIterator++) {
                if (str1[rowIterator - 1] == str2[colIterator - 1]) {
                    matrix[rowIterator][colIterator] = matrix[rowIterator - 1][colIterator - 1] + 1;
                } else {
                    matrix[rowIterator][colIterator] = Math.max(matrix[rowIterator][colIterator - 1],
                            matrix[rowIterator - 1][colIterator]);
                }
            }
        }

        for (rowIterator = 0; rowIterator < matrix.length; rowIterator++) {
            for (colIterator = 0; colIterator < matrix[rowIterator].length; colIterator++) {
                System.out.print(matrix[rowIterator][colIterator] + "\t");
            }
            System.out.println();
        }
        rowIterator = matrix.length - 1;
        colIterator = matrix[0].length - 1;
        while (rowIterator > 0) {
            if (matrix[rowIterator][colIterator] == matrix[rowIterator][colIterator - 1]) {
                colIterator--;
            } else if (matrix[rowIterator][colIterator] == matrix[rowIterator - 1][colIterator]) {
                rowIterator--;
            } else {
                System.out.println(str2[colIterator - 1]);
                rowIterator--;
                colIterator--;
            }
        }
    }

    public static void main(String[] args) {
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        System.out.println(findTheLengthOfLongestCommonSequence(str1.toCharArray(), str2.toCharArray()));
        printTheLongestCommonSequence(str1.toCharArray(), str2.toCharArray());
    }


}
