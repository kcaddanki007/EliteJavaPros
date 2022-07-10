/*Subodh is interested in playing with Strings,
For a given String 'S', Subodh applies some rules to find the value of 'S'.
The rules are as follows:
	- If it is a balanced () has value 1
	- XY has value X + Y , where X and Y are balanced () strings.
	- (Z) has score 2 * Z , where Z is a balanced parentheses string.
	
Find out the value of given String and print it.

Note: All the given strings are balanced

Input Format:
----------------
A String contains only '(', ')'


Output Format:
------------------
Print an integer as result.


Sample Input-1:
-------------------
()

Sample Output-1:
---------------------
1

Sample Input-2:
-------------------
(())

Sample Output-2:
---------------------
2

Sample Input-3:
-------------------
(()(()))

Sample Output-3:
---------------------
6

*/
import java.util.*;
class day87p4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getScore(s));
    }
    static int getScore(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(0);
            }else{
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2+Math.max(t1*2,1));
            }
        }
        return stack.pop();
    }
}