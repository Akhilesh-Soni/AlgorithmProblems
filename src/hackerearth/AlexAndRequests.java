package hackerearth;

import java.util.Scanner;

/**
 * Alex is working in a firm, where he needs to process requests according to their priority. He has
 * N
 * N allocation systems. At any instance,
 * i
 * t
 * h
 * ith system can process only one request with priority
 * i
 * i or above.
 * <p>
 * For each request, on any eligible system, Alex can also terminate the request with less priority than that of the current request, in order to assign the current request to the system. There will be
 * Q
 * Q incoming requests and he needs to tell whether he can assign a system to each request or not.
 * <p>
 * Alex needs to assign each request to the system optimally, such that he can assign maximum number of incoming requests. The number of requests (which are already assigned) terminated by Alex, doesn't matter here.
 * <p>
 * Note:
 * If not terminated explicitly, consider the processing time of every request as infinite.
 * <p>
 * Input Format:
 * <p>
 * First line of the input contains
 * N
 * N, denoting the number of allocation systems.
 * <p>
 * Next line contains one integer
 * Q
 * Q, which denotes the number of incoming requests.
 * <p>
 * In next
 * Q
 * Q lines, each line contains one integer
 * X
 * X, denoting the priority of the request.
 * <p>
 * Output Format:
 * <p>
 * For each incoming request, in new line print
 * Y
 * E
 * S
 * YES, if Alex can assign a system to the request, else print
 * N
 * O
 * NO .
 * <p>
 * Note:
 * <p>
 * If Alex can anyhow assign the current request to the system, he can't reject the request. It is necessary to assign the request to any system.
 * <p>
 * Constraints:
 * 1
 * ≤
 * N
 * ≤
 * 100
 * 1≤N≤100
 * 1
 * ≤
 * X
 * ≤
 * 100000
 * 1≤X≤100000
 * 1
 * ≤
 * Q
 * ≤
 * 10000
 * 1≤Q≤10000
 * Sample Input
 * 2
 * 5
 * 3
 * 4
 * 2
 * 1
 * 3
 * Sample Output
 * YES
 * YES
 * YES
 * NO
 * YES
 */
public class AlexAndRequests {

    private static boolean checkWeatherRequestCanBeAssigned(int[] systems, int request) {
        boolean flag = false;
        for (int i = systems.length - 1; i > 0; i--) {
            if (request >= i) {
                if (request > systems[i]) {
                    systems[i] = request;
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int systems[] = new int[n + 1];
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int request = sc.nextInt();
            boolean flag = checkWeatherRequestCanBeAssigned(systems, request);
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
