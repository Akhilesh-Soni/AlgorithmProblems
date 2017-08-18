package hackererath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LemursMadagascar {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.parseInt(line.substring(0,line.indexOf("")));
		int k = Integer.parseInt(line.substring(line.indexOf(" "),line.length()));
		
	}

}
