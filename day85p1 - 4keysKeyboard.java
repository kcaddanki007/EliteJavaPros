/*Amogh is an Antiquarian, The person who collects antiques.
He found a rear keyboard which has following keys,
Keys are 'N', 'S', 'C' and 'P'

1st Key - 'N': Print one character 'N' on Console.
2nd Key - 'S': Select the whole Console.
3rd Key - 'C': Copy selected content to buffer.
4th Key - 'P': Print the buffer on Console, and append it after what has 
already been printed.

Now, your task is to find out maximum numbers of 'N's you can print
after K keystrokes . 

Input Format:
-------------
An integer K

Output Format:
--------------
Print an integer, maximum numbers of 'N's you can print.


Sample Input-1:
-------------------
3

Sample Output-1:
-------------------- 
3

Explanation: 
---------------
We can print at most get 3 N's on console by pressing following key sequence:
N, N, N



Sample Input-2:
-------------------
7


Sample Output-2:
---------------------
9

Explanation: 
---------------
We can print at most get 9 N's on console by pressing following key sequence:
N, N, N, S, C, P, P

*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getMax(n));
    }
    static int getMax(int n){
        if(n<=6) return n;
        int[] dp = new int[n];
        
        for(int i=1;i<=6;i++) 
            dp[i-1] = i;
            
        for(int i=7;i<=n;i++){
            for(int b=i-3;b>=1;b--){
                int curr = (i-b-1)*dp[b-1];
                if(curr>dp[i-1]) 
                  dp[i-1]=curr;
            }
            
        }
        return dp[n-1];
    }
}