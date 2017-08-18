package HeapProblems;

/**
 * Created by akhileshsoni on 26-07-2017.
 */
public class EmptyHeapException extends RuntimeException {
    public EmptyHeapException() {
        super("Heap is empty");
    }
}
