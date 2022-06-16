/*Sumanth has an idea to calculate the ABD value of a string.
An ABD value is defined as the absolute diffrence between
the most occurance count of a charcter and the least occurance count 
of another character in the given string.

Sumanth is given a string S,
He wants to find out, the sum of ABD values of all the substrings of S,
where ABD > 0.

Your task is to help Sumanth to find total ABD value of substrings of S.

Input Format:
-------------
A String S

Output Format:
--------------
Print an integer, sum of ABD of all the strings of S


Sample Input-1:
---------------
abbcc

Sample Output-1:
----------------
5

Explanation: 
------------
The substrings with non-zero ABD are as follows:
Substring and ABD value -> "abb"-1,"abbc"-1,"abbcc"-1,"bbc"-1,"bcc"-1
The total sum of ABD is, 5


Sample Input-2:
---------------
abcbabc

Sample Output-2:
----------------
15

Explanation: 
------------
The substrings with non-zero ABD are as follows:
substring and ABD value -> "abcb"-1,"abcba"-1,"abcbab"-2,"abcbabc"-1,"bcbabc"-2
"bcbab"-2, "bcba"-1, "bcb"-1, "cbab"-1,"cbabc"-1,"bab"-1, "babc"-1.
The total sum of ABD is, 15
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getABDsum(s));
    }
    static int getABDsum(String s){
        int ans=0;
        int n = s.length();
        for(int i=0;i<n;i++){
            for(int j=i+3;j<n+1;j++){
                int[] arr = new int[26];
                //System.out.print(s.substring(i,j));
                for(char c : s.substring(i,j).toCharArray()){
                    arr[c-'a']++;
                }
                int max=-10000,min=10000;
                for(int k=0;k<26;k++){
                    if(arr[k]==0) continue;
                    max = Math.max(max,arr[k]);
                    min = Math.min(min,arr[k]);
                }
                //System.out.print(" "+max+" "+min+"\n");
                
                if(max-min > 0) ans+=(max-min);
            }
        }
        return ans;
    }

}