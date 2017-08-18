package l9;

import java.util.Scanner;

public class PatternMatchingBrute {

	public static int patternMatching(String input, String pattern) {
		int index = -1;
	/*	for (int i = 0; i <= input.length()-pattern.length(); i++) {
		
			for (int j = 0; j < pattern.length(); j++) {
					if(temp.charAt(j) != pattern.charAt(j)){
						break;
					}
	
			
		}*/
		return index;
	}
	
	public static void main(String []args) {
		String input, pattern;
		Scanner sc = new Scanner(System.in);
		System.out.print("|n Enter the Input String:-");
		input = sc.nextLine();
		System.out.print("|n Enter the Input Pattern:-");
		pattern = sc.nextLine();
		System.out.print("|n The Pattern find at index :- "+patternMatching(input, pattern));
	}
}
