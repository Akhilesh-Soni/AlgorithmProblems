package HeapProblems;

import java.util.Arrays;

/**
 * Created by akhileshsoni on 26-07-2017.
 */
public class Heap {
    private int capacity;
    private int size;
    private int[] items;

    public Heap() {
        this.capacity = 10;
        this.size = 0;
        this.items = new int[capacity];
    }

    public Heap(int[] items) {
        this.items = items;
        this.size = items.length;
        this.capacity = size;
    }

    public int[] getItems() {
        return items;
    }

    protected int getSize() {
        return size;
    }

    protected int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    protected int getLeftChild(int parentIndex) {
        return items[getLeftChildIndex(parentIndex)];
    }

    protected boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    protected int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    protected int getRightChild(int parentIndex) {
        return items[getRightChildIndex(parentIndex)];
    }

    protected boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    protected int getParentIndex(int childIndex) {
        return ((childIndex - 1) / 2);
    }

    protected int getParent(int childIndex) {
        return items[getParentIndex(childIndex)];
    }

    protected boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    protected void swapValuesOf(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    protected void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;

    }

    protected void ensureExtraCapacity() {
        if (size == capacity) {
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    protected int peek() {
        if (size == 0) {
            throw new EmptyHeapException();
        } else {
            return items[0];
        }
    }

    protected int poll() {
        if (size == 0) {
            throw new EmptyHeapException();
        } else {
            int data = items[0];
            items[0] = items[size - 1];
            size--;
            System.arraycopy(items, 0, items, 0, size);
            return data;
        }
    }

}
