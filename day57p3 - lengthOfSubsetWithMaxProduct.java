/*
Ashok is given a list of integers nums[].
His task is to find the longest contiguous sublist of S, 
the product of all the numbers in the sublist should be positive.

Your task is to return the length of longest contiguous sublist.

Input Format:
-------------
Space separated integers nums[], list of numbers.

Output Format:
--------------
Print the length of the longest contiguous sublist


Sample Input-1:
---------------
1 -1 2 -2

Sample Output-1:
----------------
4


Sample Input-2:
---------------
-1 -2 -3 0 1

Sample Output-2:
----------------
2

Explanation:
------------
0 is not considered as positive number.


Sample Input-3:
---------------
1 2 3 4 -5 6  7 8

Sample Output-3:
----------------
4
*/
import java.util.*;
class day57p3{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String[] stringnums = sc.nextLine().split(" ");
          int n = stringnums.length;
          int[] arr = new int[n];
          for(int i=0;i<n;i++) arr[i] = Integer.parseInt(stringnums[i]);
          
          System.out.println(getLen(arr,n));
		}
		static int getLen(int[] arr,int n){
		    int pos= 0, neg = 0;    
            int ans = 0;
            for(int i=0;i<n;i++) {
                if(arr[i] == 0){
                    pos = 0;
                    neg = 0;
                }
                else if(arr[i] > 0){
                    pos++;
                    neg = (neg == 0)? 0 : neg+1;
                }
                else{
                    int temp=pos;
                    pos = (neg == 0)? 0:neg+1;
                    neg = temp+1;
                }
                ans = Math.max(ans, pos);
        }
        return ans;
		}
}     
 