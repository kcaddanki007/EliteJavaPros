/*Vihaan is given a list of words[]. 
He is asked to create a method which returns the numbers of characters in a word 
formed from long lasting frequent posteriority.

Posteriority is the word formed from the original word with few characters removed
without modifying the corresponding order of the left over characters.

An uncommon posteriority between the list of words is a word that is a posteriority
of one word but not the others.

Your task is to find the longest uncommon posteriority of the list of words.
Return 0 if no uncommon posteriority.


Input Format:
-------------
Space separated strings words[]

Output Format:
--------------
Print an integer, the length of longest uncommon prosperity.


Sample Input-1:
---------------
mom rar ama

Sample Output-1:
----------------
3


Sample Input-2:
---------------
ppp ppp pp

Sample Output-2:
----------------
-1
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        System.out.println(getPosLen(strs));
    }
    static int getPosLen(String[] strs){
        Arrays.sort(strs,(a,b)->b.length()-a.length());
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<strs.length;i++)
           map.put(strs[i],map.getOrDefault(strs[i],0)+1);
        for(int i=0;i<strs.length;i++){
            if(map.get(strs[i])!=1) continue;
            int j=0;
            for(j=0;j<i;j++){
                if(strs[i]==strs[j] || isSubseq(strs[i],strs[j])) break; 
            }
            if(i==j) 
              return strs[i].length();
        }
        return -1;
    }
    static boolean isSubseq(String small,String big){
        int i=0,j=0;
        int m = small.length(),n = big.length();
        while(i<m && j<n)
           if(small.charAt(i)==big.charAt(j++)) i++;
        
        return i==m;
    }
}