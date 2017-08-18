package assignments;

import java.util.ArrayList;
import java.util.Iterator;

public class ZigZagPattern {

	public static void main(String []args) {
		String input = "GEEKSFORGEEKS";
		
		
		int row = 0, totalNumberOfRows = 3, lengthofString = input.length();
		
		boolean downDirection = true;
		
		ArrayList<Character> zig_zag = new ArrayList<>();
		for (int index = 0; index < lengthofString; index++) {
	
			if(downDirection){
				zig_zag.add(row, input.charAt(index));
				row++;
				if(row == totalNumberOfRows-1){
					downDirection = false;
					row--;
				}
			}
			else {
				row--;
				if(row == 0){
					downDirection = true;
					row++;
				}
			}
		}
	
	}
}
