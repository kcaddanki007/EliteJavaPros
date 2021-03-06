/*
You are playing a shooting game.
There are N bottles hanging to a rod, i-th bottle numbered bottle[i].

If you shoot i-th bottle, you will get bottle[i-1]*bottle[i]*bottle[i+1] points.
The more points you score, the more rewards you can win.

Your task is to score the maximum points by shooting all the ballons wisely.

Note: After you shoot bottle at i-th index, bottles at i-1 and i+1 positions
become adjacent. if there is no existing 'i-1' or 'i+1' positions for selected bottle.
you can assume that bottle[i-1] = bottle[i+1] = 1.

Input Format:
-------------
N space separated integers bottles[].

Output Format:
--------------
Print an integer, maximum points you can get.


Sample Input:
---------------
3 1 5 8

Sample Output:
----------------
167

Explanation:
------------
Given bottles = [3, 1, 5, 8] 
position 	points
--------------------
1				3*1*5
5				3*5*8
3				1*3*8
8				1*8*1
--------------------
Total = 167


Sample Input:
---------------
2 1 3 5 4

Sample Output:
----------------
102

Explanation:
------------
Given bottles = [2, 1, 3, 5, 4] 

position 	points
--------------------
5				3*5*4
1				2*1*3
3				2*3*4
2				1*2*4
4				1*4*1
--------------------
Total = 102
*/
import java.lang.*;
import java.util.*;

class day38p3{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String strarr[] = sc.nextLine().split(" ");
        int inp[] = new int[strarr.length];
        for(int i=0;i<strarr.length;i++) inp[i] = Integer.parseInt(strarr[i]);
        int dp[][] = new int[inp.length][inp.length];
        int max;
        for(int p=0;p<inp.length;p++)
        {
            for(int i=0,j=p;j<inp.length;i++,j++)
            {
                max = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++)
                {
                    int l = (k==i)?0:dp[i][k-1];
                    int r = (k==j)?0:dp[k+1][j];
                    int val = (i==0?1:inp[i-1])*inp[k]*(j==inp.length-1?1:inp[j+1]);
                    int total = l+r+val;
                    max = Math.max(max,total);
                }
                dp[i][j] = max;
            }
        }
        System.out.println(dp[0][inp.length-1]);
    }
}