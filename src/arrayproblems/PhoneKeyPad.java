package arrayproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by akhileshsoni on 13-04-2017.
 */
public class PhoneKeyPad {
    private static ArrayList<String> getAllPossibleWords(String input, Map<String, String> phoneKeyBoard) {
        return getAllPossibleWordsUtil(input, 0, phoneKeyBoard, new ArrayList<>());
    }

    private static ArrayList<String> getAllPossibleWordsUtil(final String input,
                                                             int index,
                                                             final Map<String, String> phoneKeyBoard,
                                                             final ArrayList<String> strings) {
        if (index == input.length()) {
            return strings;
        }
        String value = phoneKeyBoard.get("" + input.charAt(index));
        ArrayList<String> values = new ArrayList<>();
        if (strings.isEmpty()) {
            for (int i = 0; i < value.length(); i++) {
                strings.add("" + value.charAt(i));
            }
            values.addAll(strings);
        } else {
            for (String string : strings) {
                for (int i = 0; i < value.length(); i++) {
                    values.add(string + value.charAt(i));
                }
            }
        }
        return getAllPossibleWordsUtil(input, index + 1, phoneKeyBoard, values);
    }

    public static void main(String[] args) {
        Map<String, String> phoneKeyBoard = new HashMap<>();
        phoneKeyBoard.put("2", "abc");
        phoneKeyBoard.put("3", "def");
        phoneKeyBoard.put("4", "ghi");
        phoneKeyBoard.put("5", "jkl");
        phoneKeyBoard.put("6", "mno");
        phoneKeyBoard.put("7", "pqrs");
        phoneKeyBoard.put("8", "tuv");
        phoneKeyBoard.put("9", "wxyz");

        String input = "234";
        ArrayList<String> list = getAllPossibleWords(input, phoneKeyBoard);
        list.forEach(System.out::println);
    }


}
