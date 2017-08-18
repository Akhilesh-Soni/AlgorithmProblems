package hackererath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TrailingZeros {

	/**
	 * @param args
	 */
	public static int factorial(int n, ArrayList<Integer>result,int res_size) {
		
		int carry = 0;  // Initialize carry
		 
	    // One by one multiply n with individual digits of res[]
	    for (int i=0; i<res_size; i++)
	    {
	        int prod = result.get(i) * n + carry;
	        result.remove(i);// Store last digit of 'prod' in res[]
	        result.add(i, prod%10);
	        carry  = prod/10;    // Put rest in carry
	    }
	 
	    // Put carry in res and increase result size
	    while (carry>0)
	    {
	        result.add(res_size, carry%10);
	        carry = carry/10;
	        res_size++;
	    }
	    return res_size;
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int res_size = 1;
		ArrayList<Integer> result = new ArrayList<>();
		result.add(0,1);
		if(n >=1 && n<= 1000){
			for(int i = 2;i <=n; i++){
				res_size = factorial(i,result,res_size);
			}
			int i = 0;
			while (true) {
				if(result.get(i) == 0){
					i++;
				}
				else {
					break;
				}
			}
			System.out.print("\n"+i);
		}else {
			throw new IOException("Number Sholud be less than 1000");
		}
		
	}

}
