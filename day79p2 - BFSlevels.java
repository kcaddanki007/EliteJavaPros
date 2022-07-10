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
class Solution{
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] land = new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
              land[i][j] = sc.nextInt();
              
        System.out.println(BFS(land,r,c));
    }
    static int BFS(int[][] land,int r,int c){
        int count=-1;
        boolean vis[][] = new boolean[r][c];
        ArrayDeque<int[]> adq = new ArrayDeque<>();
        
        for(int i=0;i<r;i++)
          for(int j=0;j<c;j++)
            if(land[i][j]==1){
                adq.offer(new int[]{i,j});
                vis[i][j] = true;
            }
        
        while(!adq.isEmpty()){
            int adqsize = adq.size();
            count++;
            for(int i=0;i<adqsize;i++){
                int[] curr = adq.poll();
                for(int[] d : dirs){
                    int x = curr[0]+d[0];
                    int y = curr[1]+d[1];
                    if(isPoss(x,y,r,c,vis)){
                        adq.offer(new int[]{x,y});
                        vis[x][y] = true;
                    }
                }
            }
        }
        return count;
          
    }
    static boolean isPoss(int i,int j,int r,int c,boolean[][] vis){
        if(i<0 || i>=r || j<0 || j>=c || vis[i][j]) return false;
        else return true;
    }
}