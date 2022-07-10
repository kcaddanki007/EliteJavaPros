/*Mr Crazy Robert is given in integer array arr[], where arr[i] value is between [0,9]
For example: if the arr[]=[1, 2, 3, 4], then the number can be formed is N=1234.
Now, increment the value of N by 1, and the resultant array is arr[]= [1, 2, 3, 5]
 
Your task is to help Mr Crazy Robert, to increment the number formed using arr[]
and print the resultant array.
 
Note: There should be no leading zeros in the number/array[]
  
Input Format:
-------------
N space separated integers, array[] the integers are in the range of [0,9].
 
Output Format:
--------------
Print the integer array, resultant array.


Sample Input-1:
---------------
1 2 3 4
 
Sample Output-1:
----------------
1 2 3 5
 
 
Sample Input-2:
---------------
1 2 9 9

Sample Output-2:
----------------
1 3 0 0
 
 
Sample Input-3:
---------------
 9 9 9
 
Sample Output-3:
----------------
 1 0 0 0*/
 
 //Taking variable number of integers through input without knowing how many ints are actually there
 
 
 //can use this approach and another approach is to use hasnext
 /*Scanner sc = new Scanner(System.in);
	    String S = sc.nextLine();
	    Scanner scn = new Scanner(S);
	    while(scn.hasNext()){
	        System.out.println(scn.next());*/
 
import java.util.*;
import java.lang.*;
class day10p1{
        
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String str = sc.nextLine();
          int countof9=0;
          String[] stringnums = str.split(" ");
          int[] nums = new int[stringnums.length+1];
          
          int actlen=stringnums.length;
          
          for(int i=0;i<actlen;i++){
              nums[i] = Integer.parseInt(stringnums[i]);
          }
          
          for(int i=0;i<actlen;i++){
              if(nums[i]==9){
                  countof9++;
              }
          }
          
          int n=actlen-1;
          if(countof9==actlen){
              nums[0]=1;
              for(int i=1;i<=actlen;i++){
                  nums[i]=0;
              }
            actlen++;  
          }
          else{
              nums[n]+=1;
              if(nums[n]==10){
                 while(nums[n]==10){
                     nums[n]=0;
                     nums[n-1]+=1;
                     n--;
                 }
              }
             
          }
          
          
        for(int i=0;i<actlen;i++){
            System.out.print(nums[i]+" ");
        }

	}	 
}        