/*Babylonian working on numbers, got a task to do. 
The task is, given two integers S, and X,
and S is the sum of (N pow X), where N > 0, 
0 < S < 1000 and 0< X < =10.

Please help Babylonian to find the number of ways to get S.

Input Format:
-------------
Two integers S and X.

Output Format:
--------------
Print an integer, the number of ways.

Sample Input-1:
---------------
10 2

Sample Output-1:
----------------
1

Explanation:
--------------
given x=2,
pow(1,2) + pow(3,2) = 1 + 9 = 10


Sample Input-2:
---------------
100 2

Sample Output-2:
----------------
3

Explanation:
--------------
given x=2,
pow(1,2) + pow(3,2) + pow(4,2) + pow(5,2) + pow(7,2) = 1 + 9 + 16 + 25 + 49 =100
pow(6,2) + pow(8,2) = 36 + 64 = 100
pow(10,2) = 100

Sample Input-3:
---------------
8 2

Sample Output-3:
----------------
0


Sample Input-4:
---------------
8 3

Sample Output-4:
----------------
1

Explanation: pow(2,3) = 8
*/
import java.util.*;
class Solution{
    static Integer[][] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int x = sc.nextInt();
        ArrayList<Double> al = new ArrayList<>();
        
        for(int i=1;Math.pow(i,x)<=s;i++)
          al.add(Math.pow(i,x));
        
        dp = new Integer[al.size()+1][(int)s+1];
        
        System.out.println(getNumOfWays(al,al.size(),s));
    }
    static Integer getNumOfWays(ArrayList<Double> al,int curr,int s){
        if(s==0) return 1;
        if(curr==0) return 0;
        if(dp[curr][(int)s]!=null) return dp[curr][(int)s];
        if(al.get(curr-1)>s){
            dp[curr][(int)s] = getNumOfWays(al,curr-1,s);
        }else{
            dp[curr][(int)s] = getNumOfWays(al,curr-1,(int)(s-al.get(curr-1))) + getNumOfWays(al,curr-1,s);
        }
        return dp[curr][s];
    }
}