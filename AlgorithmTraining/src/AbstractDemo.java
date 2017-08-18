class AbstractClass{
	
	   public int solution(int[] A) {
	   
		   int i = 0;
		   System.out.println(A[i++]);
		   System.out.println(i);
		   System.out.println(A[++i]);
		   System.out.println(i);
		   return 0;
	   }
}
public class AbstractDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractClass a= new AbstractClass(){};
		
		int A[] = {2,3,4,5,6};
		
		System.out.println(a.solution(A));
	}

}
