/*The laser show at Lumbini park started online bookings,
It is an open theater having n rows of seats, each row consist of 10 seats.
The seats are labelled from 1 to 10 numbers, as shown below.

	Row	1 2 3	4 5 6 7 	8 9 10
		1	_ _ _	_ _ _ _		_ _ _
		2	_ _ _	_ _ _ _		_ _ _
		......
		n	_ _ _	_ _ _ _		_ _ _

You will be given n value, and a list of booked seats booked[],
i.e, booked[x]= [i,j] indicates, i-th row j-th labelled seat is booked.

If a family-group of four members have to book the seats,
with the conditions are as follows:
	- Book four adjacent seats in a single row.
	- Seats across walkway (3 and 4) or (7 and 8) are not considered to be adjacent, 
	- There is an exceptional case on which the walkway split a four members group, 
	   in to two people on each side of walkway, like [2,3 4,5] or [6,7 8,9].
	   
Find out, the maximum number of family groups can book the seats,

	   
Input Format:
-------------
Line-1: Two integers n and b, number of rows, and number of bookings.
next b lines: two integers i, j, row number and seat number.

Output Format:
--------------
Print an intger, the number of ways.


Sample Input:
---------------
3 6
1 2
1 3
1 8
2 6
3 1
3 10

Sample Output:
----------------
4

Explanation:
------------
Row		1 2 3	4 5 6 7 	8 9 10
1	    _ x x	b b b b		x _ _
2	    _ b b	b b x _		_ _ _
3	    x b b	b b b b		b b x
		
In row-1, we can fit for 1 family-group
In row-2, we can fit for 1 family-group
In row-3, we can fit for 2 family-groups
*/
import java.util.*;
import java.lang.*;
class day49p4{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int b = sc.nextInt();
		  int[][] booked = new int[b][2];
		  for(int i=0;i<b;i++){
		      booked[i][0] = sc.nextInt();
		      booked[i][1] = sc.nextInt();
		  }
		  System.out.println(getCountOfFam(n,b,booked));
		}
		static int getCountOfFam(int n,int b,int[][] booked){
		    int[][] hall = new int[n+1][11];
		    
		    for(int i=0;i<b;i++) hall[booked[i][0]][booked[i][1]]=1;
		    int ans=0;
		    for(int i=1;i<n+1;i++){
		        int count=0;
		        if(hall[i][2]==0 && hall[i][3]==0 && hall[i][4]==0 && hall[i][5]==0) count++;
		        if(hall[i][6]==0 && hall[i][7]==0 && hall[i][8]==0 && hall[i][9]==0) count++;
		        if(count==0 && hall[i][4]==0 && hall[i][5]==0 && hall[i][6]==0 && hall[i][7]==0) count++;
		        ans+=count;
		    }
		    return ans;
		}
}     