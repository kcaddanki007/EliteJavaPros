/*The Kolar Gold Fields (KGF) is in the form of a m*n grid,
Each field, contains some amount of Gold in it.
 
You can mine the gold in the KGF in the following way.
	- You can start at any position in the grid, never visit a cell with no gold.
	- each time you visit a cell, you will grab all the gold in it.
	- You can move one step to the left, right, up or down.
	- You can't visit the same cell more than once.
	- You can stop at any cell.
	
Your task is to find the maximum amount of gold you can collect.

Input Format:
-------------
Line-1: Two integers M and N size of the KGF grid.
Next M lines: N space separated integers, gold in each row of the grid.

Output Format:
--------------
Print an integer, maximum amount of gold.


Sample Input-1:
---------------
3 3
0 6 0
5 8 7
0 9 0

Sample Output-1:
----------------
24

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 9 -> 8 -> 7.

Sample Input-2:
---------------
5 3
1 0 7
2 0 6
3 4 5
0 3 0
9 0 20

Sample Output-2:
----------------
28

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
*/

import java.lang.*;
import java.util.*;

class day29p2
{
    static int m,n;
    static int[][] grid;
    static boolean visited[][];
    static int max = Integer.MIN_VALUE;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        grid = new int[m][n];
        visited = new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j] = sc.nextInt();
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                maxGold(i,j,0);
            }
        }
        System.out.println(max);
    }
    public static void maxGold(int x,int y,int sum)
    {
        if(x>=m || x<0 || y>=n || y<0 || grid[x][y] == 0 || visited[x][y] == true)
        {
            max = Math.max(max,sum);
            return;
        }
        sum+=grid[x][y];
        visited[x][y] = true;
        maxGold(x+1,y,sum);
        maxGold(x-1,y,sum);
        maxGold(x,y+1,sum);
        maxGold(x,y-1,sum);
        visited[x][y] = false;
        sum-=grid[x][y];
    }
}