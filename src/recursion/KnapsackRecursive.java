package recursion;

import java.util.HashMap;

/**
 * Created by akhileshsoni on 21-06-2017.
 */
/* A Naive recursive implementation of 0-1 KnapsackRecursive problem */
class KnapsackRecursive {

    private static HashMap<String, Integer> map = new HashMap();

    // A utility function that returns maximum of two integers
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    private static int knapSack(int W, int wt[], int val[], int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than KnapsackRecursive capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included

        else {
            int a = val[n] + knapSack(W - wt[n], wt, val, n - 1);
            map.put("" + wt[n], a);
            int b = knapSack(W, wt, val, n - 1);
            return max(a, b);
        }
    }


    // Driver program to test above function
    public static void main(String args[]) {
        int val[] = {12, 15, 20, 8};
        int wt[] = {4, 5, 2, 7};
        int W = 7;
        int n = val.length;
        int x = knapSack(W, wt, val, n - 1);
        System.out.println(x);
    }
}
