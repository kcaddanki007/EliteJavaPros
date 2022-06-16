/*Mr Subodh is given an array arr[] of M integers between 0 to 10000.
And he is also given another integer P.
Subodh has to update each integer in the arr[]:
Subodh is allowed to update the arr[i], as follows:
	- arr[i] = arr[i] + P (or) arr[i] = arr[i] - P.

Subodh has to find the update score as the difference between 
maximum element in the arr[] to the minimum element arr[] after all the
elements in the arr[] updated. and return the update score.


Input Format:
-------------
Line-1: Two space separated integers M and P.
Line-2: M space separated integers, integer > 0.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 2
2 6 3

Sample Output-1:
----------------
1

Explanation: 
------------
Update the array as [4, 4, 5]. The score is maximum(arr) - minimum(arr)
=> 5 - 4 = 1.


Sample Input-2:
---------------
4 3
1 11 8 4

Sample Output-2:
----------------
4

Explanation: 
------------
Update the array as [4, 8, 5, 7]. The score is maximum(arr) - minimum(arr) 
=> 8 - 4 = 4

*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(getMinMaxDiff(arr,n,k));
    }
    static int getMinMaxDiff(int[] arr,int n,int k){
        Arrays.sort(arr);
        int ans = arr[n-1]-arr[0];
        for(int i=0;i<n-1;i++){
            int high = Math.max(arr[n-1]-k,arr[i]+k);
            int low = Math.min(arr[0]+k,arr[i+1]-k);
            ans = Math.min(ans,high-low);
        }
        return ans;
    }
}