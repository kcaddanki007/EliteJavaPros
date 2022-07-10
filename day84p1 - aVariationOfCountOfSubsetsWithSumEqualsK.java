/*Mr Rajendra Tapadia is given a number N as string to Mr Satyam, and ask him 
to find the number of ways to make that number N equal to zero by using 
the following steps:
    - He need to perform either '+' or '-' operation between two adjacent digits
    - You can repeat the above step to make the N value to 0.
    
For example: if N is 454522 then it's possible to perform the '+'/'-' operations 
the following way, 4+5-4-5-2+2, 4-5-4+5-2+2, 4+5-4-5+2-2 or 4-5-4+5+2-2.
A total of 4 ways.

Your task is to help Mr Satyam to find the number of ways possible to make N to 0
using the above steps. Print "invalid", if it is not possible.

Input Format:
-------------
A String, the number N.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
13741

Sample Output-1:
----------------
2

Explanation: 
------------
The ways are, 1+3-7+4-1 and 1-3+7-4-1.


Sample Input-2:
---------------
2351

Sample Output-2:
----------------
invalid
*/
import java.util.*;
class Solution{
    static Integer[][] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getWaysToZero(s));
    }
    static String getWaysToZero(String s){
        char[] c = s.toCharArray();
        int[] arr = new int[c.length];
        int sum=0;
        int n = c.length;
        for(int i=0;i<n;i++){ 
            arr[i] = c[i]-'0';
            sum+=arr[i];
        }
        if(sum%2!=0) return "Invalid";
        sum=sum/2;
        dp = new Integer[n+1][sum+1];
        
        int globalCnt = helperBackTrack(arr,n,sum);
        return (globalCnt==0)? "Invalid":""+(globalCnt/2);
    }
    static int helperBackTrack(int[] arr,int curr,int sum){
        if(sum==0) return 1;
        if(curr==0 && sum>0) return 0;
        if(dp[curr][sum]!=null) return dp[curr][sum];
        if(arr[curr-1]>sum)
          dp[curr][sum] = helperBackTrack(arr,curr-1,sum);
        else 
          dp[curr][sum] = helperBackTrack(arr,curr-1,sum)
          +helperBackTrack(arr,curr-1,sum-arr[curr-1]);
          
        return dp[curr][sum];
    }
    
}