/*Vihan is given a number N and He wants to check whether N is a converse number
or not. 
The binary form of number N is said to be converse number, if it obeys 
the following property: "every pair of adjacent digits are different". 
Your task is to help Vihan to find N is a converse number or not.
If yes, print 'true', otherwise print 'false'.

 Input Format:
 -------------
 An integer N, the positive number.

Output Format:
--------------
Print a boolean result.

 Sample Input-1:
 ---------------
 85

 Sample Output-1:
 ----------------
 true
  
 Explanation:
 ------------
 Binary Rep of 85 is 1010101 
 
 Sample Input-2:
 ---------------
  87
  
 Sample Output-2:
 ----------------
  false
 
 Explanation:
  ------------
 Binary Rep of 87 is 1010111
   
*/

//The reverse of the binary values of a binary number


import java.util.*;
import java.lang.*;
class day9p1{
        public static void main(String args[]){
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int[] arr = new int[40];
         int temp1=0;
		 int temp2=0;
		 
         while(n!=0){
			 if(temp1==temp2){
				 temp1 = n%2;
                 n= n/2; 
			 }
			 else{
				break; 
			}
				 
             
        }
   

	}	 
}      
   
   /*int count=0;
         for(int j=0;j<i-2;j++){
             if(arr[j]==arr[j+1]){
                 count++;
             }
         }
         
         if(count==0){
             System.out.println("true");
         }
         else{
             System.out.println("false");
         }
          */      
     