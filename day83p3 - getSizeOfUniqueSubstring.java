/*Mr Shravan is given a word W, and W cosists of lowercase alphabets only. 
Mr Shravan is interested to find the substring which is smallest in length 
the which occurs only one in the word W.

Your task is to help Mr Sharavan to return the length of the smallest 
substring of W according to the above statement.

Input Format:
-------------
A String W, consists of lowercase letters.

Output Format:
--------------
An integer result.


Sample Input-1:
---------------
abbaabab

Sample Output-1:
----------------
2
bb

Sample Input-2:
---------------
rererer

Sample Output-2:
----------------
5
rerer
erere
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getUniqueLen(s));
    }
    static int getUniqueLen(String s){
        int n=s.length();
        for(int size=1;size<n;size++){
            for(int i=0;i<=n-size;i++){
                String t = s.substring(i,i+size);
                if(s.indexOf(t)==s.lastIndexOf(t)) return size;
            }
        }
        return n;
    }
}

// ab =2 
// 0 1