package hackerearth;

import java.util.Scanner;

/**
 * Given an integer array
 * A
 * A of size
 * N
 * N, you need to perform
 * 2
 * 2 operations over this array :
 * <p>
 * 0
 * <p>
 * L
 * <p>
 * R
 * 0 L R : Find and print
 * A
 * [
 * L
 * ]
 * A[L] xor
 * A
 * [
 * L
 * +
 * 1
 * ]
 * A[L+1] xor
 * A
 * [
 * L
 * +
 * 2
 * ]
 * A[L+2] ... xor
 * A
 * [
 * R
 * ]
 * A[R]
 * <p>
 * 1
 * <p>
 * X
 * <p>
 * Y
 * 1 X Y : Update the value of the
 * X
 * t
 * h
 * Xth element of array
 * A
 * A, i.e
 * A
 * [
 * X
 * ]
 * A[X] to
 * (
 * A
 * [
 * X
 * ]
 * (A[X] XOR
 * Y
 * Y) . That is, after the update the value of the element shall be (
 * A
 * [
 * X
 * ]
 * A[X] XOR
 * Y
 * Y).
 * <p>
 * Can you do it ?
 */
public class XORTest {

    private static void performXOROperation(int[] arr, int opType, int operand1, int operand2) {
        switch (opType) {
            case 0:
                operand1--;
                operand2--;
                int output = 0;
                for (int i = operand1; i <= operand2; i++) {
                    output ^= arr[i];
                    if (output == 0 && i != operand2) {
                        output = arr[operand2];
                        break;
                    }
                }
                System.out.println(output);
                break;
            case 1:
                operand1--;
                arr[operand1] = arr[operand1] ^ operand2;
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int queries = sc.nextInt();
        for (int i = 0; i < queries; i++) {
            int opType = sc.nextInt();
            int operand1 = sc.nextInt();
            int operand2 = sc.nextInt();
            performXOROperation(arr, opType, operand1, operand2);
        }
    }
}
