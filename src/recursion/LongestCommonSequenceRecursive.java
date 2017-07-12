package recursion;


public class LongestCommonSequenceRecursive {

    private static int findTheLengthOfLongestCommonSequence(char[] str1, char[] str2) {
        return findTheLengthOfLongestCommonSequenceUtil(str1, str2, 0, 0);
    }

    private static int findTheLengthOfLongestCommonSequenceUtil(char[] str1, char[] str2,
                                                                int str1Iterator, int str2Iterator) {
        if (str1Iterator == str1.length || str2Iterator == str2.length) {
            return 0;
        } else if (str1[str1Iterator] == str2[str2Iterator]) {
            return 1 + findTheLengthOfLongestCommonSequenceUtil(str1, str2, ++str1Iterator, ++str2Iterator);
        } else {
            return Math.max(findTheLengthOfLongestCommonSequenceUtil(str1, str2, ++str1Iterator, str2Iterator),
                    findTheLengthOfLongestCommonSequenceUtil(str1, str2, str1Iterator, ++str2Iterator));
        }

    }

    public static void main(String[] args) {
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        System.out.println(findTheLengthOfLongestCommonSequence(str1.toCharArray(), str2.toCharArray()));
    }
}
