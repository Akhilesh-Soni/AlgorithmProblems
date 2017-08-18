import java.util.Scanner;

import org.omg.CORBA.FREE_MEM;


public class Assignment1 {

	/**
	 * @param args
	 */
	public static int[] sortZeroOnes(int a[]) {
		
		int numberofZeros = 0;
		for(int index = 0;index<a.length;index++)
		{
			if(a[index] == 0){
				numberofZeros++;
			}
		}
		for(int index = 0;index<a.length;index++)
		{
			if(numberofZeros>0){
				a[index] = 0;
				numberofZeros--;
			}
			else {
				a[index] = 1;
			}
		}
		return a;
	}
	public static int[] sortZeroOnesTwos(int a[]) {
		
		int numberofZeros = 0,numberofOnes = 0;
		for(int index = 0;index<a.length;index++)
		{
			if(a[index] == 0){
				numberofZeros++;
			}
			else if(a[index] == 1) {
				numberofOnes++;
			}
		}
		for(int index = 0;index<a.length;index++)
		{
			if(numberofZeros>0){
				a[index] = 0;
				numberofZeros--;
			}
			else if(numberofOnes>0) {
				a[index] = 1;
				numberofOnes--;
			}
			else{
				a[index] = 2;
			}
		}
		return a;
	}
	public static void rotationVector(int a[]) {
		int rotationvector = 0;
		for (int index = 0; index < a.length-1; index++) {
			if(a[index]<=a[index+1]){
				continue;
			}
			else{
				rotationvector = index+1;
				break;
			}
		}
		System.out.println("\nThe Array has been rotated by:- "+rotationvector);
	}
	public static void duplicateNumber(int a[]) {
		int duplicateNumber,temp;
		int len = a.length;
		int sumOriginal = 0,sumDuplicate = 0;
		sumOriginal = (len*(len-1)/2);
		for (int i = 0; i < a.length-1; i++) {
			sumDuplicate+=a[i];
		}
		temp = sumOriginal-sumDuplicate;
		duplicateNumber = len-(temp+1);
		System.out.println("\nThe Duplicate Number In Array is:- "+duplicateNumber);
	}
	public static void compressString(String input) {
		int frequency[] = new int[26];
		StringBuffer output = new StringBuffer();
		for (int index = 0; index < input.length(); index++) {
			frequency[input.charAt(index)-'a']++;
		}
		for (int index = 0; index < frequency.length; index++) {
			if(frequency[index] != 0){
				output.append((char)(index+'a'));
				output.append(frequency[index]);
			}
		}
		System.out.print("\nAfter Compression The String Is:- "+output);
	}
	public static char highestOcurrence(String input) {
		int frequency[] = new int[26];
		int max;
		char charcter='a';
		for (int index = 0; index < input.length(); index++) {
			frequency[input.charAt(index)-'a']++;
		}
		max = frequency[0];
		for (int index = 1; index < frequency.length-1; index++) {
			if(frequency[index]>max)
			{
				max = frequency[index];
				charcter  = (char)('a'+index);
			}
		}
		return charcter;
	}
	public static void mergeSort(int a[]) {
		if(a.length<2){
			return ;
		}
			
		int mid = 0;
		int left[],right[];
		mid = (a.length/2);
		int leftArray[] = new int[mid];
		int rightArray[] = new int[a.length-mid];
		for (int index = 0; index < mid; index++) {
			leftArray[index] = a[index];
		}
		for (int index = mid; index < a.length; index++) {
			rightArray[index-mid] = a[index];
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		mergeArray(leftArray,rightArray,a);
	}
	public static void mergeArray(int[] leftArray, int[] rightArray, int[] output) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, k = 0;
		while(i < leftArray.length && j < rightArray.length){
			if(leftArray[i]<rightArray[j]){
				output[k] = leftArray[i];
				i++;
				k++;
			}else {
				output[k] = rightArray[j];
				j++;
				k++;
			}
		}
		while ( i < leftArray.length) {
			output[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < rightArray.length) {
			output[k] = rightArray[j];
			j++;
			k++;
		}
		return;
	}
	public static void bubbleSort(int a[], int startIndex) {
		if(startIndex>a.length){
			return;
		}
		for (int index = 0; index < a.length-1; index++) {
			if(a[index]>a[index+1]){
				int temp = a[index];
				a[index] = a[index+1];
				a[index+1] = temp;
			}
		}
		bubbleSort(a, startIndex+1);
	}
	public static String replacePi(String input) {
		if(input.length()<2){
			return input;
		}
		if(input.substring(0,2).equals("pi")) {
			return "3.14"+replacePi(input.substring(2));
		}
		return input.charAt(0)+replacePi(input.substring(1));
	}
	public static int convertString(String input,int number) {
		if (input.length()== 0) {
			return number;
		}
		number = number*10+(input.charAt(0)-'0');
		return convertString(input.substring(1), number);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int a[];
//		int startIndex = 0;
//		a = InputArray.inputArray();
//		a = sortZeroOnes(a);
//		a = sortZeroOnesTwos(a);
//		rotationVector(a);
//		duplicateNumber(a);
//		mergeSort(a);
//		bubbleSort(a, startIndex);
//		System.out.println("\nAfter Sorting the elements are");
//		for(int index = 0;index<a.length;index++)
//		{
//			System.out.print(a[index]+"	");
//		}
		
		
		Scanner sc = new Scanner(System.in);
		String input;
		int number = 0;
//		char occurrence;
		System.out.print("Enter a string:- ");
		input = sc.nextLine();
//		compressString(input);
//		occurrence = highestOcurrence(input);
//		input = replacePi(input);
//		number = convertString(input,number);
//		System.out.print("\nAfter Replacement The string is:- "+input);
//		System.out.print("\nHighest Occured Charcter is:- "+occurrence);
//		System.out.print("After Conversion the number is:- "+number);
	}

}
