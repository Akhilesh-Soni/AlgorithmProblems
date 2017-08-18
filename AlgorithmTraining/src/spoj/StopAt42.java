package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StopAt42 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int number = Integer.parseInt(br.readLine());
			if(number != 42){
				System.out.println(number);
			}
			else {
				break;
			}
		}
	}

}
