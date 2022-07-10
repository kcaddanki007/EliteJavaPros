/*Preethi is playing with strings. She is given 2 strings. 
Preethi can remove any number of characters from 2 strings such that 2 strings 
to be equal after removal (Sequence of characters shouldn't change).
Find the smallest ASCII sum possible for the removed characters.

Input Format:
-------------
Line-1: Two space seperated strings

Output Format:
--------------
return an integer , represents ASCII sum with the given constraints.

Sample Input-1:
---------------
treat create

Sample Output-1:
----------------
316

Explanation:
-------------
Remove 't' in string1 and 'c' and 'e' in string 2. so sum= 116+99+101=316


Sample Input-2:
---------------
interest pintrest

Sample Output-2:
----------------
213

Explanation:
-------------
Remove 'e' in string1 and p in string2. so sum=101+112=213
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(getASCIIdifferenceLCS(s1,s2));
    }
    static int getASCIIdifferenceLCS(String s1,String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        for(int i=s1.length()-1;i>=0;i--)
            dp[i][s2.length()] = dp[i+1][s2.length()]+s1.charAt(i);
        
        for(int j=s2.length()-1;j>=0;j--)
            dp[s1.length()][j] = dp[s1.length()][j+1]+s2.charAt(j);
            
        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j))
                  dp[i][j] = dp[i+1][j+1];
                else
                  dp[i][j] = Math.min(dp[i+1][j]+s1.charAt(i),dp[i][j+1]+s2.charAt(j));
            }
        }
        return dp[0][0];
        
    }
}