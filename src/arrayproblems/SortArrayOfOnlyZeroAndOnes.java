package arrayproblems;


public class SortArrayOfOnlyZeroAndOnes {

    private static void segregateZerosAndOnes(int[] a) {
        int forwardPointer = 0;
        int backwardPointer = a.length - 1;
        while (forwardPointer < backwardPointer) {
            if (a[forwardPointer] == 0)
                forwardPointer++;
            if (a[backwardPointer] == 1)
                backwardPointer--;
            if (a[forwardPointer] == 1) {
                a[forwardPointer] = 0;
                a[backwardPointer] = 1;
                forwardPointer++;
                backwardPointer--;
            }
        }

    }

    public static void main(String[] args) {
        int a[] = {0, 0, 1, 1, 1, 0, 1, 0, 1};
        segregateZerosAndOnes(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
