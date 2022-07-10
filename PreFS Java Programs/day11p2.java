/*
ABC company is transmitting its binary data to another server. 
To secure the data against malicious activity, they plan to encrypt the data
by switching 0's to 1's and 1's to 0's.

Return the encrypted data in decimal representation.

 Input Format:
    -------------
 An integer, represents the decimal form of binary data..
    
Output Format:
--------------
Print an integer result.
    
    
Sample Input-1:
---------------
 12  

Sample Output-1:
----------------
 3
   
Explanation: 
------------
12= 1100 will become 0011=3
   
   
 Sample Input-2:
 ---------------
 23
   
 Sample Output-2:
 ----------------
  8
 Explanation: 
 ------------
 23= 10111 will become 01000=8
   
   
*/

//Using parseint to convert binary to integer and integer to binary string;
import java.util.*;
import java.lang.*;
class day11p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          String S1 = Integer.toBinaryString(n);
          char[] carr = S1.toCharArray();
          StringBuilder sb = new StringBuilder();
          for(int i=0;i<carr.length;i++){
              if(carr[i]=='1'){
                  sb.append('0');
              }
              else{
                  sb.append('1');
              }
          }
          String s2 = sb.toString();
          System.out.println(Integer.parseInt(s2,2));
          
	}	 
}        