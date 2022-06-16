/*AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false

*/
import java.util.*;
import java.lang.*;
class day48p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String s = sc.next();
          System.out.println(getPalin(s));		  
		}
		static boolean getPalin(String s){
		    int n=s.length();
		    int[] count = new int[26];
		    for(int i=0;i<n;i++) count[s.charAt(i)-'a']++;
		    int countOfOdd=0;
		    for(int i=0;i<26;i++){
		        if(count[i]%2==1) ++countOfOdd;
		        if(countOfOdd>1) return false;
		    }
		    return true;
		}
}     