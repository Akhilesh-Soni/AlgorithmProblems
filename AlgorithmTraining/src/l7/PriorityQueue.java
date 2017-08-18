package l7;

import java.util.ArrayList;

public class PriorityQueue<T> {

	ArrayList<Pair<T>> heap;
	
	public PriorityQueue() {
		heap = new ArrayList<>();
		heap.add(null);
	}
	
	public int size() {
		return heap.size() - 1;
	}
	
	public boolean isEmpty() {
		if (heap.size() == 1) {
			return true;
		}
		return false;
	}
	
	public T min() {
		if (heap.size() == 1) {
			return null;
		}	
		return heap.get(1).value;
	}
	
	
	public void insertInMinHeap(int priority, T value) {
		Pair<T> newPair = new Pair<>(priority, value);
		heap.add(newPair);
		int currentChildIndex = heap.size() - 1;
		int parentIndex = currentChildIndex/2;
		
		while (currentChildIndex > 1) {
			if (heap.get(currentChildIndex).priority >= heap.get(parentIndex).priority) {
				break;
			} else {
				Pair<T> temp = heap.get(currentChildIndex);
				heap.set(currentChildIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				currentChildIndex = parentIndex;
				parentIndex = currentChildIndex/2;
			}
		}		
	}
	
	public void insertInMaxHeap(int priority,T value) {
		Pair<T>newPair = new Pair<>(priority, value);
		heap.add(newPair);
		int currentChildIndex = heap.size()-1;
		int parentIndex = currentChildIndex/2;
		while (currentChildIndex>1) {
			/*
			 * check if current value's priority is smaller or not if greater
			 * than swap to create Max priority
			 */		
			if(heap.get(currentChildIndex).priority <= heap.get(parentIndex).priority){
				break;
			}
			else {
				Pair<T> tempPair = heap.get(currentChildIndex);
				heap.set(currentChildIndex, heap.get(parentIndex));
				heap.set(parentIndex, tempPair);
				currentChildIndex = parentIndex;
				parentIndex = currentChildIndex/2;
			}
		}
		for (Pair<T> node : heap) {
			if(node == null){
				continue;
			}
			System.out.print(node.value);
		}
		System.out.print("\n");
	}
	
	public T removeMin() {
		if (heap.size() == 1) {
			return null;
		}
		
		T retVal = heap.get(1).value;
		
		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		int currentNodeIndex = 1;
		int leftIndex = 2 * currentNodeIndex;
		int rightIndex = leftIndex + 1;
		
		while (leftIndex < heap.size()) {
			int minIndex = currentNodeIndex;
			if (heap.get(leftIndex).priority < heap.get(minIndex).priority) {
				minIndex = leftIndex;
			}
			
			if (rightIndex < heap.size()) {
				if (heap.get(rightIndex).priority < heap.get(minIndex).priority) {
					minIndex = rightIndex;
				}
			}
			
			if (minIndex == currentNodeIndex) {
				break;
			} else {
				Pair<T> temp = heap.get(minIndex);
				heap.set(minIndex, heap.get(currentNodeIndex));
				heap.set(currentNodeIndex, temp);
				currentNodeIndex = minIndex;
				leftIndex = 2 * currentNodeIndex;
				rightIndex = leftIndex + 1;
			}
		}
		return retVal;
	}
	
	public T removeMax() {
		if(heap.size() == 1){
			return null;
		}
		
		T retVal = heap.get(1).value;
		heap.set(1, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int currentNodeIndex = 1;
		int leftChildIndex = 2*currentNodeIndex;
		int rightChildIndex = leftChildIndex+1;
		
		while (leftChildIndex < heap.size()) {
			int maxIndex =  currentNodeIndex;
			if(heap.get(leftChildIndex).priority > heap.get(maxIndex).priority){
				maxIndex = leftChildIndex;
			}
			if(rightChildIndex < heap.size()){
				if(heap.get(rightChildIndex).priority > heap.get(maxIndex).priority){
					maxIndex = rightChildIndex;
				}
			}
			
			if(currentNodeIndex == maxIndex){
				break;
			}else {
				Pair<T> tempPair = heap.get(maxIndex);
				heap.set(maxIndex, heap.get(currentNodeIndex));
				heap.set(currentNodeIndex, tempPair);
				
				currentNodeIndex = maxIndex;
				leftChildIndex = 2*currentNodeIndex;
				rightChildIndex = leftChildIndex+1;
			}
		}
		return retVal;
	}
	
	public void maxHeapify(PriorityQueue<T> p,int i) {
		if(p.heap.size() == 1){
			return;
		}
		
		int currentNodeIndex = i;
		int leftChildIndex = 2*currentNodeIndex;
		int rightChildIndex = leftChildIndex+1;
		
		while (leftChildIndex < p.heap.size()) {
			int maxIndex =  currentNodeIndex;
			if(p.heap.get(leftChildIndex).priority > p.heap.get(maxIndex).priority){
				maxIndex = leftChildIndex;
			}
			if(rightChildIndex < p.heap.size()){
				if(p.heap.get(rightChildIndex).priority > p.heap.get(maxIndex).priority){
					maxIndex = rightChildIndex;
				}
			}
			
			if(currentNodeIndex == maxIndex){
				break;
			}else {
				Pair<T> tempPair = p.heap.get(maxIndex);
				p.heap.set(maxIndex, p.heap.get(currentNodeIndex));
				p.heap.set(currentNodeIndex, tempPair);
				
				currentNodeIndex = maxIndex;
				leftChildIndex = 2*currentNodeIndex;
				rightChildIndex = leftChildIndex+1;
			}
		}
		
		T retVal = p.heap.get(1).value;
		p.heap.set(1, p.heap.get(p.heap.size()-1));
		p.heap.remove(p.heap.size()-1);
		System.out.print("\n"+retVal);
	}
	
}
