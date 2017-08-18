import java.util.Scanner;


public class Power {

	/**
	 * @param args
	 */
	public static int power(int number,int power){
		if(power==1){
			return number;
		}
		if(power == 0){
			return 1;
		}
		else{
			return number*power(number,power-1);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number, power;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number and power:-");
		number = sc.nextInt();
		power = sc.nextInt();
		int no = power(number,power);
		System.out.println("The number is -"+no);
	}

}
