/*ABC Township purchased a land which has some places are lakes some are normal land.
You will be given a grid as 2d array gridLand[][] of size M*N, 
where 0 indicates land, and 1 indicates water.  

HMDA has to approve the layout of the township, 
So, that the engineers has to decide the number of floors of each building 
by following the guidelines listed below:
	- You are allowed to constrcut the builing in a lnad cell only.
	- The number of floors of a building in land cell must be non-negative.
	- You are not allowed to construct a building in a lake cell, so floors 
	  count is 0.
	- Any two adjacent buildings must have an absolute floors difference of 
	at most 1. A building is adjacent to another building if one of the sides 
	of one builing is touching with the other either north, east, south, or west.
	
Your task is to find an assignment of floors for each building such that 
the maximum number of floors of the buildings in the gridLand is maximized and 
return the number of floors of a building which has maximum floors.

Input Format:
-------------
Line-1: Two space separated integers, M * N, size of the land.
Next M lines: N space separated integers, either 0 or 1 only.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 3
1 0 0
1 1 0
1 1 1

Sample Output-1:
----------------
2

Explanation:
------------
One of the possibility of layout of the buildings is:
0 1 2
0 0 1
0 0 0
So, the maximum number of floors of a building is 2.


Sample Input-2:
---------------
3 4
1 0 0 0
1 0 0 0
1 1 0 0

Sample Output-2:
----------------
3

Explanation:
------------
One of the possibility of layout of the buildings is:
0 1 2 3
0 1 2 3
0 0 1 2
So, the maximum number of floors of a building is 3.
*/

import java.util.*;

class Solution
{
    static int max = Integer.MIN_VALUE;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean vis[][] = new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int x = sc.nextInt();
                if(x==1)
                {
                    q.offerLast(new int[]{i,j});
                    vis[i][j]=true;
                }
            }
        }
        System.out.println(getMaxFloorHeight(q,vis,m,n));
    }
    public static int getMaxFloorHeight(ArrayDeque<int[]> q,boolean[][] vis,int m,int n)
    {
        int count=-1;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty())
        {
            int len = q.size();
            while(len>0)
            {
                len--;
                int temp[] = q.pollFirst();
                int x = temp[0];
                int y = temp[1];
                for(int a[] : dirs)
                {
                    int new_X = a[0]+x;
                    int new_Y = a[1]+y;
                    if(new_X>=0 && new_X<m && new_Y>=0 && new_Y<n && !vis[new_X][new_Y])
                    {
                        vis[new_X][new_Y]=true;
                        q.offerLast(new int[]{new_X,new_Y});
                    }
                }
            }
            count++;
        }
        return count;
    }
}