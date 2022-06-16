/*Karthik is going on a world tour, He prefers to travel in airplanes.
He is given a list of planes avaialble , where a plane[i]=[src-i, dest-i].
i.e, plane[i] indiactes airplane from source city to destination city.

Your task is to findout in which city karthk will end up his world tour.
end up the tour means, he cannot travel further from that city.

Note: It is guaranteed that there is no loop. 

Input Format:
-------------
Line-1: An integer N, number of airplanes routes.
next N lines: two comma (',') separated Strings, source and destination.

Output Format:
--------------
Print a string, City Name.


Sample Input:
---------------
3
London,New York
New York,Sydney
Sydney,New Delhi

Sample Output:
----------------
New Delhi
*/
import java.util.*;
class day56p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = Integer.parseInt(sc.nextLine());
		  String[][] trip = new String[n][2];
		  for(int i=0;i<n;i++){
		      trip[i] = sc.nextLine().split(",");
		  }
		  //System.out.println(Arrays.toString(trip));
		  System.out.println(getDest(trip,n));
		}
		static String getDest(String[][] trip,int n){
		    Map<String,String> map = new HashMap<>();
		    for(int i=0;i<n;i++)
		       map.put(trip[i][0],trip[i][1]);
		    for(Map.Entry<String,String> e : map.entrySet()){
		        if(!map.containsKey(e.getValue())) return e.getValue();
		    }
		    return "";
		}
}     
 