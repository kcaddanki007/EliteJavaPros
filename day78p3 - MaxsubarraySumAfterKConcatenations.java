/*Mr Lokesham is given a set of N numbers nums[].
He can find the highest sum in the given set easily.
He got and idea to append the set nums[] with itself for M-1 times.
And then find the highest sum of the contiguous subset of nums[].
The subset length can be 0, in such case the answer is 0.

For example, nums[]=[1,2,3], and m=3 means the final set nums[]=[1,2,3,1,2,3,1,2,3].

And after you get the final set nums[], Lokesham wants to find 
the highest sum possible from the final set nums[].

Your task is to help the Lokesham, to find the highest possible sum.
The sum might be very long, return "sum modulo 10^9 + 7".

Constraints:
-----------
1 <= nums[].length <= 50000
1 <= m <= 50000
-9999<= nums[i] <= 9999


Input Format:
-------------
Line-1: Two space separated integers
Line-2: N space separated integers, nums.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
5 -4 2

Sample Output-1:
----------------
14

Explanation:
------------
Append the set [4-1] more times
Resultant Set is : 5 -4 2 5 -4 2 5 -4 2 5 -4 2
Sum of the contiuous subset [5 -4 2 5 -4 2 5 -4 2 5] is 14.


5 -9 6 5 -9 6

Sample Input-2:
---------------
3 2
1 2 3

Sample Output-2:
----------------
12


Sample Input-3:
---------------
3 5
3 -2 -1

Sample Output-3:
----------------
3
*/
import java.util.*;
import java.io.*;

class Solution {
    public long mAppendedMaxSum(int[] nums, int m) {
        int len = nums.length;
        long cur = nums[0];
        long max = nums[0];
        long sum=0;
        for(int i=0;i<len;i++) sum+=nums[i];
        
        sum%=1000000007;
        
          for(int i=1;i<2*len;i++){
              cur = Math.max(nums[i%len],(cur+nums[i%len]));
              max = Math.max(cur,max);
          }
          return max <=0 ? max : ((sum*(m-2))+max)%1000000007;
    }
}