/*
The Valid shortcuts of a string "abcd", are as follows:
abcd, abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 1b2, 2c1, 3d,a3,4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains only lowercase
letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true

Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false
*/
import java.util.*;
import java.lang.*;
class day3p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String s1 = sc.next();
		  String s2 = sc.next();
		  int n = s1.length(),cntofc = 0,cntofn = 0;
		  
		  for(int i=0;i<s2.length();i++){
		      if(s2.charAt(i)>= 97)
		          cntofc++;
		      else{
		          int start = i,end=i+1;
		          
		          while(i<s2.length()-1 && s2.charAt(++i) < 97)
		              end=i+1;
		          
		          i--;
		          cntofn += Integer.parseInt(s2.substring(start,end));
		      }
		  }
		  //System.out.println(cntofc);
		  //System.out.println(cntofn);

		  if(cntofc + cntofn == n) System.out.println("true");
		  else System.out.println("false");
		  }
}        

