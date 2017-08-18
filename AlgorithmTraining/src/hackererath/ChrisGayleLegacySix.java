package hackererath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChrisGayleLegacySix {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		ArrayList<String>inputlines = new ArrayList<>();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		if(testCases >= 1 && testCases <= 10){
			for (int i = 0; i < testCases; i++) {
				String nextLine[] =  br.readLine().split(" ");
				int numberOfBalls = Integer.parseInt(nextLine[0]);
				long intialPower = Long.parseLong(nextLine[1]);
				if(numberOfBalls >=1 && numberOfBalls <= 10_000){
					for (int j = 0; j < numberOfBalls; j++) {
						inputlines.add(br.readLine());
					}
				}
				checkForHitSix(inputlines,intialPower);
			}

		}
		
	}

	private static void checkForHitSix(ArrayList<String> inputlines , long intialPower) {
		// TODO Auto-generated method stub
		int length = inputlines.size();
		int limit = 1_000_000_000;
		String status = "YES";
		for (int i = 0; i < length; i++) {
			String input[] = inputlines.get(i).split(" ");
			long gainPower = Long.parseLong(input[0]);
			long requiredPower = Long.parseLong(input[1]);
			if(gainPower >= 1 && gainPower <= limit){
				if (requiredPower >= 1 && requiredPower <= limit) {
					if(requiredPower < intialPower){
						intialPower = intialPower+gainPower;
					}
					else {
						status = "NO";
						break;
					}
				}
			}
		}
		System.out.println(status);
		
	}

}
