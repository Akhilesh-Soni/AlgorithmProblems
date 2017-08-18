
public class RemoveRepeatingValue {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[];
		arr = InputArray.inputArray();
		int i;  
		System.out.println("\n The repeating elements are");
		  for(i = 0; i <arr.length-1; i++)
		  {
		    if(arr[arr[i]] > 0){
		    	arr[arr[i]] = -arr[arr[i]];
			     System.out.println(arr[i]+"	");
			   
		    }
		       else
		    	System.out.println(arr[i]+"	");
		  }         
	}

}
