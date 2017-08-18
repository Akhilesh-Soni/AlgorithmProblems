package hackererath;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DivisibleBy6 {
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int length = line.length();
        boolean flag = true;
        
        if(length >= 1 && length <= 10_000){
        	for (int i = 0; i < length; i++) {
        			char character = line.charAt(i);
     				if(character >= 'a' && character <= 'i'){
     					continue;
     				}
     				else{
     					flag = false;
     				}
        	 }
        }else{
        	flag = false;
        }
        if(flag){
        	long sum = 0;
        	for (int i = 0; i < length; i++) {
        		char character = line.charAt(i);
        		int digit = 0;
     			switch(character){
     				case 'a': digit = 1;
     						  break;
    				case 'b': digit = 2;
     						  break;
     				case 'c': digit = 3;
     						  break;
     				case 'd': digit = 4;
     						  break;
     				case 'e': digit = 5;
     						  break;
     				case 'f': digit = 6;
     						  break;
     				case 'g': digit = 7;
     						  break;
     				case 'h': digit = 8;
     						  break;
     				case 'i': digit = 9;
     						  break;
     			}
     			sum = (sum*10)+digit;
     			System.out.println(""+digit);
        	}
        	System.out.println(""+sum);
        	if(sum % 6 != 0){
        		flag = false;
        	}
        }
        if(flag){
        	System.out.print("YES");
        }else{
        	System.out.print("NO");
        }
        
     }
}

