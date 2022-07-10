/*Gunith is interested in series and sequence problems in Maths.
Gunith is given an array A of integers, he wants to find out 
a Sequence, which is long and subsequence of given array.

Subsequence AS is the list AS[i], AS[i1], AS[i2], .... AS[ik], from the array, 
where 0 <= i< i1 < i2 < ..<ik < A.length

The sequence S has to follow this rule, S[i+1] - S[i] are all the same value 
(for 0 <= i < S.length - 1 ), and Sequence S can be formed from A

Find out the Max possible length of the Longest Sequence.

Input Format:
-------------
Line-1 -> An integer N, number of array elements
Line-2 -> N space separated integers, elements of the array.

Output Format:
--------------
Print an integer as your result.


Sample Input-1:
---------------
4
2 6 10 14

Sample Output-1:
----------------
4


Sample Input-2:
---------------
7
2 5 6 8 10 11 14

Sample Output-2:
----------------
5

Explanation:
------------
The longest possible arithmetic series is 2 5 8 11 14.
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inp = new int[n];
        for(int i=0;i<n;i++)
            inp[i] = sc.nextInt();
        
        System.out.println(getLongestAPsubseq(inp,n));
    }
    static int getLongestAPsubseq(int[] inp,int n){
        //Arrays.sort(inp);
        int max = 0,was,diff;
        HashMap<Integer,Integer>[] hmaps = new HashMap[n];
        
        for(int i=0;i<n;i++)
          hmaps[i] = new HashMap<>();
          
        for(int currInd=0;currInd<n;currInd++){
            for(int beforeInd=0;beforeInd<currInd;beforeInd++){
                diff = inp[currInd]-inp[beforeInd];
                was = hmaps[beforeInd].getOrDefault(diff,1);
                max = Math.max(max,was+1);
                hmaps[currInd].put(diff,was+1);
            }
        }
        return max;
    }
}