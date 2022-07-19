/*Ravi is playing with strings.Given Three alphabets [a,b,c] , ravi has to 
make strings such that no two adjacents alphabets are same.

For example, He can make strings as "ab", "acb", "b" and "cbabcabcb" which 
are acceptable.where as the strings "bb", "bcc" and "aabbc" are not acceptable.

Given two integers N and L, Ravi made a list of all acceptable strings of 
length N sorted in lexicographical order.

Return the Lth string of this list or return an empty string if there are less 
than L acceptable strings of length N.

Input Format:
-------------
Line-1: Two space separated integers N and L.

Output Format:
--------------
Print a string result.


Sample Input-1:
---------------
2 3

Sample Output-1:
----------------
ba

Explanation:
-------------
Strings in lexigraphical order are ab,ac,ba,bc,ca,cb. and 3rd one is ba.


Sample Input-2:
---------------
3 4

Sample Output-2:
----------------
acb

Explanation:
------------
Strings in lexigraphical order are aba,abc,aca,acb,bab....
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(getKthStringinN(n,k));
    }
    static String getKthStringinN(int n,int k){
        ArrayDeque<String> adq = new ArrayDeque<>();
        adq.offer("a");
        adq.offer("b");
        adq.offer("c");
        int level = 0;
        List<String> wordsOfLeveln = new ArrayList<>();
        while(!adq.isEmpty()){
            int size = adq.size();
            level++;
            for(int i=0;i<size;i++){
                String temp = adq.poll();
                if(level==n) wordsOfLeveln.add(temp);
                String[] next = getNext(temp);
                adq.offer(next[0]);
                adq.offer(next[1]);
            }
            if(level==n){
                if(wordsOfLeveln.size()>=k)
                  return wordsOfLeveln.get(k-1);
                else break;
            }
        }
        return "";
    }
    static String[] getNext(String s){
        int lastInd = s.length()-1;
        String[] next = new String[2];
        if(s.charAt(lastInd)=='a'){
            next[0] = s+"b";
            next[1] = s+"c";
        }else if(s.charAt(lastInd)=='b'){
            next[0] = s+"a";
            next[1] = s+"c";
        }else{
            next[0] = s+"a";
            next[1] = s+"b";
        }
        return next;
    }
    
}
