/*
Ramesh and Suresh are best friends. They decided to play a word game.
 The game rules are as follows:
 	- The game board shows a word W consist of two characters only A and B.
	- You are allowed to replace a pair of neighbour letters AA with BB in W.
 	- Finally, The one who failed to replace the letters will lose the game.
 Your task is to find all the possible ways of W, after one valid replacement. 
 You have to perform the replacement of the pair from left to right in the word.
 and print the result in the same order of replacement.
   
  
Input Format:
-------------
 A string W, word.

 Output Format:
 --------------
 Print the list of possible replacements of W.
  
Sample Input-1:
---------------
 AAABAA

Sample Output-1:
----------------
[BBABAA, ABBBAA, AAABBB]
  
Sample Input-2:
---------------
AAAAA

Sample Output-2:
----------------
[BBAAA, ABBAA, AABBA, AAABB] 

*/
import java.util.*;
import java.lang.*;
class day1p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String s = sc.next();
		  ArrayList<String> a1 = new ArrayList<>();
		  StringBuilder sb = new StringBuilder(s);
		  for(int i=0;i<s.length()-1;i++){
		      char c1 = s.charAt(i);
		      char c2 = s.charAt(i+1);
		      if(c1==c2){
		          if(c1=='A')
		              a1.add(s.substring(0,i)+"BB"+s.substring(i+2,s.length()));
		      }
		  }

		  System.out.println(a1);
		 
		}
}        


