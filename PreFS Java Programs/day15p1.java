/*
Narayana is given a positive number N.
His task is to find a value P such that the value of (N - P*P) is 0.
If P can be found, print "true". Otherwise print "false".
 
Note : Do not use built-in methods.
Solve it in O(log(N)) time.
 
Input Format:
-------------
An integer N.
 
Output Format:
--------------
Print a boolean value.
 
 
Sample Input-1:
---------------
9
 
Sample Output-1:
----------------
true
 
 
Sample Input-2:
---------------
15
 
Sample Output-2:
----------------
false
*/

import java.util.*;
import java.lang.*;
class day15p1{
    
       static long BSS(long l, long r, long x){
        if (r >= l) {
            long mid = l + (r - l) / 2;
            if (mid*mid == x){
                return mid;
            }
            if (mid*mid > x){
                return BSS(l, mid - 1, x);
            }
            else{
                return BSS(mid + 1, r, x);
            }  
        }
        return -1;
    }
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          long n = sc.nextLong();
          if(BSS(1,n/2,n)==-1){
              System.out.println("false");
          }
          else{
              System.out.println("true");
          }
		  
	}	 
}        