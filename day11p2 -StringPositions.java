/*Given a string S in encoded form, and  an integer array indices[] of string length.

You need to find the decoded form of String S, 
by moving each character at ith position in S, to indices[i] position in decoded string.
and then print the decoded string.

Input Format:
-------------
Line-1 -> A String S, enocded string of length L, 
          S conatins only lowercase alphabets [a-z]
Line-2 -> L space separated integers indices[], where 0 <=indices[i] < L 

Output Format:
--------------
Print a String, decoded string.


Sample Input-1:
---------------
aeilmmor
6 1 5 7 2 0 3 4

Sample Output-1:
----------------
memorial

Explanation:
---------------
Given String, a e i l m m o r
			  6 1 5 7 2 0 3 4
after shifting,	memorial


Sample Input-2:
---------------
aidin
4 3 2 0 1

Sample Output-2:
----------------
india

Explanation-2:
---------------
Given String, a i d i n
			  4 3 2 0 1
after shifting,	india
*/
import java.util.*;
import java.lang.*;
class day11p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String str = sc.nextLine();
         
          String nums = sc.nextLine();
          String[] stringnums = nums.split(" ");
          
          int[] pos = new int[stringnums.length];
          char[] word = new char[stringnums.length];
          
          for(int i=0;i<stringnums.length;i++)
             pos[i] = Integer.parseInt(stringnums[i]);
		  
		  for(int i=0;i<stringnums.length;i++){
		      word[pos[i]] = str.charAt(i);
		  }
		  
		  for(int i=0;i<stringnums.length;i++){
		      System.out.print(word[i]);
		  }
		}
}        

