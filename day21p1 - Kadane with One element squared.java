/*Aziz is given a set of integers SOI[], consists of both +ve and -ve integers.

Aziz wants to find the maximum sum of contiguous subset of the SOI, with a twist.

You have to perform the following operation before finding the maximum sum:
- You are allowed to replace exactly one integer X, with its square value (X*X).

Can you please help Aziz to find out the maximum sum of contiguous subset.


Input Format:
-------------
Single line of space separated integers, values of the array.

Output Format:
--------------
Print an integer value as result.


Sample Input-1:
---------------
-5 -3 1 2 -3 4 -4 3

Sample Output-1:
----------------
26

Explanation:
------------
max sum is: (-5)^2 + (-3) + 1 + 2 + (-3) + 4 = 26


Sample Input-2:
---------------
2 -2 2 2 -2 -2 2

Sample Output-2:
----------------
10

Explanation:
------------
max sum is: 2 +(-2)^2 + 2 + 2 = 10
*/
import java.util.*;
import java.lang.*;
class day21p1{
        public static void main(String args[]){
            
          Scanner sc = new Scanner(System.in);
          String str = sc.nextLine();
          String[] stringnums = str.split(" ");
          int n = stringnums.length;
          int[] arr = new int[n];
          
          for(int i=0;i<n;i++) arr[i] = Integer.parseInt(stringnums[i]);
          
          System.out.println(getSum(arr,n));
		}
		
		static int getSum(int[] arr,int n){
		    int[] sumarr = new int[n];
		    int[] sumsqrarr = new int[n];
		    int max = Integer.MIN_VALUE;
		    sumarr[0] = arr[0];
		    sumsqrarr[0] = arr[0]*arr[0];
		    
		    for(int i=1;i<n;i++){
		        sumarr[i] = Math.max(arr[i],arr[i]+sumarr[i-1]);

		        sumsqrarr[i] = Math.max(sumsqrarr[i-1]+arr[i],Math.max(arr[i]*arr[i],sumarr[i-1] + arr[i]*arr[i]));
		        
		        max = Math.max(max,Math.max(sumarr[i],sumsqrarr[i]));
		    }
		    
		    return max;
		}
}        
