/*M.P.Ahammed the founder of Malbar Gold and Diamonds merchant, announced an offer
that they will charge the minimum amount to make all the gold-biscuits into one.

Mr. Praveen, a gold supplier has different weighed gold-biscuits with him.
He wants to utilize the offer.

The processing charge to make two biscuits into one is calculated as follows:
	- To make two biscuits of weights A and B into one biscuit, 
	you have to pay the amount 'A + B'. 

Your task is to help M.P.Ahammed to keep his promise and 
to charge the minimum amount to make Mr. Praveen's gold-biscuits 
into one gold-biscuit.

Input Format:
-------------
Single line of space separated integers, number on the boxes.

Output Format:
--------------
Print an integer, minimum amount to be paid by Mr Shravan.


Sample Input-1:
---------------
4 3 6

Sample Output-1:
----------------
20


Sample Input-2:
---------------
5 2 4 3 6

Sample Output-2:
----------------
45
*/

import java.util.*;
import java.lang.*;
class day14p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String str = sc.nextLine();
          String[] stringnums = str.split(" ");
          int n = stringnums.length;
          int[] arr = new int[n];
          for(int i=0;i<n;i++) arr[i] = Integer.parseInt(stringnums[i]);
           
          int ans=0;
          for(int i=0;i<n-1;i++){
              Arrays.sort(arr);
              arr[i+1] = arr[i+1]+arr[i];
              ans+=arr[i+1];
              arr[i] = 0;
          }
          System.out.println(ans);
        }
}        

