package recursion;


import java.util.Scanner;

public class Fibonacci {
    private static long printSum(int number) {
        if (number <= 1) {
            return number;
        }
        return printSum(number - 1) + printSum(number - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.next());
        System.out.println(printSum(number));
    }
}
