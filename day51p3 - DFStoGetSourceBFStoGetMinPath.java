/*Pandavas and Kauravas are ruling two different kingdoms sepertaed by river.
If you connect both the kingdoms they will be in Square shaped land.
Land occupied by the kingdoms, indiacted with 1's and the river, indiacted with 0's.

Now, Pandavas and Kauravas decided to build a bridge on the river for easy 
connectivity. As the cost of building a bridge will be high, they have decided 
to reduce the length of the bridge. You are allowed to build the bridge on 
the river cells, connected by 4 directions only (up, down,left,right).

Your task is to help the Kings, to minimize the occupation of river cells, 
to build the bridge with minimum cost. And return the count of river cells occupied.

Input Format:
-------------
Line-1: An integer N, size of the land.
Next N lines: N space separated integers, either 0 or 1. 

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
4

1 1 1 0
1 0 0 0
1 0 0 1
0 0 1 1


Sample Output-1:
----------------
2


Sample Input-2:
---------------
5
1 1 0 0 0
1 1 0 0 0
1 1 0 0 1
0 0 0 1 1
0 0 1 1 1

Sample Output-2:
----------------
3
*/
import java.util.*;
class day51p3{
          static int n;
          static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
          static boolean[][] vis;
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  n = sc.nextInt();
		  vis = new boolean[n][n];
		  int[][] arr = new int[n][n];
		  for(int i=0;i<n;i++)
		    for(int j=0;j<n;j++) arr[i][j] = sc.nextInt();
		  System.out.println(getMinDist(arr,n));
		}
		static int getMinDist(int[][] arr,int n){
		    ArrayList<int[]> source = sourceBFS(arr,n);
		    int count=0;
		    
		    ArrayDeque<int[]> adq = new ArrayDeque<>();
            for(int i=0;i<source.size();i++) adq.add(source.get(i));
            
            while(!adq.isEmpty()){
                count++;
                int adqsize=adq.size();
                for(int j=0;j<adqsize;j++){
                    int[] temp= adq.pollFirst();
                    //break case;
                    for(int i=0;i<4;i++){
                        int r = temp[0]-dir[i][0];
                        int c = temp[1]-dir[i][1];
                        if(isPoss(r,c) && arr[r][c]==1){
                            return count-1;
                        }
                    }
                    for(int i=0;i<4;i++){
                        int r = temp[0]-dir[i][0];
                        int c = temp[1]-dir[i][1];
                        if(isPoss(r,c) && arr[r][c]==0){
                            vis[r][c]=true;
                            adq.add(new int[]{r,c});
                        }
                    }
                }
            }
            return 0;
		}
		
		static ArrayList<int[]> sourceBFS(int[][] arr,int n){
		    ArrayList<int[]> ans = new ArrayList<>();
            ArrayDeque<int[]> adq = new ArrayDeque<>();
            vis[0][0] = true;
            adq.add(new int[]{0,0});
            ans.add(new int[]{0,0});
            while(!adq.isEmpty()){
                int adqsize=adq.size();
                for(int j=0;j<adqsize;j++){
                    int[] temp= adq.pollFirst();
                    for(int i=0;i<4;i++){
                        int r = temp[0]-dir[i][0];
                        int c = temp[1]-dir[i][1];
                        if(isPoss(r,c) && arr[r][c]==1){
                            vis[r][c]=true;
                            adq.add(new int[]{r,c});
                            ans.add(new int[]{r,c});
                        }
                    }
                }
            }
            return ans;
		}
		static boolean isPoss(int r,int c){
		    if(r>=n || c>=n || r<0 || c<0 || vis[r][c]) return false;
		    return true;
		}
}     