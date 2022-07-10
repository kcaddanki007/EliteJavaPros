/*Ms Saina is given a task.
She needs your help to complete the task.

The Task is defined as follows:
    - She is given a word W.
    - She needs to find all the vowels in W from left to right.
      and arrange them from right to left in the word W.

Your task is to modify the word W according to the above steps.
ANd print the resultant word.

NOTE: 
- Vowels are [a,e,i,o,u].
- W contains only lowwercase letters.

Input Format:
-------------
A string W, word.

Output Format:
--------------
Print a string result.


Sample Input-1:
---------------
divide

Sample Output-1:
----------------
devidi

Explanation:
------------
the order of vowels from left to right in W are : i, i, e
After arrange them from right to left order, the word is : devidi 


Sample Input-2:
---------------
racing

Sample Output-2:
----------------
ricang
*/

//Stacks

import java.util.*;
import java.lang.*;
class day6p2{
        public static void main(String args[]){
            
            
          Scanner sc = new Scanner(System.in);
          String word = sc.nextLine();
          int n = word.length();
          
          Stack<Character> stack = new Stack<Character>();
          char[] ch = word.toCharArray();
          
          for(int i=0;i<n;i++){
              if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u'){
                  stack.push(ch[i]);
                  ch[i]='$';
              }
          }
          
          for(int i=0;i<n;i++){
              if(ch[i]=='$'){
                  ch[i]=stack.pop();
              }
          }
          
        System.out.println(ch);
        }
}      