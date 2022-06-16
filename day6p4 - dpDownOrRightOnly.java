/*Your playing a game, the game contains m*n grid.
Each cell in the grid represent the health points.
You can move one step either downwads or rightwards only.
Whenever you visit a cell in the grid, you will lose the 
same health points of the cell.

You will start at (0,0) cell of the grid and have to reach (m-1)*(n-1) cell.
Your task is to minimize the loss of overall health points.

Input Format:
-------------
Line-1: Two integers M and N.
Next M lines: N space separated integers, health points in each row of the grid.

Output Format:
--------------
Print an integer, minimal loss of overall health points.


Sample Input-1:
---------------
3 3
1 3 1
1 5 1
4 2 1

Sample Output-1:
----------------
7

Explanation:
------------
start at cell(0,0) =>  1→3→1→1→1 minimizes the loss of health points.


Sample Input-2:
---------------
4 4
8 6 9 3
7 6 2 1
5 5 7 9
8 9 6 2

Sample Output-2:
----------------
34

Explanation:
------------
start at cell(0,0) =>  8→6→6→2→1→9→2 minimizes the loss of health points.
*/

import java.util.*;
import java.lang.*;
class day6p4{
   
   static int[][] dp;
   
    public static int md(int[][] dp,int[][] arr,int i,int j,int m,int n){
        if(i<=m && j<=n)
        {
            if(dp[i][j]!=-1)
                return dp[i][j];
            else if(i==m && j==n)
                return arr[i][j];
            else if(i==m && j!=n)
                return arr[i][j] + md(dp,arr,i,j+1,m,n);
            else if(j==n && i!=m)
                return arr[i][j] + md(dp,arr,i+1,j,m,n);
            else
                dp[i][j] = arr[i][j] + Math.min(md(dp,arr,i,j+1,m,n),md(dp,arr,i+1,j,m,n));
            return dp[i][j];
        } 
        return 0;
    }

        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int m = sc.nextInt();
          int n = sc.nextInt();
          int[][] inp = new int[m][n];
          
        dp = new int[m][n];
        
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);
          
          for(int i=0;i<m;i++){
              for(int j=0;j<n;j++) inp[i][j] =sc.nextInt();
          }
          
          System.out.println(md(dp,inp,0,0,m-1,n-1));
          
        //   for(int i=0;i<m;i++){
        //       for(int j=0;j<n;j++) System.out.print(dp[i][j]+" ");
        //     System.out.print("\n");
        //   }
	}	 
}        
