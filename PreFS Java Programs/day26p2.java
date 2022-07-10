/*
Vishal has given a task to find the successor of a given alphabet 'alp' in a 
given string str[].

The alphabets in the given string str[] are all lowercase letters and always in 
non-decreasing order.

A successor of 'alp' is the next smallest alphabet exist in the string str[] 
which is greater than 'alp'.

Assume that alphabets can be considered in cyclic fashion.
For example: Successor for alp='z' in str[]="bcd" is 'b'.

Help Vishal to retunn the answer.

Can you solve it in O(log(n)) complexity?

Input Format:
-------------
Line-1:A string str[]
Line-2: a character represents an alphabet.
 
Output Format:
--------------
Print a character which is the successor.
 
Constraints:
 2 <= str.length<= 10^4
'alp' is a lowercase letter.

 
Sample Input-1:
---------------
adghijl
f 
Sample Output-1:
----------------
g

Sample Input-2:
---------------
abcdefghi
j

Sample Output-2:
----------------
a

*/
import java.util.*;
import java.lang.*;
class day26p2{
		
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String S = sc.nextLine();
          char c = sc.next().charAt(0);
          System.out.println(binarySearch(S,c));
	}
	
	static char binarySearch(String S, char x){
	char[] arr = S.toCharArray();
	    int n = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if(m+1 < n){   //boundary
            if (arr[m] <= x && arr[m+1]>x)
                return arr[m+1];
            }    
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return arr[0];
    }
}        