package dynamicprogramming;

/**
 * Created by akhileshsoni on 21-06-2017.
 */
class Knapsack {

    // A utility function that returns maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        for (i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                System.out.print(K[i][j] + " ");
            }
            System.out.println();
        }


        return K[n][W];
    }


    // Driver program to test above function
    public static void main(String args[]) {
     /*   int val[] = new int[]{38, 98, 3, 76, 9, 48};
        int wt[] = new int[]{53, 88, 78, 72, 30, 46};


        int val1[] = {45, 98, 3, 76, 70, 10};
        float wt1[] = {53.38f, 53.62f, 53.65f, 52.37f, 53.18f, 25.34f};

        int W = 81;
        int W1 = 81;*/

        int val[] = {15, 12, 5, 7};
        int wt[] = {2, 4, 3, 7};

        int n = val.length;
        int W1 = 7;
        System.out.println(knapSack(W1, wt, val, n));
    }
}
