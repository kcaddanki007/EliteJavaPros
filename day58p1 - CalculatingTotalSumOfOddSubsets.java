/*Prasad is given a list of integers nums[].
He like odd numbers, so he wanted to form  
the odd length consecutive subsets possible.

Now your task is to help Prasad, to form the odd length subsets,
and to compute and print the sum of all such subsets.

Input Format:
-------------
Line-1: An integer N, number of integers.
Line-2: N space separated integers, nums[].

Output Format:
--------------
Print an integer, the sum.


Sample Input:
---------------
5
1 4 2  5  3
1 5 7 12 15

Sample Output:
----------------
58

Explanation:
------------
From the given list of integers, possible subsets are.
[1] = 1, [4] = 4, [2] = 2, [5] = 5, [3] = 3,
[1,4,2] = 7,	[4,2,5] = 11,	[2,5,3] = 10
[1,4,2,5,3] = 15
Finally, total sum is:  1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
*/
import java.util.*;
class day58p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int[] arr = new int[n];
		  for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		  System.out.println(getSumOfOdds(arr,n));
		}
		static int getSumOfOdds(int[] arr,int n){
		    int[] presum = new int[n];
		    int ans=0;
		    presum[0] = arr[0];
		    for(int i=1;i<n;i++){
		        presum[i] = arr[i] + presum[i-1];
		    }
		    ans+=presum[n-1];
		    for(int i=3;i<=n;i+=2){
		        //System.out.println("swsize:"+i);
		        int tsum = presum[i-1];
		        ans += tsum;
		        //System.out.println("tsum:"+tsum);
		        //System.out.println("ans:"+ans);
		        for(int j=i;j<n;j++){
		            tsum = presum[j] - presum[j-i];
		            ans+=tsum;
		          //  System.out.println("tsum:"+tsum);
		  //      System.out.println("ans:"+ans);
		            
		        }
		    }
		return ans;    
		}
}     
 