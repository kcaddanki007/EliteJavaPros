/*
Raj and Bheem are using a Desktop Computer.One day they found that keyboard is 
defective in which if you type backspace button,it will print '$' , instead of 
removing one previous character.
Bheem and Raj have tried to type one word each on the same keyboard.
Return true, if both tried to type the same word.otherwise return false.

Note:backspace for an empty text will continue empty.

Input Format:
-------------
Line-1:Two space seperated strings represents words w1,w2.

 
Output Format:
--------------
Print a boolean result.
 
Constraints:

    1 <= w1.length, w2.length <= 200
    w1 and w2 only contain lowercase letters and '$' characters.


 
Sample Input-1:
---------------
pq$r  pt$r

Sample Output-1:
----------------
true

Explanation:
------------
Both wants to type 'pr'

Sample Input-2:
---------------
se$$at cea$$t

Sample Output-2:
----------------
false

Sample Input-3:
---------------
s$$at ce$$at

Sample Output-2:
----------------
true

Explanation:
------------
Both wants to type 'at'.

*/
import java.util.*;
import java.lang.*;
class day30p2{
	    
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		 String S = sc.next();
		 String T = sc.next();
		
		Stack<Character> stS = new Stack<>();
		Stack<Character> stT = new Stack<>();
		
		for(int i=0;i<S.length();i++){
		    
		    if(S.charAt(i)!='$') stS.push(S.charAt(i));
		    else{
		        if(stS.size()!=0){
		            stS.pop();
		        }
		    }
		}
		
		for(int i=0;i<T.length();i++){
		    
		    if(T.charAt(i)!='$') stT.push(T.charAt(i));
		    else{
		        if(stT.size()!=0){
		            stT.pop();
		        }
		    }
		}
		
		if((stS.toString()).equals(stT.toString()))
		   System.out.println("true");
		else
				   System.out.println("false");

		  
		
		 
		}
}        