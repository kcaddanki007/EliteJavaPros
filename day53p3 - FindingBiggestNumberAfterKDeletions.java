/*Somesh is working on Number Strings.
He got an idea to find the smallest possible number by 
deleting some digits from the number without changing 
the relative order of digits in it.

You will be given a integer String 'num', and an integer n.
Find the smallest number possible after deleting n digits from 'num'.

Note: If the number string 'num' turns to empty, print 0.

Input Format:
-------------
Line-1 : A string num, consist of digits only.
Line-2 : An integer n, number of digits to delete.

Output Format:
--------------
Print the smallest possible number.


Sample Input-1:
---------------
1432219
3

Sample Output-1:
----------------
1219

Explanation: 
------------
Delete the three digits 4, 3, and 2 to form the smallest number 1219.


Sample Input-2:
---------------
10200
1

Sample Output-2:
----------------
200

Explanation:
------------
Delete the leading 1 and the smallest number is 200. 
Note that the output must not contain leading zeroes.
*/
import java.util.*;
class day53p3{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String s = sc.next();
		  int n = sc.nextInt();
		  System.out.println(getAfterDeletion(s,n));
		}
		static String getAfterDeletion(String s,int n){
		    Stack<Character> stack = new Stack<>();
		    for(int i=0;i<s.length();i++){
		        while(!stack.isEmpty()&&stack.peek()>s.charAt(i) && n!=0){
		            stack.pop();
		            n--;
		        }
		        stack.push(s.charAt(i));
		    }
		    String ans = "";
           while(!stack.isEmpty()){
               ans= ""+stack.pop()+ans;
           }
           int i=0,len = ans.length();
           while(i<len && ans.charAt(i)=='0'){
               i++;
           }
           return ans.substring(i,len);
		}
}     