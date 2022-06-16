/*You will be given the matrix of size R*C,

You have to return the matrix in special order as shown in the sample tescases.
 

Input Format:
-------------
Line-1 -> Two integers R and C, size of matrix.
Next R-Lines -> C space separated integers

Output Format:
--------------
Print R-Lines -> C space separated integers, in special order.


Sample Input-1:
---------------
3 3
1 2 3
4 5 6
7 8 9

Sample Output-1:
----------------
1 2 3
6 9 8
7 4 5


Sample Input-2:
---------------
3 4
1 2 3 4
5 6 7 8
9 10 11 12

Sample Output-2:
----------------
1 2 3 4
8 12 11 10
9 5 6 7
*/

import java.util.*;
class day53p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int r = sc.nextInt();
		  int c = sc.nextInt();
		  int[][] arr = new int[r][c];
		  boolean[][] vis = new boolean[r][c];
		  
		  for(int i=0;i<r;i++)
		    for(int j=0;j<c;j++) arr[i][j] = sc.nextInt();
		    
		  int n=r*c;
		  int i=0, j=0;
		  ArrayList<Integer> list = new ArrayList<>();
		  
		  while(n!=0){
		     while(j<c && !vis[i][j]){
		         list.add(arr[i][j]);
		         vis[i][j]=true;
		         j++;
		         n--;
		     }
		     j--;
		     i++;
		     while(i<r && !vis[i][j]){
		         list.add(arr[i][j]);
		         vis[i][j]=true;
		         i++;
		         n--;
		     }
		     i--;
		     j--;
		     while(j>=0 && !vis[i][j]){
		         list.add(arr[i][j]);
		         vis[i][j]=true;
		         j--;
		         n--;
		     }
		     j++;
		     i--;
		     while(i>=0 && !vis[i][j]){
		         list.add(arr[i][j]);
		         vis[i][j]=true;
		         i--;
		         n--;
		     }
		     i++;
		     j++;
		  } 
		  int k=0;
		  for(i=0;i<r;i++){
		      for(j=0;j<c;j++){
		           System.out.print(list.get(k++)+" ");
		      }
		      System.out.println(" ");
		  }
		  
		}
}     