package hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Killjee and subsets
 * Killjee is playing with an array
 * a
 * a, which has
 * n
 * n integers. He is trying to encrypt this array as a single integer.
 * <p>
 * Let
 * l
 * l be the largest number in array
 * a
 * a. Then, the code for array
 * a
 * a is
 * ∑
 * l
 * j
 * =
 * 0
 * b
 * j
 * ∗
 * 31
 * j
 * ∑j=0lbj∗31j mod
 * 10
 * 9
 * +
 * 7
 * 109+7.
 * <p>
 * Here,
 * b
 * j
 * bj is the size of largest subset of array
 * a
 * a whose XOR is equal to j.If there exist no subset of array
 * a
 * a whose XOR is
 * j
 * j then
 * b
 * j
 * =
 * 0
 * bj=0.
 * <p>
 * INPUT CONSTRAINTS:
 * <p>
 * 1
 * ≤
 * n
 * ≤
 * 10
 * 4
 * 1≤n≤104
 * 1
 * ≤
 * a
 * i
 * ≤
 * 10
 * 3
 * 1≤ai≤103
 * <p>
 * INPUT FORMAT :
 * <p>
 * First line of input contains a single integer
 * n
 * n. Next line contains
 * n
 * n space separated integers, elements of array
 * a
 * a.
 * <p>
 * OUTPUT FORMAT :
 * <p>
 * Print a single integer code of the array
 * a
 * a.
 * <p>
 * Sample Input
 * 4
 * 1 2 3 4
 * Sample Output
 * 3755653
 * Explanation
 * Here,
 * b
 * [
 * 0
 * ]
 * =
 * 3
 * b[0]=3 as the subset
 * (
 * 1
 * ,
 * 2
 * ,
 * 3
 * )
 * (1,2,3) has xor value equal to
 * 0
 * 0.
 * <p>
 * b
 * [
 * 1
 * ]
 * b[1]=2, as the subset
 * (
 * 2
 * ,
 * 3
 * )
 * (2,3) has xor value equal to
 * 1
 * 1
 * <p>
 * b
 * [
 * 2
 * ]
 * b[2] =
 * 2
 * 2, as the subset
 * (
 * 1
 * ,
 * 3
 * )
 * (1,3) has xor value equal to
 * 2
 * 2
 * <p>
 * b
 * [
 * 3
 * ]
 * b[3]=
 * 2
 * 2, as the subset
 * (
 * 1
 * ,
 * 2
 * )
 * (1,2) has xor value equal to
 * 3
 * 3
 * b
 * [
 * 4
 * ]
 * b[4] =
 * 4
 * 4, as the subset
 * (
 * 1
 * ,
 * 2
 * ,
 * 3
 * ,
 * 4
 * )
 * (1,2,3,4) has xor value equal to
 * 0
 * 0.
 * <p>
 * Thus, the answer =
 * (
 * b
 * [
 * 0
 * ]
 * ×
 * 31
 * 0
 * )
 * +
 * (
 * b
 * [
 * 1
 * ]
 * ×
 * 31
 * 1
 * )
 * +
 * (
 * b
 * [
 * 2
 * ]
 * ×
 * 31
 * 2
 * )
 * +
 * (
 * b
 * [
 * 3
 * ]
 * ×
 * 31
 * 3
 * )
 * +
 * (
 * b
 * [
 * 4
 * ]
 * ×
 * 31
 * 4
 * )
 * (b[0]×310)+(b[1]×311)+(b[2]×312)+(b[3]×313)+(b[4]×314) Modulo
 * 10
 * 9
 * +
 * 7
 * 109+7 =
 * 3755653
 * 3755653 .
 */
public class KillJeeAndSubSetProblem {
    private static int solve(int[] arr_a) {
        int result = 0;
        int largest = findLargest(arr_a);
        ArrayList<ArrayList<Integer>> lists = getAllSubSets(arr_a);
        Map<Integer, Integer> xorMap = findXorValuesOfList(lists);
        for (int i = 0; i <= largest; i++) {
            if (xorMap.get(i) != null) {
                result += xorMap.get(i) * Math.pow(31, i);
            }
        }

        return result % 1000000007;
    }

    private static Map<Integer, Integer> findXorValuesOfList(ArrayList<ArrayList<Integer>> lists) {
        Map<Integer, Integer> map = new HashMap<>();
        lists.forEach(list -> {
            final int[] xor = {0};
            list.forEach(integer -> {
                xor[0] = xor[0] ^ integer;
            });
            if (map.get(xor[0]) == null) {
                map.put(xor[0], list.size());
            } else {
                if (map.get(xor[0]) < list.size()) {
                    map.put(xor[0], list.size());
                }
            }
        });
        return map;
    }

    private static int findLargest(int[] arr_a) {
        int max = Integer.MIN_VALUE;
        for (int i : arr_a) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int arr_a[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr_a[i] = sc.nextInt();
        }
        int result = solve(arr_a);
        System.out.println(result);
    }

    private static ArrayList<ArrayList<Integer>> getAllSubSets(int arr[]) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        int numberOfSubSets = 1 << arr.length;
        for (int i = 0; i < numberOfSubSets; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) > 0) {
                    list.add(arr[j]);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
