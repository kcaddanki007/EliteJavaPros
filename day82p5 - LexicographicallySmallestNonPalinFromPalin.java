/*Mr Shravan is given a word W, and W is a palindrome. Mr Shravan is 
allowed to replace only one letter in W, with any lowercase alphabet, 
such that the word W is not a palindrome again and which is the 
lexicographically smallest among all the possible options.

Examples of Lexicographical order are:
	- aaa is smaller than aab
	- abb is smaller than abc.

Return the lexicographically smallest string among all the possible options.

Input Format:
-------------
A String P, palindrome.

Output Format:
--------------
A String result.


Sample Input-1:
---------------
abcdcba

Sample Output-1:
----------------
aacdcba


Sample Input-2:
---------------
aaaa

Sample Output-2:
----------------
aaab


Sample Input-3:
---------------
aaabaaa

Sample Output-3:
----------------
aaabaab
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(smallestNonPalindrome(s));
    }
    static String smallestNonPalindrome(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!='a') return s.substring(0,i) + 'a' + s.substring(i+1);
        }
        return s.substring(0,n-1)+"b";
    }
}