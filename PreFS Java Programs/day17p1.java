/*
Given a number N, there is a machine which displays numbers from 1 to N in
random order.Due to some defect in the machine , it displayed a number twice 
and one number is missed.

You task is to return an array which consists the number got duplicated
and the missed number .

Input Format:
-------------
Line-1: An integer N represents size of the array.
Line-2: N space separated integers.
   
Output Format:
---------------
Print an array of 2 values.
  
Constraints:

    2 <= N <= 10^4
    1 <= a[i] <= 1000

  
Sample Input-1:
---------------
5
1 2 3 1 5
   
Sample Output-1:
----------------
1 4
  
  
Sample Input-2:
---------------
6
6 2 4 1 2 3
   
Sample Output-2:
----------------
2 5
*/

import java.util.*;
import java.lang.*;
class day17p1{
        
    
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();

          int sum = n*(n+1)/2;
          int inpSum=0;
          int NRSum=0;
          
          Set<Integer> set = new HashSet<>();

		  for(int i=0;i<n;i++){
		      int temp = sc.nextInt();
		      inpSum += temp;
		      set.add(temp);
		  }
		  
		  for( int each : set){
		      NRSum+=each;
		  }
		  
		  int missing = sum-NRSum;
		  int repeating = inpSum - NRSum;
		  
		  System.out.println(repeating+" "+missing);
	}	 
}        