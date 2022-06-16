/*Given a set of weights of n items weights[], and another item wieght w.
Your task is to check if the sum of weights of continuous subset is equal to 
one of the multiple of w, where subset size should be minimum 2.

For example: Mulitple of w means, w=3 then multiple of w are
3, 6, 9, 12, .... so on.

Print true, if such subset sum is possible.
Otherwise, print false.

Input Format:
-------------
Line-1 : Two integers n and w, number of weights and weight to match.
Line-2 : n space separated integers, weights of n items.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
5 4
1 2 3 5 6

Sample Output-1:
----------------
false


Sample Input-2:
---------------
5 4
1 2 3 6 5

Sample Output-2:
----------------
true

Explanation: 
------------
sum of  continuous subset of weights [1,2,3,6]  equals to 12, multiple of 4.
*/
import java.util.*;
import java.lang.*;
class day38p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int w = sc.nextInt();
		  int[] weights = new int[n];
		  for(int i=0;i<n;i++) weights[i] = sc.nextInt();
          System.out.println(isPossible(weights,w,n));
		}
	    static boolean isPossible(int[] weights, int w, int n){
	        int[] prefix = new int[n];
	        prefix[0] = weights[0];
	        for(int i=1;i<n;i++){
	            prefix[i] = prefix[i-1] + weights[i];
	        }
	        HashMap<Integer,Integer> map = new HashMap<>();
	        int i=0;
            for(i=0;i<n;i++){
                if(!map.containsKey(prefix[i]%w)) map.put(prefix[i]%w,i);
                else break;
            }
            if(i==n) return false;
            if(i-map.get(prefix[i]%w) > 0) return true;
            else return false;
	        
	    }
}     
 