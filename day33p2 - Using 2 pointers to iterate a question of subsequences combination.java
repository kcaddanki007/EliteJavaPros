/*Kiran is playing with strings and its subsequences.
A subsequence can be formed from a string by deleting some characters
(may be string itself)

Kiran has given two strings S and T, your task to form T by concatenating 
the subsequences of S  

Return the minimum number of subsequences required to form T.
If the task is impossible, return -1 .


Input Format:
-------------
Line-1 -> Two strings S and T

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
abc abcbc

Sample Output-1:
----------------
2

Explanation: 
------------
T = "abcbc" can be formed by "abc" and "bc",
which are subsequences of S = "abc".


Sample Input-2:
---------------
abc acdbc

Sample Output-2:
----------------
-1

Explanation: 
------------
string T cannot be constructed from the
subsequences of string S due to the character "d" in string T.
*/

import java.util.*;
import java.lang.*;
class day33p2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		
		System.out.println(isPossible(s1,s2));
		}
		
		static int isPossible(String s1,String s2){
		    
		    int[] arrs1 = new int[26], arrs2=new int[26];
		    
		    for(int i=0;i<s1.length();i++)
		          arrs1[s1.charAt(i)-'a']++;

		    for(int i=0;i<s2.length();i++) 
		          arrs2[s2.charAt(i)-'a']++;
		
		    for(int i=0;i<26;i++)
		         if(arrs2[i]!=0 && arrs1[i]==0) return -1;
		     
		     int i=0,ans=0;
		     
		     while(i<s2.length()){
		         for(int j=0;j<s1.length();j++){
		            if(i==s2.length()) break;
		            
		            if(s2.charAt(i)==s1.charAt(j)){
		                i++;
		            }
		         }
	         ans++;
		     }
		     return ans;
		}
		
		//A different function to do the same without using frequency
		/*static int isPossible(String s1,String s2){
		  
		     int i=0,ans=0;   
		     while(i<s2.length()){
		         boolean flag = false;
		         for(int j=0;j<s1.length();j++){
		             
		            if(i==s2.length()) break;
		            
		            if(s2.charAt(i)==s1.charAt(j)){
		                i++;
		                flag = true;
		            }
		         }
		         if(flag == false) return -1;
	         ans++;
		     }
		     return ans;
		}*/
}     