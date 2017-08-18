package treeproblem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * You are given
 * N
 * N distinct numbers in the form of an array Arri
 * You can form a Binary Search Tree(BST) by inserting them in the order they are given.
 * Now find the number of different permutations of the array,
 * so that the BST formed in each permutation is same as that of the given
 * array(including the given permutation). As the number can be large, output modulo(10^9+7)
 */
public class WaysOfBSTWithoutCreatingBST {
    static BigInteger modValue = new BigInteger("1000000007");
    static BigInteger[] series = new BigInteger[1001];

    private static long findWaysOfBST(ArrayList<Long> list) {

        if (list.size() <= 1) return 1;

        ArrayList<Long> leftChild = new ArrayList<>();
        ArrayList<Long> rightChild = new ArrayList<>();

        long value = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < value)
                leftChild.add(list.get(i));
            else
                rightChild.add(list.get(i));
        }
        BigInteger value1 = BigInteger.valueOf(findWaysOfBST(leftChild));
        BigInteger value2 = BigInteger.valueOf(findWaysOfBST(rightChild));
        int a = leftChild.size(), b = rightChild.size();
        BigInteger value3 = (series[a + b].divide(series[a])).divide(series[b]);

        BigInteger answer = value1.multiply(value2);
        answer = answer.multiply(value3);
        answer = answer.mod(modValue);
        return answer.longValue();
    }

    public static void main(String args[]) throws Exception {

        //BigInteger[] series = new BigInteger[1001];
        series[0] = BigInteger.ONE;
        series[1] = BigInteger.ONE;

        for (int i = 2; i <= 1000; i++) {
            series[i] = series[i - 1].multiply(BigInteger.valueOf(i));
        }

        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = s.nextInt();
            ArrayList<Long> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                long val;
                val = s.nextLong();
                list.add(val);
            }
            long answer = findWaysOfBST(list);
            System.out.println(answer);
        }
    }
}
