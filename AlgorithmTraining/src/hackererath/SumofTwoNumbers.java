package hackererath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumofTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		long testCases = Long.parseLong(br.readLine());
		if(testCases >= 1 && testCases <= 1_000_000_000){
			for(int i = 0;i<testCases;i++){
				String input[] = br.readLine().split(" ");
				Long a = Long.parseLong(input[0]);
				Long b = Long.parseLong(input[1]);
				if(a>= 1 && a<= 1_000_000_000){
					if(b >= 1 && b <= 1_000_000_000){
						System.out.println(a+b);
					}
				}
			}
		}
	}

}
