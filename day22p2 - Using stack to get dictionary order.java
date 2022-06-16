/*Pramod is working on words. He used to remove all the duplicate letters 
from a word. Pramod is given a word W. His task to remove all the duplicate 
letters from W, in such a way that the resulatant word R, contains 
no duplicate letters and all distinct letters from W should be there in R. 
And R should appear first in the dictionary order. 

Input Format:
-------------
A String, the word W.

Output Format:
--------------
Print a String, resulatant word R.


Sample Input-1:
---------------
cbadccb

Sample Output-1:
----------------
adcb


Sample Input-2:
---------------
silicosis

Sample Output-2:
----------------
ilcos
*/
import java.util.*;
import java.lang.*;
class day22p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String s = sc.next();
		  System.out.println(getWordWithoutDup(s));
		}
		static String getWordWithoutDup(String s){
		    int[] counts = new int[26];
		    boolean[] vis = new boolean[26];
		    
		    for(int i=0;i<s.length();i++)
		        counts[s.charAt(i)-'a']++;
		  
		    Stack<Character> stack = new Stack<>();
            int idx;
            for(int i=0;i<s.length();i++){
                idx = s.charAt(i)-'a';
                counts[idx]--;  
                if(vis[idx])
                    continue;
                while(!stack.isEmpty() && s.charAt(i)<stack.peek() && counts[stack.peek()-'a']!=0){ 
                    vis[stack.pop()-'a']=false;
                }
                stack.push(s.charAt(i)); 
                vis[idx]=true;
            }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
            
        sb.reverse();
        return sb.toString();
		}
}        

