package arrayproblems;


public class ConvertStringIntoIntegerRecursive {

    private static int convertIntoInteger(String s) {
        return convertIntoIntegerUtil(s, 0, 0);
    }

    private static int convertIntoIntegerUtil(String s, int index, int value) {
        if (index == s.length()) {
            return value;
        }
        value = value * 10 + Integer.parseInt("" + s.charAt(index));
        return convertIntoIntegerUtil(s, index + 1, value);
    }


    public static void main(String[] args) {
        String s = "1231";
        System.out.println(convertIntoInteger(s));
    }
}
