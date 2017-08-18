package hackererath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class CompressString {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int numberOfQuestion = Integer.parseInt(br.readLine());
		int question[] = null;
		if(numberOfQuestion >=1 && numberOfQuestion <= 1_00_000){
			question = new int[numberOfQuestion];
			for (int i = 0; i < numberOfQuestion; i++) {
				question[i] = Integer.parseInt(br.readLine());
			}
		}
		int stringLength = input.length();
		int frequencyofCaharcter[] = new int[26];
		long limit = 1_000_000_000_000_000_000L;
		int finalStringlength = 0;
		
		if(stringLength >= 2 && stringLength <= 10_000){
			for(int i = 0;i<stringLength;i= i+2){
				char character = input.charAt(i);
				int fequency = Integer.parseInt(""+input.charAt(i+1));
				frequencyofCaharcter[character - 'a'] +=fequency; 
			}
		
			for (int i = 0; i < frequencyofCaharcter.length; i++) {
				finalStringlength += frequencyofCaharcter[i]; 
			}
	
			if(finalStringlength>=2 && finalStringlength <= limit){
				String finalString = getString(frequencyofCaharcter);	
				for(int i = 0;i<numberOfQuestion;i++){
					int k = question[i];
					if(k>=1 && finalStringlength <= limit){
						System.out.println(finalString.charAt(k-1));
					}
				}
			}
		}
	}

	private static String getString(int[] frequencyofCaharcter) {
		// TODO Auto-generated method stub
		StringBuilder sbr = new StringBuilder(frequencyofCaharcter.length);
		for (int i = 0; i < frequencyofCaharcter.length; i++) {
			int frequency = frequencyofCaharcter[i];
			for (int j = 0; j < frequency; j++) {
				sbr.append(((char)('a'+i)));
			}
		}
		return sbr.toString();
	}

}
