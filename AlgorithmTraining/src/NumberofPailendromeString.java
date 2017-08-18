import java.util.ArrayList;
import java.util.Scanner;


public class NumberofPailendromeString {

	/**
	 * @param args
	 */
	
	public static int numberofPailendrome(String inString)
	{
		int number = 0, center = 0, left = 0,right = 0;
		for (int i = 0; i < inString.length(); i++) {
			center = i;
			left = center-1;
			right = center+1;
			if(left<0)
			{
				continue;
			}
			else if(right>inString.length())
			{
				break;
			}
			else
			{
				if(inString.charAt(left) == inString.charAt(right)){
					number++;
				}
			}
			  
		}
		
		
		return number;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inString = null;
		Scanner sc = new Scanner(System.in);
		inString = sc.next();
		int answer = numberofPailendrome(inString);
		System.out.println("Number of pailndrome is :- "+answer);
	}

}
