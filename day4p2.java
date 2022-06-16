/*
There are some Warships, approaching the borders of India and curretly
situated in Bay of Bengal. One of the secret agent sent the picture of the warships.
 
The picture size is M * N, and he has marked each 1*1 part of the picture either 
with the Warships as 'W' or an empty place as 'E'. The Indian Navy want to destroy
those Warships using Torpedos, with one Torpedo you can destroy one Warship.

 The Warships are mentioned either horizontally or vertically in the picture. 
 And it is also mentioned that there are no adjacent warships.

Your target is find the number of Torpedos required to destroy all the Warships.

Input Format:
-------------
 Line-1: Two space separated integers M and N.
 Next M lines: N space separated characters, either W or E

Output Format:
--------------
Print an integer, number of torpedos required.
  
 Sample Input-1:
 ---------------
 2 3
 W E E
 W E E

Sample Output-1:
 ----------------
 1


 Sample Input-2:
---------------
 4 5
 W E E W W
 W E W E E
 W E W E W
 W E W E W
 
Sample Output-2:
----------------
 4

*/
import java.util.*;
import java.lang.*;
class day4p2{
        static boolean[][] vis;
        
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int m = sc.nextInt();
		  int n = sc.nextInt();
		  char[][] arr = new char[m][n];
		  vis = new boolean[m][n];
		  int count=0;
		  
		  for(int i=0;i<m;i++){
		     for(int j=0;j<n;j++){
		         arr[i][j] = sc.next().charAt(0);
		     } 
		  }
		     
		     for(int i=0;i<m;i++){
		         for(int j=0;j<n;j++){
		             
		             if(arr[i][j]=='W' && vis[i][j]==false){
		                 count++;
		                 vis[i][j] = true;
		                 int tempi = i;
		                 int tempj = j;
		                 
		                 if(i+1<m && arr[i+1][j] == 'W'){
		                     while(i+1<m && arr[i+1][j] == 'W'){
		                         vis[i+1][j]=true;
		                         i++;
		                     }
		                 }
		                 
		                 else if(j+1<n && arr[i][j+1] == 'W'){
		                     while(j+1<n && arr[i][j+1] == 'W'){
		                         vis[i][j+1]=true;
		                         j++;
		                     }
		                 }
		                 
		                 i = tempi;
		                 j= tempj;
		             }
		         }
		     }
		     
		     for(int i=0;i<m;i++){
		             System.out.println(Arrays.toString(vis[i]));
		         }
		     System.out.println(count);
		  	 
		}
}        

