package hackerearth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Alex works in a firm that deals with the requests that come with their own
 * P
 * r
 * i
 * o
 * r
 * i
 * t
 * y
 * <p>
 * V
 * a
 * l
 * u
 * e
 * Priority Value at different instants of time . Now he has to maintain a list of these requests with their
 * P
 * r
 * i
 * o
 * r
 * i
 * t
 * y
 * <p>
 * V
 * a
 * l
 * u
 * e
 * Priority Value and the time at which they come. He updates the list according to the following queries:
 * <p>
 * T
 * y
 * p
 * e
 * <p>
 * 1
 * :
 * Type 1: Update the
 * P
 * r
 * i
 * o
 * r
 * i
 * t
 * y
 * <p>
 * V
 * a
 * l
 * u
 * e
 * Priority Value of the request at time
 * t
 * t to
 * p
 * p in the list. In case there is no request present at time
 * t
 * t in list, set the
 * P
 * r
 * i
 * o
 * r
 * i
 * t
 * y
 * <p>
 * V
 * a
 * l
 * u
 * e
 * Priority Value of that request to
 * p
 * p at time
 * t
 * t in the list.
 * <p>
 * T
 * y
 * p
 * e
 * <p>
 * 2
 * :
 * Type 2: Remove the request which came at time
 * t
 * t, from the list. It is guaranteed that some request has already been come at that time before. Alternatively, there will always be a request at time
 * t
 * t currently present in the list.
 * <p>
 * T
 * y
 * p
 * e
 * <p>
 * 3
 * :
 * Type 3: Print the minimum
 * P
 * r
 * i
 * o
 * r
 * i
 * t
 * y
 * <p>
 * V
 * a
 * l
 * u
 * e
 * Priority Value of the request, followed by a space and the maximum
 * P
 * r
 * i
 * o
 * r
 * i
 * t
 * y
 * <p>
 * V
 * a
 * l
 * u
 * e
 * Priority Value of the request currently present in the list.
 * <p>
 * T
 * y
 * p
 * e
 * <p>
 * 4
 * :
 * Type 4: Print the
 * P
 * r
 * i
 * o
 * r
 * i
 * t
 * y
 * <p>
 * V
 * a
 * l
 * u
 * e
 * Priority Value of the request, of the highest time present in the list.
 * <p>
 * Note:
 * 1. The time instants given for query
 * 1
 * 1 may not be in ascending order.
 * 2. There can be more than two time instants with same
 * P
 * r
 * i
 * o
 * r
 * i
 * t
 * y
 * <p>
 * V
 * a
 * l
 * u
 * e
 * Priority Value of the request.
 * <p>
 * Constraints:
 * 1
 * <
 * q
 * <
 * 2
 * ×
 * 10
 * 5
 * 1<q<2×105
 * 1
 * <
 * t
 * ,
 * p
 * <
 * 2
 * ×
 * 10
 * 9
 * 1<t,p<2×109
 * <p>
 * Input Format:
 * First line of the input contains
 * q
 * q, the number of queries.
 * <p>
 * Then
 * q
 * q lines follow.
 * <p>
 * Each of the
 * q
 * q lines correspond to one of the query mentioned above.
 * <p>
 * T
 * y
 * p
 * e
 * <p>
 * 1
 * :
 * Type 1: Integer with value
 * 1
 * 1, followed by space and two space-separated integers
 * p
 * p and
 * t
 * t , denoting the
 * P
 * r
 * i
 * o
 * r
 * i
 * t
 * y
 * <p>
 * V
 * a
 * l
 * u
 * e
 * Priority Value of the request and time
 * t
 * t, respectively.
 * <p>
 * T
 * y
 * p
 * e
 * <p>
 * 2
 * :
 * Type 2: Integer with value
 * 2
 * 2, followed by space and single integer
 * t
 * t, denoting the time.
 * <p>
 * T
 * y
 * p
 * e
 * <p>
 * 3
 * :
 * Type 3: Integer with value
 * 3
 * 3.
 * <p>
 * T
 * y
 * p
 * e
 * <p>
 * 4
 * :
 * Type 4: Integer with value
 * 4
 * 4.
 * <p>
 * Output Format:
 * <p>
 * For each query of type
 * 3
 * 3 , output the minimum and maximum
 * P
 * r
 * i
 * o
 * r
 * i
 * t
 * y
 * <p>
 * V
 * a
 * l
 * u
 * e
 * Priority Value of the request currently present in the list.
 * <p>
 * For each query of type
 * 4
 * 4, output the
 * P
 * r
 * i
 * o
 * r
 * i
 * t
 * y
 * <p>
 * V
 * a
 * l
 * u
 * e
 * Priority Value of the request of highest time, currently present in the list.
 * <p>
 * Note: You can assume that whenever query of type
 * 3
 * ,
 * 4
 * 3,4 occurs, the data is not null i.e some answer exists.
 * <p>
 * Sample Input
 * 6
 * 1 3 10
 * 1 5 2
 * 3
 * 4
 * 2 5
 * 3
 * Sample Output
 * 2 10
 * 2
 * 10 10
 */
public class AlexAndPriorityRequests {

    private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, highestTime = 0;

    private static void performOperation(Scanner sc, Map<Integer, Integer> map, int type) {
        switch (type) {
            case 1:
                int time = sc.nextInt();
                int priority = sc.nextInt();
                if (priority < min) {
                    min = priority;
                }
                if (priority > max) {
                    max = priority;
                }
                if (time > highestTime) {
                    highestTime = time;
                }
                map.put(time, priority);
                break;
            case 2:
                int removeTime = sc.nextInt();
                if (map.get(removeTime) != null) {
                    int removedPriority = map.remove(removeTime);
                    if (removedPriority == max) {
                        max = Integer.MIN_VALUE;
                        map.values().forEach(p -> {
                            if (p > max) {
                                max = p;
                            }
                        });
                    } else if (removedPriority == min) {
                        min = Integer.MAX_VALUE;
                        map.values().forEach(p -> {
                            if (p < min) {
                                min = p;
                            }
                        });
                    }
                }
                break;
            case 3:
                System.out.println(min + "    " + max);
                break;
            case 4:
                System.out.println(map.get(highestTime));
                break;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            performOperation(sc, map, type);
        }
    }
}
