package hackererath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FinalDestination {

	private int x,y;
	public FinalDestination() {
		// TODO Auto-generated constructor stub
		x = 0;
		y = 0;
	}
	public void setDestination(char direction){
		switch (direction) {
		case 'L':
			this.x--;
			break;
		case 'R':
			this.x++;
			break;
		case 'U':
			this.y++;
			break;
		case 'D':
			this.y--;
			break;
		default:
			break;
		}
	}

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub

		FinalDestination finalDestination = new FinalDestination();
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String command = br.readLine();
		int length = command.length();
		if(length >= 1 && length <= 10_000){
			for (int i = 0; i < length; i++) {
				finalDestination.setDestination(command.charAt(i));
			}
		}
		System.out.print(finalDestination.x +" "+finalDestination.y);
	}

}
