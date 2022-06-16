/*Mr Shravan is working with Strings.
He is given a string S, and a list of words.
He wants to find a word which is maximum in length and 
appears first in lexicographical order, And the word is a subsequence of S.

Your task is to help Mr Shravan to find such a word from the given list of words.
If there is no such word, print "No Word".

Input Format:
-------------
Line-1: A string S.
Line-2: Space separated strings, words[].

Output Format:
--------------
Print a string result.



Sample Input-1:
---------------
rascapepurple
ape cape racer app apple

Sample Output-1:
----------------
apple


Sample Input-2:
---------------
abcdefhijk
bca abd abc dfe def ghi

Sample Output-2:
----------------
abc

Sample Input-3:
---------------
vivid
viva diva diya

Sample Output-3:
----------------
No Word
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = sc.nextLine().split(" ");
        System.out.println(getMax(s,words));
    }
    static String getMax(String s,String[] words){
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(a.length()==b.length()){
                return a.compareTo(b);
            }
            return b.length()-a.length();
        });
        for(int i=0;i<words.length;i++){
            pq.offer(words[i]);
        }
        int pqsize = pq.size();
        for(int i=0;i<pqsize;i++){
            String s1 = pq.poll();
            if(isSubSeq(s1,s)) return s1;
        }
        return "No Word";
    }
    static boolean isSubSeq(String s1,String s){
        int i=0,j=0;
        while(i<s.length() && j<s1.length()){
            if(s.charAt(i)!=s1.charAt(j)){
                i++;
            }
            else{
                i++;
                j++;
            }
        }
        return j==s1.length();
    }
}