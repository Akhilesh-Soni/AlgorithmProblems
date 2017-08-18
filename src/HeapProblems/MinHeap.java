package HeapProblems;

/**
 * Created by akhileshsoni on 27-07-2017.
 */
public class MinHeap extends Heap {

    public MinHeap() {
        super();
    }

    public MinHeap(int[] items) {
        super(items);
    }

    public void buildMinHeap() {
        int len = getItems().length - 1;
        for (int i = ((len / 2) - 1); i >= 0; i--) {
            heapifyDown(getItems(), i);
        }
    }
    public int peek(){
        return super.peek();
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
        while (hasParent(index) && getParent(index) > getItems()[index]) {
            swapValuesOf(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(int[] arr) {
        heapifyDown(arr, 0);
    }

    private void heapifyDown(int[] arr, int i) {
        int smallestIndex = i;
        if (hasLeftChild(i) && getLeftChild(i) < arr[i]) {
            smallestIndex = getLeftChildIndex(i);
        }
        if (hasRightChild(i) && getRightChild(i) < arr[smallestIndex]) {
            smallestIndex = getRightChildIndex(i);
        }
        if (smallestIndex != i) {
            swapValuesOf(i, smallestIndex);
            heapifyDown(arr, smallestIndex);
        }
    }

    //It will sort the array in descending order
    private void heapSort() {
        buildMinHeap();
        int[] items = getItems();
        heapSortUtil(items, items.length - 1);
    }

    private void heapSortUtil(int[] arr, int len) {
        if (len <= 0) {
            return;
        }
        int data = this.poll();
        arr[len] = data;
        heapSortUtil(arr, len - 1);
    }

    public static void main(String[] args) {

        int arr[] = {4, 5, 1, 6, 7, 3, 2};
        MinHeap minHeap = new MinHeap(arr);
        for (int i : arr) {
            System.out.print(i + "    ");
        }
        System.out.println();
        minHeap.heapSort();
        for (int i : arr) {
            System.out.print(i + "    ");
        }
    }
}
