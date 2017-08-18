package l6;

import java.util.HashMap;
import java.util.Iterator;

public class MapUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arrray[] = {1,1,1,2,2,3,4};
		System.out.print("\n The Array is :- ");
		for (int i : arrray) {
			System.out.print(arrray[i]+"\t");
		}
		HashMap<Integer, Integer> removeDuplicates = new HashMap<>();
		for (int i : arrray) {
			if(removeDuplicates.containsValue(arrray[i])){
				continue;
			}
			else {
				removeDuplicates.put(i, arrray[i]);
			}
		}
		System.out.print("\n After Removing Duplicates the Array is :- ");

	}

}
