/*Tipsy-Topsy bakers has prepared N Boxes of muffins, 
each box contains box[i] no.of muffins.
Mr Bheemla ordered for P muffins.
 
Your task is to pick a set of boxes, the total number of muffins in 
the set of boxes together should be equals to P.

If you are able to pick the boxes, print 'true'.
Otherwis, print 'false'.

Input Format:
-------------
Line-1: Two space separated integers, N, P.
Line-2: N space separated integers, box[].

Output Format:
--------------
Print a boolean result.


Sample Input-1:
---------------
6 11
5 27 8 4 9 3

Sample Output-1:
----------------
true

Explanation:
-------------
Box-2 + Box-5 = 8 + 3 = 11


Sample Input-2:
---------------
5 20
2 3 5 7 4

Sample Output-2:
----------------
false
*/
import java.util.*;
import java.lang.*;
class elitesw2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int p = sc.nextInt();
		  int[] box = new int[n];
		  
		  for(int i=0;i<n;i++) box[i] = sc.nextInt();
		  
		 System.out.println(isPoss(box,n,p));
		}
		
		static boolean isPoss(int[] box,int n,int p){
		    boolean subset[][] = new boolean[p + 1][n + 1];
 
            for (int i = 0; i <= n; i++) subset[0][i] = true;
 
            for (int i = 1; i <= p; i++) subset[i][0] = false;
 
            for (int i = 1; i <= p; i++) {
                for (int j = 1; j <= n; j++) {
                    subset[i][j] = subset[i][j - 1];
                    if (i >= box[j - 1]) subset[i][j] = subset[i][j] || subset[i - box[j - 1]][j - 1];
                }
            }
        return subset[p][n];
		}
}        

