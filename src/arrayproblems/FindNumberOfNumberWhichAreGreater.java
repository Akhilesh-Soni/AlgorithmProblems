package arrayproblems;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by akhileshsoni on 18-04-2017.
 */
public class FindNumberOfNumberWhichAreGreater {
    private static List<Integer> returnAllNumberWhichAreGreaterThan(int number) {
        if ((number >= 0 && number <= 11) || isNumberInDescendingOrder(number)) {
            return Collections.emptyList();
        }
        List<Integer> list = findAllPermutationOfNumber(number);
        list = list.stream().filter(value -> value > number)
                .collect(Collectors.toList());

        return list;
    }

    private static List<Integer> findAllPermutationOfNumber(int number) {
        List<String> stringList = PermutationOfString.returnAllPermutationOfString(String.valueOf(number));
        return stringList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static boolean isNumberInDescendingOrder(int number) {
        String temp = "" + number;
        for (int i = 0; i < temp.length() - 1; i++) {
            if (temp.charAt(i) > temp.charAt(i + 1)) {
                continue;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 123;
        List<Integer> integers = returnAllNumberWhichAreGreaterThan(number);
        System.out.println("Total number that are greter than the number = " + integers.stream().count());
        integers.forEach(System.out::println);
    }
}
