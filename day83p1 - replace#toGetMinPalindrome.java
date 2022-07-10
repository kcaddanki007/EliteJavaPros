/*Mr Shravan is given a word W, and W cosists of lowercase alphabets and '#'. 
Mr Shravan is allowed to replace the '#' with any one lowercase alphabet, 
such that the word W is a palindrome and it has to be the lexicographically
smallest among all the possible options.

Your task is to help Mr Sharavan to return the lexicographically smallest 
palindrome string among all the possible options. 
OR "invlaid" if it is not possible.

Input Format:
-------------
A String P, consists of lowercase letters and #.

Output Format:
--------------
A String result.


Sample Input-1:
---------------
r#d#v##er

Sample Output-1:
----------------
redavader


Sample Input-2:
---------------
r#d#v#cer

Sample Output-2:
----------------
invalid

*/
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getLexicoSmallestPalin(s));
    }
    static String getLexicoSmallestPalin(String s){
        char[] arr = s.toCharArray();
        int i=0,j=arr.length-1;
        while(i<j){
            if(!(arr[i]==arr[j] || arr[i]=='#' || arr[j]=='#')) return "invalid";
            else{
                if(arr[i]==arr[j]){
                    if(arr[i]=='#'){
                        arr[i]='a';
                        arr[j]='a';
                    }
                }else if(arr[i]=='#'){
                    arr[i] = arr[j];
                }else{
                    arr[j] = arr[i];
                }
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}