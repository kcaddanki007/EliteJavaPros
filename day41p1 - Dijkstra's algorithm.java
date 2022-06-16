/*Amith decided go on a holiday trip. 
Given a map of N holiday spots numbered 0,1,2,.. N-1, map shows the connecting 
routes between the holiday sopts, the routes are bidirectional, and
the connecting routes are indicates as routes[i] = [from , to , distance ]. 
He can travel only a certian distance D.

Your task is to find the holiday spot H with the smallest number of holiday-spots
that are reachable from H and whose distance is at most D, 

If there are multiple holiday spots, return H with the greatest number.


Input Format:
-------------
Line-1 : Three integers, N number of holiday spots, R is the number of connecting 
        routes and D is the distance can travel.
Next R lines : Three space separated integers, from , to and distance.

Output Format:
--------------
Print an integer, holiday spot.


Sample Input-1:
---------------
4 4 4
0 1 3
1 2 1
1 3 4
2 3 1

Sample Output-1:
----------------
3


Explanation:
------------
Distance can travel= 4,

From			Reachable sopts
-------------------------------------
Holiday-spot 0 -> [Holiday-spot 1, Holiday-spot 2] 
Holiday-spot 1 -> [Holiday-spot 0, Holiday-spot 2, Holiday-spot 3] 
Holiday-spot 2 -> [Holiday-spot 0, Holiday-spot 1, Holiday-spot 3] 
Holiday-spot 3 -> [Holiday-spot 1, Holiday-spot 2] 

Holiday-spots 0 and 3 have 2 reachable Holiday-spots at a distance = 4, 
but we have to return Holiday-spot 3 since it has the greatest number.


Sample Input-2:
---------------
5 6 2
0 1 2
0 4 8
1 2 3
1 4 2
2 3 1
3 4 1

Sample Output-2:
----------------
0

Explanation:
------------
Distance can travel= 2,

From			Reachable sopts
-------------------------------------
Holiday-spot 0 -> [Holiday-spot 1] 
Holiday-spot 1 -> [Holiday-spot 0, Holiday-spot 4] 
Holiday-spot 2 -> [Holiday-spot 3, Holiday-spot 4] 
Holiday-spot 3 -> [Holiday-spot 2, Holiday-spot 4]
Holiday-spot 4 -> [Holiday-spot 1, Holiday-spot 2, Holiday-spot 3]

Holiday-spots 0 has 1 reachable Holiday-spot at a distance = 2, 
*/
import java.util.*;
import java.lang.*;
class day41p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int N = sc.nextInt(),R = sc.nextInt(), D = sc.nextInt();
		  int[][] map = new int[N][N];
		  
		  for(int i=0;i<N;i++){ 
		      Arrays.fill(map[i],10000);
		  }
		  
		  for(int i=0;i<R;i++){
		      int r = sc.nextInt(), c=sc.nextInt(), d=sc.nextInt();
		      map[r][c] = map[c][r] = d;
		  }
		  //for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
		  //System.out.println(" ");
		  System.out.println(dijsktras(map,N,D));
		}
		
		static int dijsktras(int[][] map,int N,int D){
		    
		    for(int i=0;i<N;i++){           //source
		       map[i][i] = 0;
		       boolean[] vis = new boolean[N];
		       vis[i] = true;
		       
		       while(true){
		           int minDist = 10001,ind=-1;
		           
		           for(int j=0;j<N;j++){
		           if(!vis[j] && map[i][j]<minDist){ 
		               minDist = map[i][j];
		               ind=j;
		           }     
		       }
		       if(minDist==10001) break;
		       vis[ind] = true;
		       for(int k=0;k<N;k++){
		           if(map[i][ind]+map[ind][k] < map[i][k]) map[i][k] = map[i][ind] + map[ind][k];
		       }
		       }
		    }
		    
		    //for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
		    
		    int min = N+1, ans=-1;
		    for(int i=0;i<N;i++){
		        int count=0;
		        for(int j=0;j<N;j++) if(map[i][j]<=D) count++;
		        
		        if(min>=count){
		            min = count;
		            ans = i;
		        }
		    }
		    return ans;
		}
} 