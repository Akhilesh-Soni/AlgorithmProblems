package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by akhileshsoni on 18-06-2017.
 */
public class EncryptDecrypt {


    private static void checkIfTheNumberCanBeDecryptedOrNot(int[] arr, int number, int[] spf,
                                                            String[] cache) {
        boolean flag = false;
        int d = number;
        if (cache[number] != null) {
            System.out.println(cache[number]);
            return;
        }
        for (int i : arr) {
            if (i < number) {
                if (isNumberDivisibleBy(i, d)) {
                    do {
                        d = getTheDivisibleValue(i, d);
                        if (isNumberFactorOfOnlyTwoPrimeNumbers(d, spf)) {
                            flag = true;
                            break;
                        }
                    } while (isNumberDivisibleBy(i, d));
                }
            } else {
                break;
            }
            if (flag) {
                break;
            }
            d = number;
        }
        printOutput(number, cache, flag);

    }

    private static void printOutput(int number, String[] cache, boolean flag) {
        if (flag) {
            cache[number] = "YES";
            System.out.println("YES");
        } else {
            cache[number] = "NO";
            System.out.println("NO");
        }
    }

    private static boolean isNumberFactorOfOnlyTwoPrimeNumbers(int d, int[] spf) {
        int count = 0;
        while (d != 1) {
            if (count < 3) {
                count++;
                d = d / spf[d];
            } else {
                break;
            }
        }
        return count == 2;
    }

    private static int getTheDivisibleValue(int i, int number) {
        return i > 1 && number > 1 ? number / i : 0;
    }

    private static boolean isNumberDivisibleBy(int i, int number) {
        return i > 1 && number > 1 && number % i == 0;
    }

    private static void sieve(int spf[], int length) {
        spf[1] = 1;
        for (int i = 2; i < length; i++)

            // marking smallest prime factor for every
            // number to be itself.
            spf[i] = i;

        // separately marking spf for every even
        // number as 2
        for (int i = 4; i < length; i += 2)
            spf[i] = 2;

        for (int i = 3; i * i < length; i++) {
            // checking if i is prime
            if (spf[i] == i) {
                // marking SPF for all numbers divisible by i
                for (int j = i * i; j < length; j += i)

                    // marking spf[j] if it is not
                    // previously marked
                    if (spf[j] == j)
                        spf[j] = i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n];
        int spf[] = new int[1000000];
        String cache[] = new String[1000000];
        sieve(spf, 1000000);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < q; i++) {
            checkIfTheNumberCanBeDecryptedOrNot(arr, sc.nextInt(), spf, cache);
        }
    }
}
