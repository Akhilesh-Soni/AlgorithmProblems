package arrayproblems;

import java.util.HashMap;

/**
 * Created by akhileshsoni on 14-04-2017.
 */
public class LargestSubstringWithOnlyTwoCharacterRepetition {

    private static String findLargestSubstringWithOnlyTwoCharacterRepetition(String input) {
        return findLargestSubstringWithOnlyTwoCharacterRepetitionUtil(input, input.length() - 1);
    }

    private static String findLargestSubstringWithOnlyTwoCharacterRepetitionUtil(String input, int length) {
        int index = 0;
        String largestSubstring = "";
        String currentSubstring = "";
        while (index <= length) {
            char c = input.charAt(index);
            if (isThereMoreThanTwoTypeOfChar(currentSubstring, c)) {
                if (currentSubstring.length() > largestSubstring.length()) {
                    largestSubstring = currentSubstring;
                }
                currentSubstring = extractNewCurrentSubstring(currentSubstring);
            }
            currentSubstring += c;
            index++;
        }
        if (currentSubstring.length() > largestSubstring.length()) {
            largestSubstring = currentSubstring;
        }
        return largestSubstring;
    }

    private static String extractNewCurrentSubstring(String currentSubstring) {
        String temp = "";
        for (int i = currentSubstring.length() - 1; i > 0; i--) {
            if (currentSubstring.charAt(i) == currentSubstring.charAt(i - 1)) {
                temp += currentSubstring.charAt(i);
            } else {
                temp += currentSubstring.charAt(i);
                break;
            }
        }
        return temp;

    }

    private static boolean isThereMoreThanTwoTypeOfChar(String currentSubstring, char c) {
        if (currentSubstring.length() == 1) {
            return false;
        } else if (currentSubstring.contains("" + c)) {
            return false;
        } else {
            HashMap<Character, Void> map = new HashMap<>();
            String temp = currentSubstring + c;
            for (int i = 0; i < temp.length(); i++) {
                map.put(temp.charAt(i), null);
            }
            if (map.size() > 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "missiiippii";
        System.out.println(findLargestSubstringWithOnlyTwoCharacterRepetition(input));
    }
}
