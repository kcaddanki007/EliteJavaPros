/*Skandhanshi Infra Township constructed N Villas in a row.
They planned to paint the villas with three colors, 
snow-white, sky-blue and light-green. 
And adjacent villas should not paint with same color.

You are given the cost of painting each villa with these colors, cost[N][3].
cost[i][0] is cost of painting with snow-white.
cost[i][1] is cost of painting with sky-blue.
cost[i][2] is cost of painting with light-green.
where, 0 <= i < N.

Your task is to find the minimum cost to paint all the villas.

Input Format:
-------------
Line-1: An integer N, number of villas.
Next N lines: 3 space separated integers, cost to paint the villas.

Output Format:
--------------
Print an integer, minimum cost to paint all the villas.


Sample Input:
---------------
3
17 2 17
16 4 5
14 3 19

Sample Output:
----------------
10

Explanation: 
------------
1st Villa painted with sky-blue, 2nd Villa painted with light-green,
3rd Villa painted with sky-blue.
Minimum cost: 2 + 5 + 3 = 10.

*/
import java.util.*;
import java.lang.*;
class day50p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int[][] arr = new int[n][3];
		  for(int i=0;i<n;i++)
		     for(int j=0;j<3;j++) arr[i][j] = sc.nextInt();
		  System.out.println(getMinPath(arr,n));
		}
		static int getMinPath(int[][] arr,int n){
		    int[][] memo = new int[n][3];
		    
		  for(int j=0;j<3;j++) memo[n-1][j] = arr[n-1][j];
		  
		  for(int i=n-2;i>=0;i--){
		      for(int j=0;j<3;j++) memo[i][j] = arr[i][j] + Math.min(memo[i+1][(j-1+3)%3],memo[i+1][(j+1)%3]);
		  }
		  
		  //for(int i=0;i<n;i++) System.out.println(Arrays.toString(arr[i]));
		  //System.out.println(" ");
		  //for(int i=0;i<n;i++) System.out.println(Arrays.toString(memo[i]));
		  return Math.min(Math.min(memo[0][0],memo[0][1]),memo[0][2]);
		}
}     
 
