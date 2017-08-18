package l9;

public class EditDistance {

	
	public static void editDistance(String s1 , String s2){
		
		if(s1.charAt(0) == s2.charAt(0)){
			editDistance(s1.substring(1), s2.substring(1));
		}
		else {
			if(s1.length() > s2.length()){
				s1.replace(s1.charAt(0), s2.charAt(0));
				editDistance(s1.substring(1), s2.substring(1));
			}
			else if(s1.length()<s2.length()){
				s1.replace(s1.charAt(0), s2.charAt(0));
			}
			
		}
	}
	
	public static void main(String []args) {
		String s1 = "abfg";
		String s2 = "aeg";
		editDistance(s1, s2);
				
	}
}
