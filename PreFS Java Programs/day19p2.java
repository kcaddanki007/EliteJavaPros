/*
There are n boxes in a row. row[i] is the number printed on ith box(0-indexed).
Your task is to find the smallest index  I of the row, 
where row[I] equals to the remainder when you divide I with 10.

If no such index found, print -1.

Constraints:

    1 <= n <= 100
    0 <= row[i] <= 9


 
Input Format:
-------------
Line-1: An integer n, number of boxes.
Line-2: n space separated integers represent numbers printed on the boxes
in the row.
 
Output Format:
--------------
Print an integer, smallest index possible.
 
 
Sample Input-1:
---------------
5
2 1 2 3 5
 
Sample Output-1:
----------------
1
 
Sample Input-2:
---------------
5
4 3 1 5 2

Sample Output-2:
----------------
-1
 
*/   
import java.util.*;
import java.lang.*;
class day19p2{
	
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int[] arr = new int[n];
          for(int i=0;i<n;i++){
              arr[i]=sc.nextInt();
          }
          int count=0;
          for(int i=0;i<n;i++){
              
              if(i%10==arr[i]){
                  System.out.println(i);
                  count++;
                  break;
              }
          }
          if(count==0){
              System.out.println(-1);
          }
	}	 
}       