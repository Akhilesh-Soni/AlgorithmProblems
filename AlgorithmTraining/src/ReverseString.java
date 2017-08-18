import java.util.Scanner;


public class ReverseString {

	/**
	 * @param args
	 */
	public static void reverseString(String input){
		int start = 0, end= (input.length()-1);
		System.out.println(""+end);
		String reverse = reverseWords(input, start, end);
		System.out.println(reverse);
	}
	public static String reverseWords(String input, int start, int end){
			String reverse;
 			while(start<end){
				char temp = input.charAt(start);
				System.out.println("temp "+temp);
				input.replace(input.charAt(start),input.charAt(end));
				System.out.println("Start "+input.charAt(start));
				input.replace(input.charAt(end), temp);
				System.out.println("end "+input.charAt(end));
				start++;
				end--;
			}
			return input;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String input = null;
		System.out.println("Enter The String:-");
		input = sc.nextLine();
		reverseString(input);
	}

}
