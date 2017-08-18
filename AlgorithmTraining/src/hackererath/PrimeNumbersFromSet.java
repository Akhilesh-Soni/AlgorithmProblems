package hackererath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumbersFromSet {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String numberString[] = br.readLine().split(" ");
		int array[] = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(numberString[i]);
		}
		for (int i = 0; i < array.length; i++) {
			boolean prime = true;
			for (int j = 0; j < array.length; j++) {
				if(array[i] % array[j] == 0 && i != j){
					prime = false;
					break;
				}
			}
			if(prime){
				System.out.print(array[i]+" ");
			}
		}
	}

}
