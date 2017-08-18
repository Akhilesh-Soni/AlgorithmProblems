package arrayproblems;


import java.util.Scanner;

public class NumbersOfSetBitsOfANumber {
    private static long findMagicNumber(int[] array) {
        long magicNumber = 0;
        for (int i = 0; i < array.length; i++) {
            String binaryValue = Integer.toBinaryString(array[i]);
            int numberOfSetBits = countNumberOfSetBits(binaryValue);
            magicNumber += Math.pow(numberOfSetBits, i);
        }

        return magicNumber;
    }

    private static int countNumberOfSetBits(String binaryValue) {
        int count = 0;
        for (int i = 0; i < binaryValue.length(); i++) {
            if (binaryValue.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lengthOfArray = sc.nextInt();
        int array[] = new int[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(findMagicNumber(array));
    }
}
