/*Govind is playing with strings.
He is given two strings S1 and S2, He has to find if each character in S1 can S2 a word in S2 or not.

A S2 that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and distinct non-empty word in S2, 
where each non-empty word in S2 also has a corresponding letter in S1.

Return true,if it is a complete S2.
Otherwise false.

Note: You may assume S1 and S2 contains only lowercase letters, S2 contains whitespace also.

Input Format:
-------------
Line-1 -> A string S1, single word
Line-2 -> A string S2, group of space separated words.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
baba
cat rat cat rat

Sample Output-1:
----------------
true

Sample Input-2:
---------------
baba
cat rat rat cat

Sample Output-2:
----------------
false

*/

//using 2 way maps
import java.util.*;
import java.lang.*;
class day7p2{
        public static void main(String args[]){
            
          Map<Character, String> lettertoword = new HashMap<>();
          Map<String, Character> wordtoletter = new HashMap<>();
          
          Scanner sc = new Scanner(System.in);
          String word = sc.nextLine();
          int n = word.length();
          char[] chword = word.toCharArray();
          String[] strarr = new String[n];
          int count=0;
          for(int i=0;i<n;i++){
              strarr[i] = sc.next();
          }
          
          
          for(int i=0;i<n;i++){
              if(!lettertoword.containsKey(chword[i])){
                  lettertoword.put(chword[i],strarr[i]);
                  count++;
              }
              else if(lettertoword.containsKey(chword[i])&&(lettertoword.get(chword[i]).equals(strarr[i]))){
                  count++;
              }
          }
          
          for(int i=0;i<n;i++){
              if(!wordtoletter.containsKey(strarr[i])){
                  wordtoletter.put(strarr[i],chword[i]);
                  count++;
              }
              else if(wordtoletter.containsKey(strarr[i])&&(wordtoletter.get(strarr[i]).equals(chword[i]))){
                  count++;
              }
          }
          
          if(count==2*n){
              System.out.println("true");
          }
          else{
              System.out.println("false");
          }
          
          
          
          
        }
}        