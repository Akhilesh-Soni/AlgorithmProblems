package hackerearth;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * Created by akhileshsoni on 06-08-2017.
 */
public class DestroyingBalls {
    private static boolean checkIfAllBallsCanBeDeleted(int[] arr_a) {
        boolean flag = true;
        Set<Integer> deletedBalls = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int val : arr_a) {
            stack.push(val);
        }
        while (!stack.isEmpty()) {
            int value = stack.peek();
            if (deletedBalls.contains(value)) {
                flag = false;
                break;
            } else {
                deletedBalls.add(value);
                while (!stack.isEmpty() && stack.peek()==value){
                    stack.pop();
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int len = sc.nextInt();
            int arr_a[] = new int[len + 1];
            for (int i_a = 0; i_a < len; i_a++) {
                arr_a[i_a] = sc.nextInt();
            }
            boolean bool = checkIfAllBallsCanBeDeleted(arr_a);
            if (bool) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
