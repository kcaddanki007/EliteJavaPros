/*
There are some balls in a row, the balls are numbered from -1000 to +1000.
You need do arrange the balls in a such way that, 
the numbers on the balls in the row, should be in ascending order.
You are allowed to remove few balls in the row, 
but you are not allowed to shuffle their position.

Given an set of integers, numbers printed on the balls. 
Your task is to find the length of longest ascending arrangement of 
the numbered balls in the row.

Input Format:
-------------
Line-1: An integer N represents number of balls.
Line-2: Space separated integers, numbers printed on the balls in a row.

Output Format:
--------------
Print an integer, length of longest ascending arrangement of the numbered balls.
 
Sample Input-1: 
-------------
8
10 9 2 5 3 7 101 18

Sample Output-1: 
--------------
4 

Explanation: 
-------------
The longest ascending arrangement is [2,3,7,101], therefore the length is 4. 
 
 
Sample Input-2: 
-------------
6
0 1 0 1 0 1
  
Sample Output-2: 
--------------
2
 
Explanation: 
-------------
The longest ascending arrangement is [0, 1], therefore the length is 2. 
*/

import java.util.*;
import java.lang.*;
class day28p2{
        static int[] dp;
        
        static int finAnswer(int[] arr, int n){
            int finMax=1;
            for(int i=n;i>=0;i--){
                finMax = Math.max(finMax,longAscSeq(arr,i));
            }
            return finMax;
        }
        

        static int longAscSeq(int[] arr,int lastind){
            if(lastind==0)
              return 1;
            else if(dp[lastind]!=-1001)  
              return dp[lastind];
            else{
                int max=1;
                for(int i=lastind-1;i>=0;i--){
                    if(arr[lastind]>arr[i]){
                       max = Math.max(max,1+longAscSeq(arr,i)); 
                    }
                }
                dp[lastind]=max;
            }  
            return dp[lastind];
        }
        
	
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int[] arr = new int[n];
		  dp = new int[n];
		  dp[0]=1;
		  Arrays.fill(dp,-1001);
		  
		  for(int i=0;i<n;i++)
		      arr[i] = sc.nextInt();
		      
		System.out.println(finAnswer(arr,n-1));	  
		}
}        