/*You are given a set of N integers, and a value to find F. Initially a variable, 
'total' is set to 0. You can perform either addition(+) or subtraction(-)
of every integer from the set to the 'total'. The resultant total should be
equal to the value F.

Your task is to find out the number of ways, you can make the 'total' equal to
the value F.

Input Format:
-------------
Line-1: Two integers N and F.
Line-2: N space separated integers 

Output Format:
--------------
Print an integer, number of ways.


Sample Input:
---------------
5 3
1 1 1 1 1

Sample Output:
----------------
5

Explanation:
------------
total = -1+1+1+1+1 = 3 -> total=value-F
total = +1-1+1+1+1 = 3 -> total=value-F
total = +1+1-1+1+1 = 3 -> total=value-F
total = +1+1+1-1+1 = 3 -> total=value-F
total = +1+1+1+1-1 = 3 -> total=value-F

NOTE: + means addition, - means subtraction
*/
import java.util.*;
import java.lang.*;
class day48p3{
    static int count=0;
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt(),f=sc.nextInt();
		  int[] arr = new int[n];
		  for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		  getMaxWays(n,f,arr,0);
		  System.out.println(count);
		}
		static void getMaxWays(int n, int f,int[] arr,int p){
		    if(p==n && f==0) count++;
		    else if(p<n){
		        getMaxWays(n,f-arr[p],arr,p+1);
		        getMaxWays(n,f+arr[p],arr,p+1);
		    }
		}
}     