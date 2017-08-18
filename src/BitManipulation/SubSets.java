package BitManipulation;

/**
 * Created by akhileshsoni on 29-07-2017.
 */
public class SubSets {

    private static int numberOfSubSets;

    private static void printAllSubsets(String str) {
        numberOfSubSets = 1 << str.length();
        for (int i = 0; i < numberOfSubSets; i++) {
            for (int j = 0; j < str.length(); j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str = "1234";
        printAllSubsets(str);
    }
}
