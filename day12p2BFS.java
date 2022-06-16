/*Brahmi and his gang was chased by group of police officers, unfortunately 
they all got locked up in a building consist of M*N rooms in the form of 
a grid. All the rooms are connected with  the adjacent rooms both horizontally
and vertically. There are few rooms for them to escape called as safe zones. 

Now help Brahmi and his gang to reach the safe zones in the building.

In the Building we have the rooms filled with following values: [0,-1,-2] 
where, -1 -> Danger zone (they should not enter into it).
0 -> Safe Zone (room to escape)
-2 -> a thief

Now create a method to print the grid after performing following step: 
Fill each room with one of the member from The Brahmi and his gang with 
the distance to its nearest safe zone.
If it is impossible to reach a safezone, fill with '-2' only.

Input Format:
-------------
Line-1 -> two integers M and N, size of the grid of rooms.
Next M Lines -> N space separated integers, from this set [-2,-1,0] only.

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
4 4
-2 -1 0 -2
-2 -2 -2 -1
-2 -1 -2 -1
0 -1 -2 -2

Sample Output-1:
----------------
3 -1 0 1
2 2 1 -1
1 -1 2 -1
0 -1 3 4

*/
import java.util.*;
import java.lang.*;
class day12p2{
        static boolean[][] vis;
        static int val=0;
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int m = sc.nextInt();
		  int n = sc.nextInt();
		  int[][] arr = new int[m][n];
		  vis = new boolean[m][n];
		  
		  for(int i=0;i<m;i++)
		     for(int j=0;j<n;j++) arr[i][j] = sc.nextInt();
		     
		     
		  for(int i=0;i<m;i++)
		      for(int j=0;j<n;j++){
		          if(arr[i][j]==0) BFS(arr,i,j,m,n);
		          val=0;
		      } 
		      
         for(int i=0;i<m;i++){
		      for(int j=0;j<n;j++) System.out.print(arr[i][j]+" ");
		 System.out.print("\n");     
		}

        }
		static void BFS(int[][] arr,int i,int j,int m,int n){
		    ArrayDeque<Integer> qi = new ArrayDeque<>();
		    ArrayDeque<Integer> qj = new ArrayDeque<>();
		    qi.offerLast(i);
		    qj.offerLast(j);
		    
		    while(!qi.isEmpty()){
		      int size = qi.size();
		      val++;
		      for(int it=0;it<size;it++){
		         int tempi = qi.pollFirst();
		         int tempj= qj.pollFirst();
		         
		         if(tempi+1<m && (arr[tempi+1][tempj]==-2 || arr[tempi+1][tempj]>0) && vis[tempi+1][tempj]==false){
		             vis[tempi+1][tempj]=true;
		             if(arr[tempi+1][tempj]>0)
		                arr[tempi+1][tempj]=Math.min(val,arr[tempi+1][tempj]);
		             else       
		                arr[tempi+1][tempj]=val;
		             qi.offerLast(tempi+1);
		             qj.offerLast(tempj);
		         }
		         if(tempi-1>-1 && (arr[tempi-1][tempj]==-2 || arr[tempi-1][tempj]>0) && vis[tempi-1][tempj]==false){
		             vis[tempi-1][tempj]=true;
		             if(arr[tempi-1][tempj]>0)
		                arr[tempi-1][tempj] = Math.min(val,arr[tempi-1][tempj]);
		             else 
		                arr[tempi-1][tempj]=val; 
		             qi.offerLast(tempi-1);
		             qj.offerLast(tempj);
		         }
		         if(tempj+1<n && (arr[tempi][tempj+1]==-2 || arr[tempi][tempj+1]>0) && vis[tempi][tempj+1]==false){
		             vis[tempi][tempj+1]=true;
		             if(arr[tempi][tempj+1]>0)
		               arr[tempi][tempj+1] = Math.min(arr[tempi][tempj+1],val);
		             else 
		               arr[tempi][tempj+1]=val;
		             qi.offerLast(tempi);
		             qj.offerLast(tempj+1);
		         }
		         if(tempj-1>-1 && (arr[tempi][tempj-1]==-2 || arr[tempi][tempj-1]>0) && vis[tempi][tempj-1]==false){
		             vis[tempi][tempj-1]=true;
		             if(arr[tempi][tempj-1]>0)
		               arr[tempi][tempj-1] = Math.min(arr[tempi][tempj-1],val);
		             else
		              arr[tempi][tempj-1]=val;
		             qi.offerLast(tempi);
		             qj.offerLast(tempj-1);
		         }
		      }
		    
		    } 
		    for(int vali=0;vali<m;vali++)
		      for(int valj=0;valj<n;valj++) vis[vali][valj] = false;
		}
}        

