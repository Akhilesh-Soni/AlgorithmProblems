package stackproblem;

import java.util.Scanner;
import java.util.Stack;

/**
 * You have an empty sequence, and you will be given  queries. Each query is one of these three types:
 * 1 x  -Push the element x into the stack.
 * 2    -Delete the element present at the top of the stack.
 * 3    -Print the maximum element in the stack.
 */
public class MaximumElement {
    private static void performOperationOnStack(Stack<Integer> stack, Scanner sc, int operationType) {

        switch (operationType) {
            case 1:
                int value = sc.nextInt();
                stack.push(value);
                break;
            case 2:
                stack.pop();
                break;
            case 3:
                final int[] max = {Integer.MIN_VALUE};
                stack.forEach(data -> {
                    if (max[0] < data) {
                        max[0] = data;
                    }
                });
                System.out.println(max[0]);
                break;

        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        for (int i = 0; i < queries; i++) {
            performOperationOnStack(stack, sc, sc.nextInt());
        }
    }
}
