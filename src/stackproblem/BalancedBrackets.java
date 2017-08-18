package stackproblem;

import java.util.Scanner;
import java.util.Stack;

/**
 * For each string, print whether or not the string of brackets is balanced on a new line.
 * If the brackets are balanced, print YES; otherwise, print NO.
 * <p>
 * Sample Input
 * <p>
 * 3 <br></br>
 * {[()]}<br></br>
 * {[(])}<br></br>
 * {{[[(())]]}}<br></br>
 * Sample Output<br></br>
 * YES<br></br>
 * NO<br></br>
 * YES<br></br>
 */
public class BalancedBrackets {
    private static boolean isBracketsAreBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        int i = 0;
        while (flag && i < s.length()) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        flag = false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        flag = false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        flag = false;
                    }
                    break;

            }
            i++;
        }
        return stack.isEmpty() && i == s.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        for (int i = 0; i < queries; i++) {
            String s = sc.next();
            boolean flag = isBracketsAreBalanced(s);
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
