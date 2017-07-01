package arrayproblems;

import java.util.ArrayList;

/**
 * Created by akhileshsoni on 13-04-2017.
 */
public class PermutationOfString {

    private static void printAllPermutationOfString(String input) {
        printAllPermutationOfStringUtil(input, 0, input.length() - 1);
    }

    private static void printAllPermutationOfStringUtil(String input, int l, int r) {
        if (l == r) {
            System.out.println(input);
        }
        for (int i = l; i <= r; i++) {
            input = swap(input, l, i);
            printAllPermutationOfStringUtil(input, l + 1, r);
            input = swap(input, l, i);
        }
    }

    private static ArrayList<String> returnAllPermutationOfStringUtil(String input, int l, int r) {
        ArrayList<String> list = new ArrayList<>();
        if (l == r) {
            list.add(input);
            return list;
        }
        for (int i = l; i <= r; i++) {
            input = swap(input, l, i);
            list.addAll(returnAllPermutationOfStringUtil(input, l + 1, r));
            input = swap(input, l, i);
        }
        return list;
    }

    private static String swap(String input, int l, int i) {
        char temp;
        char[] chars = input.toCharArray();
        temp = chars[l];
        chars[l] = chars[i];
        chars[i] = temp;
        return String.valueOf(chars);
    }

    public static ArrayList<String> returnAllPermutationOfString(String input) {
        return returnAllPermutationOfStringUtil(input, 0, input.length() - 1);
    }

    public static void main(String[] args) {
        String input = "abc";
        //printAllPermutationOfString(input);
        returnAllPermutationOfString(input).forEach(System.out::println);

    }


}
