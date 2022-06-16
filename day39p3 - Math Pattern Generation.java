/*Mohan is given a task to decorate a wall with balloons.
He is given an unlimited set of ballons of three different colors.

The decoration should have N rows of 3 balloons each. 
He has to make sure that no two adjacent balloons have the same colour.
both vertically and horizontally.

Your task is to help Mr Mohan to find the number of ways to decorate the wall,  
the answer must be computed modulo 10^9 + 7

Input Format:
-------------
An integer N

Output Format:
--------------
Print an integer as output, number of ways to decorate.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
12

Explanation:
------------
Suppose the colors are, B-Blue, W-White, R-Red. Given N is 1
RBR	BRB	WRB
RBW	BRW	WRW
RWR	BWR	WBR
RWB	BWB	WBW


Sample Input-2:
---------------
2

Sample Output-2:
----------------
54
*/
import java.util.*;
import java.lang.*;
class day39p3{
        static long mod=1000000007;
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  System.out.println(getComb(n));
		}
		static int getComb(int n){
		    long firstcolor2 =6, firstcolor3=6;
		    for(int i=1;i<n;i++){
		        long nextcolor2 = firstcolor2*3 + firstcolor3*2;
		        long nextcolor3 = firstcolor2*2 + firstcolor3*2;
		        firstcolor2 = nextcolor2%mod;
		        firstcolor3 = nextcolor3%mod;
		    }
		    return (int)((firstcolor2+firstcolor3)%mod);
		}
} 