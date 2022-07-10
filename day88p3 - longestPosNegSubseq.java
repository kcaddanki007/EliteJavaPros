/*Gopal is given a list of integers.
Your task to is find out, the length of the longest subsequence that is a
toggle sequence.

Toggle Sequence means, the difference between the consecutive numbers
are alternate positive and negative.

For Example:
Given list of integers = 1 3 2 5 4 
the consecutive differences are [ 2, -1, 3, -1], 
the differences are alternate +ve and -ve.
So, complete list is a toggle sequence.

If the list of integers = 1 3 2 4 5,
the consecutive differences are [ 2, -1, 2, 1], not alternate +ve and -ve.
Not a toggle sequence.

Note: A sequence with fewer than two elements is a toggle sequence.

Input Format:
-------------
Space separated Integers, List

Output Format:
--------------
Print the length of the longest toggle sequence


Sample Input-1:
---------------
1 7 4 9 2 5

Sample Output-1:
----------------
6

Explanation:
------------
Given list of integers = 1 7 4 9 2 5
the consecutive differences are [ 6, -3, 5, -7, 3], 
the differences are alternate +ve and -ve.
So, complete list is a toggle sequence.

Sample Input-2:
---------------
1 5 4 3 7 9 10

Sample Output-2:
----------------
4

Explanation:
------------
Given list of integers = 1 5 4 3 7 9 10
the consecutive differences are [ 4, -1, -1, 4, 2, 1], 
the differences are alternate +ve and -ve.
So, there are more than one toggle sequences of length 4.
*/
import java.util.*;
class Solution{
    static Integer[] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strnums = sc.nextLine().split(" ");
        int[] nums = new int[strnums.length];
        for(int i=0;i<strnums.length;i++)
          nums[i] = Integer.parseInt(strnums[i]);
        dp = new Integer[nums.length+1];
        System.out.println(getToggleSequenceLength(nums));
    }
    static int getToggleSequenceLength(int[] nums){
        int[] diff = new int[nums.length-1];
        
        if(nums.length<=2) return nums.length;
        
        for(int i=1;i<nums.length;i++)
           diff[i-1] = nums[i]-nums[i-1];
           
        return 1+longestPositiveNegativeSubseq(diff);
    }
    static int longestPositiveNegativeSubseq(int[] diff){
        Integer[] dp = new Integer[diff.length+1];
        int res = helper(diff,diff.length,dp);
        dp[0] = 0;
        dp[1] = 1;
       // System.out.println(Arrays.toString(dp));
        return res;
    }
    static int helper(int[] diff,int curr,Integer[] dp){
        if(curr<=1) return curr;
        if(dp[curr]!=null) return dp[curr];
        if(diff[curr-1]>0){
            int max=0;
            for(int i=1;i<=curr-1;i++){
                if(diff[i-1]<0)
                  max=Math.max(max,helper(diff,i,dp));
            }
            dp[curr] = 1+max;
        }else{
            int max=0;
            for(int i=1;i<=curr-1;i++){
                if(diff[i-1]>0)
                max = Math.max(max,helper(diff,i,dp));
            }
            dp[curr] = 1+max;
        }
        return dp[curr];
    }
}