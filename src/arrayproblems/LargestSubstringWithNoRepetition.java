package arrayproblems;

/**
 * Created by akhileshsoni on 14-04-2017.
 */
public class LargestSubstringWithNoRepetition {
    private static String findLargestSubstring(String input) {
        return findLargestSubstringUtil(input, input.length() - 1);
    }

    private static String findLargestSubstringUtil(String input, int length) {
        int index = 0;
        String largestSubstring = "";
        String currentSubstring = "";
        while (index <= length) {
            char c = input.charAt(index);
            if (isCharactorPresent(currentSubstring, c)) {
                if (currentSubstring.length() > largestSubstring.length()) {
                    largestSubstring = currentSubstring;
                }
                currentSubstring = "";
            }
            currentSubstring += c;
            index++;
        }
        if (currentSubstring.length() > largestSubstring.length()) {
            largestSubstring = currentSubstring;
        }
        return largestSubstring;
    }

    private static boolean isCharactorPresent(String currentSubstring, char c) {
        return currentSubstring.contains("" + c);
    }

    public static void main(String[] args) {
        String input = "abcdcefgh";
        System.out.println(findLargestSubstring(input));
    }
}
