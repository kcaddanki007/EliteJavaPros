/*Mohith and Rohith are good friends, They are used to chatting very often.
Mohith is lazy to type the complete word, so he finds a way to shorten the words.
For example, if the original word is "banana", he types it as "ba2[na]".

Can you help Rohith, to find the original word from the shortened word 
he received from Mohith.

NOTE: 
- You may assume that the original word is always valid and does not 
  contain any digits. 
- No white spaces. The brackets are well-formed.

Input Format:
-------------
A String, a word given by Mohith, contains brackets [], and alphabets and digits

Output Format:
--------------
A string, the original word.


Sample Input-1:
---------------
ba2[na]

Sample Output-1:
----------------
banana


Sample Input-2:
---------------
3[3[sa]2[ri]]

Sample Output-2:
----------------
sasasaririsasasaririsasasariri
*/
import java.util.*;
class day52p3{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String s = sc.next();
		  System.out.println(decoded(s));
		}
		static String decoded(String s){
		Stack<Character> stack = new Stack<>();
		int n=s.length();
		for(int i=0;i<n;i++){
		    
		    while(i<n && s.charAt(i)!=']'){
		        stack.push(s.charAt(i));
		        i++;
		    }
		    if(i<n && s.charAt(i)==']') stack.push(']');
		    
		    StringBuilder letter = new StringBuilder();
		    if(!stack.isEmpty()&&stack.peek()==']'){
		        stack.pop();
        		while(!stack.isEmpty() && stack.peek()!='[')  letter.append(stack.pop());
        		    if(!stack.isEmpty() && stack.peek()=='[')stack.pop();
        		    String word = letter.reverse().toString();
        		
        		    StringBuilder no = new StringBuilder();
        		    while(!stack.isEmpty() && stack.peek()-'0'>=0 && stack.peek()-'0'<=9){
        		        no.append(stack.pop());
        		    }
        		    int num = (no.length()==0)?0:Integer.parseInt(no.reverse().toString());
        		    
        		    for(int ti=0;ti<num;ti++)
        		        for(int j=0;j<word.length();j++) stack.push(word.charAt(j));
		    }
		    
		}
		
		StringBuilder ans = new StringBuilder();
		while(!stack.isEmpty()) ans.append(stack.pop());
		return ans.reverse().toString();
	    }
}		
		