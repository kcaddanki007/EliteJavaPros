/*Arjun wants to build a swimming pool, in the backyard of his farm-house.
The backyard has an empty land of size m*n. 
Some part of the backyard is used to build the swimming pool
You will be given the m*n grid values (0's and 1's). 
where 1 indicates swimming pool, and 0 indiactes empty land.

Your task to find the perimeter of the swimming pool.

Note: There is only one swimming pool.

Input Format:
-------------
Line-1: Two integers M and N, size of the backyard.
Next M lines: N space separated integers, either 0 or 1
0- represents empty land and 1- represents the swimming pool 

Output Format:
--------------
Print an integer, the perimeter of the swimming pool


Sample Input-1:
---------------	
4 4
0 1 0 0
1 1 1 0
0 1 0 0
1 1 0 0
 
Sample Output-1:
----------------
16


Sample Input-2:
---------------
1 2
1 0
 
Sample Output-2:
----------------
4

For explanation of sample test cases given refer Hint-1.
*/
import java.util.*;
class day58p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int m = sc.nextInt();
		  int n = sc.nextInt();
		  int[][] arr = new int[m][n];
		  for(int i=0;i<m;i++)
		     for(int j=0;j<n;j++)
		        arr[i][j] = sc.nextInt();
		  System.out.println(getPerimeter(arr,m,n));
		}
		static int getPerimeter(int[][] arr,int m,int n){
		    int count=0;
		    for(int i=0;i<m;i++){
		        for(int j=0;j<n;j++){
		            if(arr[i][j]==1){
		                count+=4;
		                if(check(m,n,i-1,j) && arr[i-1][j]==1) count--;
		                if(check(m,n,i+1,j) && arr[i+1][j]==1) count--;
		                if(check(m,n,i,j-1) && arr[i][j-1]==1) count--;
		                if(check(m,n,i,j+1) && arr[i][j+1]==1) count--;
		            }
		        }
		    }
		    return count;
		}
		static boolean check(int m,int n,int i,int j){
		    if(i<0 || j<0 || i>=m || j>=n) return false;
		    return true;
		}
}     
 