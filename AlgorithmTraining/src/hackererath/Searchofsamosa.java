package hackererath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import  assignments.Assignment1;


public class Searchofsamosa {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		String line2[] = br.readLine().split(" ");
		int lengthOfArray = Integer.parseInt(line1.substring(0,line1.indexOf(" ")));
		int money = Integer.parseInt(line1.substring(line1.indexOf(" ")+1,line1.length()));
		System.out.println(money);
		int prizeofSamosa[] = new int[lengthOfArray];
		for (int i = 0; i < lengthOfArray; i++) {
			prizeofSamosa[i] = Integer.parseInt(line2[i]);
		}
		Assignment1.mergeSort(prizeofSamosa);
		for (int i = 0; i < prizeofSamosa.length; i++) {
			System.out.print(prizeofSamosa[i]+"\t");
		}
		int i = 0;
		while(i < lengthOfArray && money > 0){
			money -= prizeofSamosa[i];
			if(money < 0){
				break;
			}
			++i;
		}
		System.out.print("\n"+i);
		
	}

}
