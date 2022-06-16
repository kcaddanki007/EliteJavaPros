/*Mr Robert is working with strings.
He selected two strings S1 and S2, may differ in length,
consists of lowercase alphabets only.

Mr Robert has to update the strings S1, S2 to meet any one of the criteria:
	- All the alphabets in S1 should be less than all the alphabets in S2.
	- All the alphabets in S2 should be less than all the alphabets in S1.
	- Both S1 and S2 should have only one distinct alphabet in it.
To Achieve, one of the criteria, you are allowed to replace any one letter in 
the string with any other lowercase alphabet.

Your task is to help Mr Robert, to find the minimum replacements to be done to 
update the strings S1 and S2 to meet one of the criteria mentioned above.


Input Format:
-------------
Two space separated strings S1 and S2.

Output Format:
--------------
Print an integer, minimum number of replacements.


Sample Input-1:
---------------
apple ball

Sample Output-1:
----------------
3

Explanation:
------------
Consider the best way to make the criteria true:
- Update S2 to "baaa" in 2 replacements, and Update S1 to "cpple" in 1 replacement
then every alphabet in S2 is less than every alphabet in S1.
        (OR)
- Update S1 to "ppppp" in 3 replacements, then every alphabet in S2 is less 
than every alphabet in S1.


Sample Input-2:
---------------
kmit kmec

kmit 
kmec

Sample Output-2:
----------------
2
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(getMovesForConversion(s1,s2));
    }
    static int getMovesForConversion(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        
        int[] s1freq = new int[26];
        for(int i=0;i<m;i++) s1freq[s1.charAt(i)-'a']++;
        
        int[] s2freq = new int[26];
        for(int i=0;i<n;i++) s2freq[s2.charAt(i)-'a']++;
        
        int minChanges=Integer.MAX_VALUE;
        int sumS1=0,sumS2=0;
        for(int i=0;i<25;i++){
            sumS1+=s1freq[i];
            sumS2+=s2freq[i];
            minChanges = Math.min(minChanges,sumS1+(n-sumS2));
            minChanges = Math.min(minChanges,sumS2+(m-sumS1));
        }
        
        int s1s2maxOccur = 0;
        for(int i=0;i<26;i++) s1s2maxOccur = Math.max(s1s2maxOccur,s1freq[i]+s2freq[i]);
        
        return Math.min(minChanges,m+n-s1s2maxOccur);
    }
}