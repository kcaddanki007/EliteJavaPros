/*You are given some tokens printed with unique numbers on it and an integer T.
Your task is to find the least number of tokens that you need to make up the 
value T, by adding the numbers printed on all the tokens. 
If yyou cannot make the value T, by any combination of the tokens, return -1.

NOTE: Assume that you have unlimited set of tokens of each number type.

Input Format:
-------------
Line-1: Space separated integers tokens[], number printed on tokens.
Line-2: An integer T.

Output Format:
--------------
Print an integer, minimum number of tokens to make the value T.


Sample Input-1:
---------------
1 2 5
11

Sample Output-1:
----------------
3

Explanation:
------------
5+5+1 = 11


Sample Input-2:
---------------
2 4
15

Sample Output-2:
----------------
-1
*/
import java.util.*;
class day87p1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strnums = sc.nextLine().split(" ");
        int[] coins = new int[strnums.length];
        for(int i=0;i<strnums.length;i++)
           coins[i] = Integer.parseInt(strnums[i]);
        int target = Integer.parseInt(sc.nextLine());
        System.out.println(unBounded(coins,target));
    }
    static int unBounded(int[] coins,int target){
        int[] dp = new int[target+1];
        for(int remWeight=1;remWeight<target+1;remWeight++)
           dp[remWeight]= target+1;
           
        for(int remWeight=1;remWeight< target+1 ;remWeight++){
            for(int c : coins){
                if(remWeight - c>=0){
                    dp[remWeight] = Math.min(dp[remWeight],1+dp[remWeight-c]);
                }
            }
        }
        if(dp[target] != target+1) return dp[target];
        else return -1;
    }
    //     int[][] dp = new int[coins.length+1][target+1];
    //     for(int i=1;i<target+1;i++){
    //         dp[0][i] = 100000;
    //         if(i%coins[0]==0){
    //             dp[1][i] = i/coins[0];
    //         }else{
    //             dp[1][i] = 100000;
    //         }
            
    //     }
    //     for(int currItem=2;currItem<coins.length+1;currItem++){
    //         for(int remWeight=1;remWeight<target+1;remWeight++){
    //             if(coins[currItem-1]>remWeight){
    //                 dp[currItem][remWeight]= dp[currItem-1][remWeight];
    //             }else{
    //                 dp[currItem][remWeight] = 1+Math.min(dp[currItem][remWeight-coins[currItem-1]],dp[currItem-1][remWeight]);
    //             }
    //         }
    //     }
    //     return (dp[coins.length][target] > 100000) ? -1 : dp[coins.length][target];
    
    // }
}