/*
Rohan has a habit of writing a word in reverse as R and then checks whether
R is same as Original word W. If R is not same as W, he can remove only one
character from R to make it as W.
Print 'true', if Rohan makes R equals W, Otherwise print 'false'.

Input Format:
-------------
Line-1: A string represents a word.

Output Format:
--------------
return a boolean result.

Sample Input-1:
---------------
bcba

Sample Output-1:
----------------
true

Explanation:
------------
By removing charcter 'a', we will get the word in reverse is also same.

Sample Input-2:
---------------
abcd

Sample Output-2:
----------------
false

Explanation:
-------------
There is no possibility to make the reverse is also same.

*/

//Difference between Strings and StringBuilder 
//StringBuilder is mutable and hence we can add/remove characters at specific locations


import java.util.*;
import java.lang.*;
class day9p3{
    
        static boolean check_for_palindrome(StringBuilder string1){
            int n = string1.length();
            boolean check = false;
            char c;
            for(int i=0;i<n;i++){
                c = string1.charAt(i);
                string1.deleteCharAt(i);
                StringBuilder temp = new StringBuilder(string1);
                temp.reverse();
                if(temp.toString().equals(string1.toString())){
                    check = true; 
                    break;
                }
                else{
                    string1.insert(i,c);
                }
            }
            
            return check;
        }
        
        
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String S = sc.next();
          StringBuilder Str = new StringBuilder(S);
          StringBuilder Temporary = new StringBuilder(Str.reverse());
          Str.reverse();
          if(Str.toString().equals(Temporary.toString())){
              System.out.println("true");
              System.exit(0);
          }
          else if(check_for_palindrome(Str)){
              System.out.println("true");
          }
          else{
              System.out.println("false");
          }
          
          
	}	 
}        
