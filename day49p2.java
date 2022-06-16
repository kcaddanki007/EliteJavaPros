/*You have given a bagful of N colored balls, the color codes of the balls 
are distinct. Your task is to print "true", if and only if the number of balls
having different color codes in the bag are distinct. Otherwise, print "false".

Input Format:
-------------
Line-1: An integer N, number of balls.
Line-2: N space separated integers, the color codes of the balls.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
6
1 2 2 1 1 3

Sample Output-1:
----------------
true

Explanation:
------------
The number of balls in the bag having color code-1 are 3,
The number of balls in the bag having color code-2 are 2,
The number of balls in the bag having color code-3 are 1.
The count of balls having distinct color codes are not same.


Sample Input-2:
---------------
3
1 2 3

Sample Output-2:
----------------
false
*/
import java.util.*;
import java.lang.*;
class day49p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int[] arr = new int[n];
		  for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		  System.out.println(isCountUnique(arr,n));
		}
		static boolean isCountUnique(int[] arr,int n){
		    Map<Integer,Integer> map = new HashMap<>();
		    Set<Integer> set = new HashSet<>();
		    
		    for(int i=0;i<n;i++) map.put(arr[i],map.getOrDefault(arr[i],0)+1);
		    
		    for(Map.Entry<Integer,Integer> e: map.entrySet()) set.add(e.getValue());
		    
		    return map.size()==set.size();
		}
}     