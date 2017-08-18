package l6;

import java.util.ArrayList;

public class Map<K,V> {
	ArrayList<HashNode<K,V>> bucket;
	int numElements;
	int numBuckets;
	
	public Map() {
		numBuckets = 10;
		bucket = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			bucket.add(null);
		}
	}
	
	public int size() {
		return numElements;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	private int hashFunction(K key) {
		int hash = key.hashCode();
		return hash % numBuckets;
	}
	
	public void put(K key, V value) {
		int bucketIndex = hashFunction(key);
		HashNode<K, V> head = bucket.get(bucketIndex);
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		head = bucket.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = head;
		bucket.set(bucketIndex, newNode);
		numElements++;
	}
	
	public boolean find(K key) {
		int bucketIndex = hashFunction(key);
		HashNode<K, V>head = bucket.get(bucketIndex);
		while(head !=null )
		{
			if(head.key.equals(key)){
				return true;
			}
			head = head.next;
		}
		return false;
	}
	
	public boolean remove(K key) {
		int bucketIndex = hashFunction(key);
		HashNode<K, V>head = bucket.get(bucketIndex);
		if(head == null){
			return false;
		}
		if(head.key.equals(key)){
			bucket.set(bucketIndex, head.next);
			return true;
		}
		HashNode<K, V>prev = head;
		HashNode<K, V>current = head.next;
		while (current!=null) {
			if(current.key.equals(key)){
				prev.next = current.next;
			}
			prev = current;
			current = current.next;
		}
		return true;
	}
	
	
	public static void main(String []args) {
		
		
		Map<Integer,Integer> salary = new Map<>();
		salary.put(4230, 10000);
		salary.put(4231, 20000);
		
		System.out.print("\nThe Size of of Map"+salary.size());
		System.out.print("\nThe Map contains 4230:-"+salary.find(4230));
		System.out.print("\nRemove the key 4233:-"+salary.remove(4233));
		System.out.print("\nThe Map contains 4230:-"+salary.find(4230));
	}
	
}
