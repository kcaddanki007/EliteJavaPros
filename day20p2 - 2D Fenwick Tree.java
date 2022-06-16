/*Somasekharam is given a 2D grid of size M*N, 
the grid is filled with integers in the range of 1 to 10000:
He need to findout the sum of the elements of the sub-grid inside
the given 2D grid defined by its upper left corner (r1,c1) and
lower right corner (r2, c2).
 
Create and Implement the NumGrid class as follows:
	- NumGrid(int[][] grid) 
		- initializes the object with the integer grid.
	- int sumOfSubGrid(int r1, int c1, int r2, int c2)
		- returns the sum of the elements of sub-grid inside 
		the sub-grid defined by its upper left corner (r1, c1) 
		and lower right corner (r2, c2) .

Somasekharam is given a 2d grid of size M*N and Q queries of sumOfSubGrid.
Your task is to help Somasekharam to create and implement the NumGrid class.

Constraints:
------------
1 <= M, N, Q <= 100
0 <= r1,r2 < M
0 <= c1,c2 < N
r1<=r2
c1<=c2
 
Input Format:
-------------
Line-1: Three space separated integers M,N and Q.
Next M lines: N space separated integers, values of arr[][].
Next Q lines: four space separated integers, r1, c1, r2, c2

Output Format:
--------------
Print Q lines of integers, the sum of the elements of sub-grid.


Sample Input-1:
---------------
6 5 4
12 7 20 17 13	// 2D Grid
16 15 9 7 15
1 18 14 12 10
17 7 12 14 4
2 18 3 16 17
7 6 7 13 8
1 3 5 4		// Queries
2 2 3 3
1 2 4 3
0 4 4 4

Sample Output-1:
----------------
116
52
87
59
*/
import java.util.*;
import java.lang.*;
class day20p2{
        
        static int[][] FT;
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int m = sc.nextInt();
		  int n = sc.nextInt();
		  int q = sc.nextInt();
		  int[][] arr = new int[m][n];
		  int[] ans = new int[q];
		  FT = new int[m+1][n+1];
		  
		  for(int i=0;i<m;i++)
		     for(int j=0;j<n;j++) arr[i][j] = sc.nextInt();
		  
		  buildFT(arr,m,n);
		  
		  for(int i=0;i<q;i++){
		      int r1 = sc.nextInt(),c1 = sc.nextInt(),r2 = sc.nextInt(),c2 = sc.nextInt();
		      ans[i] = sum(r2,c2)-sum(r2,c1-1)-sum(r1-1,c2)+sum(r1-1,c1-1);
		  }
		  System.out.println(Arrays.toString(ans));
		}
		

		static void buildFT(int arr[][],int m,int n){
            for(int i=0; i<m; i++)
				for(int j=0;j<n;j++) updateFT(m,n,i,j,arr[i][j]);
        }
        
        static void updateFT(int m,int n,int i,int j, int val){
            i = i+1;
			j = j+1;
            while(i<=m){
                int j1 = j;
				while(j1<=n){
                   FT[i][j1] += val;
    			   j1 += j1 & (-j1);
                }
			 i += i & (-i);
			}
            
        }
        
        static int sum(int i,int j){
            int sum = 0; 
            i=i+1;
			j=j+1; 
            while(i>0){
                int j1 = j;
				while(j1>0){
                sum += FT[i][j1];
                j1 -= j1 & (-j1); 
             }
			 i -= i & (-i);
			}
            return sum;
        }
}        