/*In a school, there are N students in a class numbered from 1,2,3..N.
During the play time in school, drill master wants to split them into 
two teams based on their interest.

If the pair of students want to play opposite each other, drill master should 
put them in different teams, e.g. pair[i] = (A,B), it is not allowed to 
put A and B in same team.
 
You need to find out wether is it possible to put everyone into two teams or not
return true if it is possible, otherwise false.

Input Format:
----------------
Line-1 -> Two Integers, N and P, number of students N, number of pairs P.
Next P lines -> Two integers, one pair[i], where 'i' is from 0 to P-1

Output Format:
------------------
Print a boolean result.


Sample Input-1:
-------------------
5 4
1 2
1 3
2 4
3 5




Sample Output-1:
---------------------
true

Explanation: 
----------------
team1 [1,4,5], team2 [2,3]


Sample Input-2:
-------------------
5 5
1 2
2 3
3 4
4 5
1 5

Sample Output-2:
---------------------
false
*/
import java.util.*;
class Solution{
    static int[] soln;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        soln = new int[n+1];
        for(int i=0;i<n+1;i++) parent[i]=-1;
        
        int p = sc.nextInt();
        int[][] pairs = new int[p][2];
        for(int i=0;i<p;i++){
            pairs[i][0] = sc.nextInt();
            pairs[i][1] = sc.nextInt();
        }
        System.out.println(isPossibleToSplit(n,p,pairs));
    }
    static boolean isPossibleToSplit(int n,int p,int[][] pairs){
        int m=2;
        mcoloring(1,n,m)
    }
    static void mcoloring(int k,int n,int m){
        while(true){
            nextValue(k);
            if()
        }
    }
    
}