/*A binary word Bn is formed as follows:
    B[1] = "0"
    B[i+1] =  B[i] $ "1" $ reverse(complement(B[i])) for i > 1

where $ denotes the concatenation operation, reverse(complement(B)) returns 
the reversed word of complement(B), which perform 1's complement of B 
(0 changes to 1 and 1 changes to 0).

For example, the first 4 words in the above sequence are:

    B[1] = "0"
    B[2] = "011"
    B[3] = "0111001"
    B[4] = "011100110110001"

Return the Pth bit in B[N]. It is guaranteed that P is valid for the given N.

Input Format:
-------------
Line-1: Two space seperated integers represents N and P.

Output Format:
--------------
Return a bit (0 or 1).


Sample Input-1:
---------------
3 4

Sample Output-1:
----------------
1

Explanation:
------------
B[3] = "0111001" and 4th bit is 1.

Sample Input-2:
---------------
4 10

Sample Output-2:
----------------
1

Explanation:
-------------
B[4] = "011100110110001" and 10th bit is 1.
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(getStringPos(n,p));
    }
    static char getStringPos(int n,int p){
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        for(int i=1;i<n;i++){
            StringBuilder rev = getCompReverse(sb);
            sb.append(1).append(rev);
        }
        return sb.charAt(p-1);
    }
    static StringBuilder getCompReverse(StringBuilder sb){
        StringBuilder s = new StringBuilder(sb);
        for(int i=0;i<s.length();i++){
            s.setCharAt(i,s.charAt(i)=='1'?'0':'1');
        }
        s.reverse();
        return s;
    }
}