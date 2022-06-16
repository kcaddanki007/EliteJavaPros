/*You are given a bunch of sticks with diffrent lengths.
All the even length sticks should be arranged to appear first in the bunch and 
all the odd length sticks should be arranged to appear first in the bunch.

Print the length of the sticks, after arranging them according to above conditions. 

Input Format:
-------------
Line-1: An integer N, number of sticks in the bunch
Line-2: N space separated integers, lengths of the sticks.

Output Format:
--------------
Print the list of length of the sticks after arrangements accordingly.


Sample Input-1:
---------------
4
1 4 3 2

Sample Output-1:
----------------
[4, 2, 1, 3]


Sample Input-2:
---------------
8
10 13 1 6 9 12 9 10

Sample Output-2:
----------------
[10, 6, 12, 10, 13, 1, 9, 9]
*/


import java.util.*;
import java.lang.*;
class day3p3{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int[] arr = new int[n];
		  for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		  
	
		  for(int i=1;i<n;i++){
		      if(arr[i]%2==0){
		          int val=arr[i];
		          int ptr=i;
		          while(i>0 && arr[i-1]%2 != 0 ){
		              arr[i] = arr[i-1];
		              i--;
		          }
		          arr[i]=val;
		          i=ptr;
		      }
		  }
		  System.out.println(Arrays.toString(arr));
		}
}        

