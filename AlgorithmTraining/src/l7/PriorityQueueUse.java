package l7;

import java.util.ArrayList;

public class PriorityQueueUse {

	public static ArrayList<Integer> findKMax(int a[], int k) {
	
		ArrayList<Integer> topK = new ArrayList<>();
		PriorityQueue<Integer> p = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			p.insertInMinHeap(a[i], a[i]);
		}
		
		for (int i = k; i < a.length; i++) {
			if (a[i] > p.min()) {
				p.removeMin();
				p.insertInMinHeap(a[i], a[i]);
			}
		}
		
		while (!p.isEmpty()) {
			topK.add(p.removeMin());
		}
		return topK;
	}
	
	public static ArrayList<Integer> findMin(int a[], int k){
		ArrayList<Integer> topk =  new ArrayList<>();
		PriorityQueue<Integer>p = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			p.insertInMaxHeap(a[i], a[i]);
		}
		
		for (int i = k; i < a.length; i++) {
			if(a[i]<p.min()){
				p.removeMax();
				p.insertInMaxHeap(a[i], a[i]);
			}
		}
		while (!p.isEmpty()) {
			topk.add(p.removeMax());			
		}
		return topk;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {5,4,3,2,1,8,9,7,6,11,10};
		int b[] = {1,2,3,4,5,6,7,8,9,10,11};
		ArrayList<Integer> heap = new ArrayList<>();
		heap.add(null);
//		for (int i : topK) {
//			System.out.println(i);
//		}
//		
		PriorityQueue<Integer> p = new PriorityQueue<>();
		for (int  j=0;j < a.length; j++) {
			p.heap.add(new Pair<Integer>(a[j], a[j]));
		}		
		for (int i = (a.length/2); i >=1; i--) {
			p.maxHeapify(p, i);
		}
	}

}
