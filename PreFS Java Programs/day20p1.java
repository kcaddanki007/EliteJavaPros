/*
In a theatre, there are N people stand in a line for tickets, 
male represented with 1 and female represented with 0.
 
Theater management decides to issue the tickets in such a way that
if one ticket issued to a male, next ticket should be issued to a female only, 
and vice versa.
 
In order to follow it, they planned to make few alterations in the line itself, 
so that no two adjacent persons have same gender.
  
You are given a binary string S, represents intial order of the people in the line.
In one alteration, you can replace one female '0' with a  male '1' or vice versa.
 
Your task to find and print the minimum number of alterations needed 
to make the line to follow alternate gender sequence.
 
Input Format:
-------------
A binary String, S.
 
Output Format:
--------------
Print an integer, minimum number of alterations.
 

Sample Input-1:
---------------
1001

Sample Output-1:
----------------
2

 
Sample Input-2:
---------------
101101
 
Sample Output-2:
----------------
3
*/
import java.util.*;
import java.lang.*;
class day20p1{
	
	    static int minchanges(String S){
			 char[] arrS = S.toCharArray();
			 int min0=0;
			 int min1=0;
			 for(int i=0;i<S.length();i++){
				 /*
				 if(i%2==0){
			         if (arrS[i]=='0'){
			             min1++;
			         }
			         else{
			             min0++;
			         }
			     }
			     else{
			         if (arrS[i]=='0'){
			             min0++;
			         }
			         else{
			             min1++;
			         }
			     }
				 */
			     if(i%2==0 && arrS[i]=='0'){
			         min1++;
			     }
			     else{
			         min0++;
			     }
			 }
			 return Math.min(min1,min0);
			 
		}
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String S = sc.next();
		  System.out.print(minchanges(S));
	}	 
}        