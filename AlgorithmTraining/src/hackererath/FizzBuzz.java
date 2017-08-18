package hackererath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		if(testcases >= 1 && testcases <= 10){
			String numberString = br.readLine();
			String array [] = numberString.split(" ");
			for (int i = 0; i < array.length; i++) {
				printData(Integer.parseInt(array[i]));
			}
		}
	}

	private static void printData(int number) {
		// TODO Auto-generated method stub
		for(int i = 1; i<=number;i++){
			
			if(i%3 == 0 && i%5 == 0){
				System.out.println("FizzBuzz");
			}
			else if(i%3 == 0){
				System.out.println("Fizz");
			}
			else if(i%5 == 0){
				System.out.println("Buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}

}
