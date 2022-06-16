/*Due to COVID-19 impact, to attract people to watch the movies in theatre,
One of the Theatre management introduced a scheme 
to give mobiles for Lucky winners after the show.

The theatre has M rows and N seats in each row.
The seats are numbered in a strange order (No duplicates).

You need to find out the Lucky Winners  in such way that, the seat number 
of the person should be the minimum in its row and maximum in its column.

You have to return all seat numbers of lucky winners .

Input Format:
-------------
Line-1 -> Two integers M and N
Next M lines -> N space separated integers, seat numbers.

Output Format:
--------------
Print the list of seat numbers of Lucky Winners.


Sample Input-1:
---------------
3 3
3 7 8
9 11 13
15 16 17

Sample Output-1:
----------------
15


Sample Input-2:
---------------
3 4
1 10 4 2
9 3 8 7
15 16 17 12

Sample Output-2:
----------------
12
*/
import java.util.*;
class day52p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int m = sc.nextInt();
		  int n = sc.nextInt();
		  int[][] arr = new int[m][n];
		  for(int i=0;i<m;i++)
		      for(int j=0;j<n;j++) arr[i][j] = sc.nextInt();
		  System.out.println(getLucky(arr,m,n));
		}
        static int getLucky(int[][] arr,int m,int n){
		    
		    Set<Integer> s = new HashSet<>();
		    for(int i=0;i<m;i++){
		        int rmin=Integer.MAX_VALUE;
		        for(int j=0;j<n;j++) rmin = Math.min(rmin,arr[i][j]);
		        s.add(rmin);
		    }
		    for(int j=0;j<n;j++){
		        int cmax=Integer.MIN_VALUE;
		        for(int i=0;i<m;i++) cmax = Math.max(cmax,arr[i][j]);
		        if(s.contains(cmax)) return cmax;
		    }
		   return 0;
		}
}     