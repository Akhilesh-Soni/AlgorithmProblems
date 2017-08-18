package treeproblem;

import java.math.BigInteger;
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
public class WaysOfBSTByCreatingBST {

    private static long findNumberOfPermutation(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.getLeft() == null && treeNode.getRight() == null) {
            return 1;
        }
        long leftNumber = findNumberOfPermutation(treeNode.getLeft());
        long rightNumber = findNumberOfPermutation(treeNode.getRight());

        if (leftNumber == 0) {
            return rightNumber;
        } else if (rightNumber == 0) {
            return leftNumber;
        }
        BigInteger totalNumberOfPermutation = BigInteger.valueOf(leftNumber * rightNumber);
        int numberOfLeftChild = findNumberOfChild(treeNode.getLeft());
        int numberOfRightChild = findNumberOfChild(treeNode.getRight());
        BigInteger factorialOfNumber1 = factorialOfNumber(numberOfLeftChild);
        BigInteger factorialOfNumber2 = factorialOfNumber(numberOfRightChild);
        BigInteger mulitipliedValue = (factorialOfNumber1.multiply(factorialOfNumber2));
        BigInteger interLeavings = (factorialOfNumber(numberOfLeftChild + numberOfRightChild)
                .divide(mulitipliedValue));
        BigInteger answer = totalNumberOfPermutation.multiply(interLeavings);
        return answer.mod(BigInteger.valueOf(1000000007)).longValue();
    }

    private static BigInteger factorialOfNumber(int number) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }


    private static int findNumberOfChild(TreeNode child) {
        if (child == null) {
            return 0;
        }
        return 1 + findNumberOfChild(child.getLeft()) + findNumberOfChild(child.getRight());
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int numberOfTestCases = sc.nextInt();
            long outputArray[] = new long[numberOfTestCases];
            for (int i = 0; i < numberOfTestCases; i++) {
                int lengthOfArray = sc.nextInt();
                int array[] = new int[lengthOfArray];
                for (int i1 = 0; i1 < lengthOfArray; i1++) {
                    array[i1] = sc.nextInt();
                }
                TreeNode treeNode = TreeNode.createBinarySearchTreeFromArray(array);
                long numberOfPermutation = findNumberOfPermutation(treeNode);
                outputArray[i] = numberOfPermutation;
            }
            for (long i : outputArray) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
