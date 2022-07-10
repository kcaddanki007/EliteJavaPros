/*Math Challenge(str) take the str parameter being passed and determine if there
is some substring K that can be repeated N > 1 times to produce the input string
exactly as it appears. Your program should return the longest substring K, and
if there is none it should return "Not Possible".

Input Format:
-------------
A string str, consists of lowercase alphabet.

Output Format:
--------------
Print the longest substring K.


Sample Input-1:
---------------
abcababcababcab

Sample Output-1:
----------------
abcab


Sample Input-2:
---------------
ababab ababab ababab
ababab ababab ababab

Sample Output-2:
----------------
ababab


Sample Input-3:
---------------
abcxabc

Sample Output-3:
----------------
Not Possible

*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getLargestSub(s));
    }
    static String getLargestSub(String s){
        int n = s.length()/2;
        for(int i=n;i>0;i--){
            if(makeStringFromSubstring(s,s.substring(0,i))) return s.substring(0,i);
        }
        return "Not Possible";
    }
    static boolean makeStringFromSubstring(String s,String sub){
        if(s.length()%sub.length()!=0) return false;
        int sublen=sub.length();
        int rep = s.length()/sublen;
        for(int i=0;i<s.length();i+=sublen){
            if(!s.substring(i,i+sublen).equals(sub)) return false;
        }
        return true;
    }
}