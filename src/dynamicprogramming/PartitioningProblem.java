package dynamicprogramming;

/**
 * Created by akhileshsoni on 16-07-2017.
 */
public class PartitioningProblem {
    // Returns true if arr[] can be partitioned in two subsets of
    // equal sum, otherwise false
    static boolean findPartition(int arr[], int n) {
        int sum = 0;
        int i, j;

        // Caculcate sun of all elements
        for (i = 0; i < n; i++)
            sum += arr[i];

        if (sum % 2 != 0)
            return false;

        boolean part[][] = new boolean[sum / 2 + 1][n + 1];

        // initialize top row as true
        for (i = 0; i <= n; i++)
            part[0][i] = true;

        // initialize leftmost column, except part[0][0], as 0
        for (i = 1; i <= sum / 2; i++)
            part[i][0] = false;

        // Fill the partition table in botton up manner
        for (i = 1; i <= sum / 2; i++) {
            for (j = 1; j <= n; j++) {
                part[i][j] = part[i][j - 1];
                if (i >= arr[j - 1])
                    part[i][j] = part[i][j] ||
                            part[i - arr[j - 1]][j - 1];
            }
        }

        // uncomment this part to print table
        for (i = 0; i <= sum / 2; i++) {
            for (j = 0; j <= n; j++)
                System.out.print(part[i][j] + "\t");
            System.out.println();
        }
        int length = findLengthOfSubPartition(part);

        return part[sum / 2][n];
    }

    private static int findLengthOfSubPartition(boolean[][] part) {
        int i = part[0].length - 1;
        int j;
        for (j = part.length - 1; j > 0; j--) {
            if (!part[i][j]) {
                break;
            }
        }
        return j;
    }

    /*Driver function to check for above function*/
    public static void main(String[] args) {
        int arr[] = {0, 2, 3, 2, 3};
        int n = arr.length;
        if (findPartition(arr, n) == true)
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println("Can not be divided into two subsets of equal sum");

    }
}
