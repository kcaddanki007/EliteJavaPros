/*Line-1: AN integer N.
Line-2: N space separated integers, indicates marks[]

Output Format:
--------------
Print the marks after seating order changed.


Sample Input-1:
---------------
5
0 1 0 3 12

Sample Output-1:
----------------
[1, 3, 12, 0, 0]


Sample Input-2:
---------------
8
3 0 5 7 0 8 3 1

Sample Output-2:
----------------
[3, 5, 7, 8, 3, 1, 0, 0]
*/

//using a counter variable's value to traverse a different array

import java.util.*;
class day5p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int count=-1;
          int[] arr = new int[n];
          for(int i=0;i<n;i++){
              int s = sc.nextInt();
              if(s!=0){
                  count++;
                  arr[count]=s;
              }
          }
          for(int i=count+1;i<n;i++){
              arr[i]=0;
          }
          System.out.println(Arrays.toString(arr)); 
          
        }
}        
