/*Mr Gnanesh is working with words. He has given a list of words. 
Each word in the list contains only two lowercase letters [a-z].

He wants to create biggest word BW, by concatenating words from the list, which 
is a palindrome too. He is allowed to use each word from the list atmost once.

Return the length of the biggest word can be formed using the list.
If it is impossible to create such word, return 0.

Input Format:
-------------
Space separated strings, words[], two letter words.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
ab ba dd

Sample Output-1:
----------------
6

Explanation: 
------------
The biggest word is, ab,dd,ba => abddba, which is a palindrome.


Sample Input-2:
---------------
pq rs sr mk km pq

Sample Output-2:
----------------
8

Explanation: 
------------
The biggest word is, rs,sr,mk,km => rsmkkmsr or mkrssrkm..etc, 
which is a palindrome.


Sample Input-3:
---------------
aa bb cc

Sample Output-3:
----------------
2
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        System.out.println(getMinPalinLen(words));
    }
    static int getMinPalinLen(String[] words){
        Map<String,Integer> diff = new HashMap<>();
        Map<String,Integer> same = new HashMap<>();
        for(String word : words){
            if(word.charAt(0)==word.charAt(1)){
                same.put(word,same.getOrDefault(word,0)+1);
            }else{
                diff.put(word,diff.getOrDefault(word,0)+1);
            }
        }
        int diffContr = 0;
        for(Map.Entry<String,Integer> e : diff.entrySet()){
            String rev = new StringBuilder(e.getKey()).reverse().toString();
            if(diff.containsKey(rev)){
                diffContr += 2*Math.min(diff.get(rev),e.getValue());
            }
        }
        
        int sameContr = 0;
        int maxMiddle = 0;
        for(Map.Entry<String,Integer> e : same.entrySet()){
            if(e.getValue()%2==0){
                sameContr += 2*e.getValue();
            }else{
                if(maxMiddle==0){
                    maxMiddle = e.getValue()*2;
                }else if(e.getValue()*2 > maxMiddle){
                    sameContr += (maxMiddle-2);
                    maxMiddle = e.getValue()*2;
                }
            }
        }
        
        return sameContr+maxMiddle+diffContr;
    }
}