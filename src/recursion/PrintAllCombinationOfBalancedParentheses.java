package recursion;

/**
 * Created by akhileshsoni on 25-07-2017.
 */
public class PrintAllCombinationOfBalancedParentheses {
    private static void printAllCombinationOfBalancedParentheses(int n) {
        printAllCombinationOfBalancedParenthesesUtil(new char[100], 0, n, 0, 0);
    }

    private static void printAllCombinationOfBalancedParenthesesUtil(char[] s, int pos, int n,
                                                                     int open, int close) {
        if (close == n) {
            System.out.println(s);
        } else {
            if (open > close) {
                s[pos] = '}';
                printAllCombinationOfBalancedParenthesesUtil(s, pos + 1, n, open, close + 1);
            }
            if (open < n) {
                s[pos] = '{';
                printAllCombinationOfBalancedParenthesesUtil(s, pos + 1, n, open + 1, close);
            }
        }
    }

    public static void main(String[] args) {
        printAllCombinationOfBalancedParentheses(3);
    }

}
