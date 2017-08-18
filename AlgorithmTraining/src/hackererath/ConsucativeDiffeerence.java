package hackererath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsucativeDiffeerence {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalTestCases = Integer.parseInt(br.readLine());
		int lengthofstringArray = (totalTestCases*2);
		System.out.println(lengthofstringArray);
		String stringArray[] = new String[lengthofstringArray];
		
		if(totalTestCases > 1000){
			System.out.print("NO");
			System.exit(0);
		}
		for (int i = 0; i < lengthofstringArray; i++) {
			stringArray[i] = br.readLine();
		}
		
		
		for (int i = 0; i < lengthofstringArray-1; i= i+2) {
			int lengthOfArray = Integer.parseInt((stringArray[i].substring(0,stringArray[i].indexOf(' '))));
			if(lengthOfArray> 1000){
				System.out.print("NO");
				continue;
			}
			
			int difference = Integer.parseInt(stringArray[i].substring(stringArray[i].indexOf(' ')+1,stringArray[i].length()));
			if(difference > 100){
				System.out.print("NO");
				continue;
			}
			
			int intArray[] = new int[lengthOfArray];
			String str [] = stringArray[i+1].split(" ");
			int k = 0;
			
			for(int j = 0;j<str.length;j++){
				intArray[k] =  Integer.parseInt(str[j]);
				k++;
			}
			
			if(lengthOfArray == 1){
				if(intArray[0] <= difference){
					System.out.print("YES");
					continue;
				}
				else {
					System.out.print("NO");
					continue;
				}
			}
			
			boolean flag = false;
			for (int j = 0; j < lengthOfArray-1; j++) {
				if(intArray[j] >= 1 && intArray[j] <= 1_000_000){
					if(intArray[j+1] >= 1 && intArray[j+1] <= 1_000_000){
						int diff = 0;
						if(intArray[j] > intArray[j+1]){
							diff = intArray[j] - intArray[j+1];
						}else {
							diff = intArray[j+1] - intArray[j];
						}
						if(diff <= difference){
							flag = true;
							break;
						}
					}else {
						continue;
					}
				}else {
					continue;
				}
			}
			if(flag){
				System.out.println("YES");
			}else {
				System.out.print("NO");
			}
		}
		
	}

}
