/*Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or diagonally 
with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the 
largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5

*/
import java.util.*;
class Solution{
    static int[][] grid;
    static boolean[][] vis;
    static int r,c;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        grid = new int[r][c];
        vis = new boolean[r][c];
        
        for(int i=0;i<r;i++)
          for(int j=0;j<c;j++) grid[i][j] = sc.nextInt();
          
        System.out.println(getMaxSapGrp(grid,r,c));
    }
    static int area(int i, int j){
        if (i < 0 || i >= r || j < 0 || j >= c || vis[i][j] || grid[i][j] == 0)
            return 0;
        vis[i][j] = true;
        return (1+area(i+1,j)+area(i-1,j)+area(i,j-1)+area(i,j+1)+area(i+1,j+1)+area(i+1,j-1)+area(i-1,j+1)+area(i-1,j-1));
    }

    static int getMaxSapGrp(int[][] grid,int r,int c) {
        int ans = 0;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                ans = Math.max(ans, area(i, j));
            }
        }
        return ans;
    }
}
}