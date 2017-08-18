package HeapProblems;

/**
 * Created by akhileshsoni on 28-07-2017.
 */
public class MaxHeap extends Heap {

    public MaxHeap() {
        super();
    }

    public MaxHeap(int[] items) {
        super(items);
    }

    private void buildMaxHeap() {
        int length = getItems().length;
        for (int i = length / 2; i >= 0; i--) {
            heapifyDown(getItems(), i);
        }
    }

    public int peek() {
        return super.peek();
    }

    private void heapifyDown(int[] arr, int i) {
        int maximumIndex = i;
        if (hasLeftChild(i) && getLeftChild(i) > arr[i]) {
            maximumIndex = getLeftChildIndex(i);
        }
        if (hasRightChild(i) && getRightChild(i) > arr[maximumIndex]) {
            maximumIndex = getRightChildIndex(i);
        }
        if (maximumIndex != i) {
            swapValuesOf(i, maximumIndex);
            heapifyDown(arr, maximumIndex);
        }
    }


    private void heapSort() {
        buildMaxHeap();
        int[] items = getItems();
        heapSortUtil(items, items.length - 1);
    }

    public int poll() {
        int data = super.poll();
        heapifyDown(getItems());
        return data;
    }

    public void add(int item) {
        super.add(item);
        heapifyUp();
    }

    private void heapifyUp() {
        int index = getSize();
        while (hasParent(index) && getParent(index) < getItems()[index]) {
            swapValuesOf(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(int[] items) {
        heapifyDown(items, 0);
    }

    private void heapSortUtil(int[] arr, int len) {
        if (len <= 0) {
            return;
        }
        int data = poll();
        arr[len] = data;
        heapSortUtil(arr, len - 1);
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 1, 6, 7, 2, 3};
        MaxHeap maxHeap = new MaxHeap(arr);
        for (int i : arr) {
            System.out.print(i + "    ");
        }
        maxHeap.heapSort();
        System.out.println();
        for (int i : arr) {
            System.out.print(i + "    ");
        }
    }

}
