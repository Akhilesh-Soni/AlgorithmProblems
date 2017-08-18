package hackererath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class WobbyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase  = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			String line[] = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int k = Integer.parseInt(line[1]);
			if(k > 81){
				System.out.print("\n"+-1);
			}else {
				printWoobyNumber(n , k);
			}
		}
	}

	private static void printWoobyNumber(int n, int k) {
		// TODO Auto-generated method stub
		int a = (int) Math.ceil((double)k/9.0);
		int b = k%9;
		if( b == 0){
			b = -1;
		}
		if(a >= b){
			b--;
		}

		if(b<0){
			if(a == 9) 
				b = 8;
			else
				b = 9;
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			if(i%2 == 0){
				System.out.print(a);
			}else {
				System.out.print(b);
			}
		}
		
	}

}
