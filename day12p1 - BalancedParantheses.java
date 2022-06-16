/*Clavius, the person who suggested grouping of data using brackets.
He has suggested that the grouping should be well formed.
Well formed groupings are as follows, (), [], {}, {()}, {[]()}, {[]}(), etc.

You will be given a string S, return true if the string S is a well formed 
grouping, otherwise false.

Note: S contains only characters ( ) [ ] { }

Input Format:
-------------
A string S, contains only characters (){}[]

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
{[([])[]]}

Sample Output-1:
----------------
true

Sample Input-2:
---------------
{[([])[]}]

Sample Output-2:
----------------
false
*/
import java.util.*;
import java.lang.*;
class day12p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String S = sc.nextLine();
		  
		  System.out.println(isBalanced(S));
		}
		static boolean isBalanced(String S){
		    Stack<Character> stack= new Stack<>();
		  stack.push(S.charAt(0));
		  for(int i=1;i<S.length();i++){
		      if(S.charAt(i)=='{' || S.charAt(i)=='[' || S.charAt(i) =='(') stack.push(S.charAt(i));
		      else if(S.charAt(i)=='}'){
		          if(stack.peek()=='{') stack.pop();
		          else return false;
		      }
		      else if(S.charAt(i)==']'){
		          if(stack.peek()=='[') stack.pop();
		          else return false;
		      }
		      else if(S.charAt(i)==')'){
		          if(stack.peek()=='(') stack.pop();
		          else return false;
		      }
		  }
		  return true;
		}
}        

