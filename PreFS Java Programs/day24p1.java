/*
Nagesh has given two words to check whether the first word 'source' is a
sub-series of second word 'target'.

A sub-series from a word can be formed by removing 0 or more characters without 
changing the relative order of other characters in the word.

For example, 'nest' is a subseries of a word 'interst' , where as 'rest' is not.

Help Nagesh to return true if source is a subseries of target, otherwise false.

Constraints:
 0 <= source.length <= 100
 0 <= target.length <= 10^4
 source and target consist only of lowercase English letters.

Input Format:
-------------
Line-1:Two space separeted strings

 
Output Format:
--------------
Print a boolean result.
 
 
Sample Input-1:
---------------
pqsv pqrstuv
 
Sample Output-1:
----------------
true

Sample Input-2:
---------------
psr pqrst

Sample Output-2:
----------------
false

*/
import java.util.*;
import java.lang.*;
class day24p1{
	    static Map<String, Boolean> memo = new HashMap<>();
            
		public static void main(String args[]){
			Scanner sc = new Scanner(System.in);
			String source = sc.next();
			String target = sc.next();
		    int slen = source.length();
			int tlen = target.length();
			System.out.println(isSS(source,target,slen-1,tlen-1));
		}	
		
		static boolean isSS(String s, String t, int si, int ti){
			if(si==0) return true;
			if(ti==0) return false;
			String key = si+"-"+ti;
			if(memo.containsKey(key))return memo.get(key);
			
			if(s.charAt(si)==t.charAt(ti)){
				memo.put(key,isSS(s,t,si-1,ti-1));
			}else{
				memo.put(key,isSS(s,t,si,ti-1));
			}
			return memo.get(key);
		}
}	    