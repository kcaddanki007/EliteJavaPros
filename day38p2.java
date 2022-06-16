/*For this challenge, a substring is defined as any contiuous group of one or more 
characters of a string. For example, the unique substrings of "baca" are [b, ba, 
bac, baca, a, ac, aca, c ,ca] . The list in alphabetical order is [a, ac, aca, b, 
ba, bac, baca, c, ca]. in this case, the maximum substrin, alphabetically, is 'ca'.

Given a string s, determine its maximum substring.

Your task is to design a function, that return the maximum substring of s.

NOTE:
String s contains only lowercase alphabets.

Input Format:
-------------
A string, s

Output Format:
--------------
print a string, maximum substring.


Sample Input-1:
---------------
baca

Sample Output-1:
----------------
ca


Sample Input-2:
---------------
banana

Sample Output-2:
----------------
nana

*/
import java.util.*;
import java.lang.*;
class day38p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String s = sc.next();
		  System.out.println(getBiggest(s));
		}
		static String getBiggest(String s){
		    int firstPos = -1;
		    char maxChar = 'A';
		    for(int i=0;i<s.length();i++){
		        if(s.charAt(i)>maxChar){
		            maxChar = s.charAt(i);
		            firstPos = i;
		        }
		    }
		    String s1 = s.substring(firstPos,s.length());
		    for(int i=firstPos+1;i<s.length();i++){
		        if(s.charAt(i)==maxChar){
		            s1 = (s1.compareTo(s.substring(i,s.length())) > 0) ? s1 : s.substring(i,s.length());
		        }
		    }
		    return s1;
		}
}     
 
 