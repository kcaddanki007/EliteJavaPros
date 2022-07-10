/*Your  task is to find and print the newly added character to S to form T.


Input Format:
-------------
Two space separated Strings S and T.
 
Output Format:
--------------
Print a character, added to S.


Sample Input-1:
---------------
ram marg

Sample Output-1:
----------------
g


Sample Input-2:
---------------
av ava

Sample Output-2:
----------------
a
*/

/*import java.util.*;
import java.lang.*;
class day8p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String word1 = sc.next();
          String word2 = sc.next();
          Map<Character, int> letter = new HashMap<>();
          
          int n = word1.length();
          for(int i=0;i<n;i++){
              int count=0;
              if(!numbers.containsKey(word1.charAt(i))) {
                  letter.put(word1.charAt(i),count);
              else{
                  count++;
                  
              }
           }
              
          }
          
          for(int i=0;i<n+1;i++){
              if(!letter.containsKey(word2.charAt(i))){
                  System.out.println(word2.charAt(i));
              }
          }
          
          
        }
}*/

//USAGE OF XOR OPERATOR

import java.util.*;
import java.lang.*;
class day8p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String word1 = sc.next();
          String word2 = sc.next();
          word1 = word1.concat(word2);
          char n=word1.charAt(0);
          for(int i=1;i<word1.length();i++){
              n = (char)(n^word1.charAt(i));
          }
          System.out.println(n);
        }
}        