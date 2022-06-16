/*In a forest, There are N redwoord trees in a row.
You are given the heights of the trees as heights[],

You are task is to find the longest tree arrangement as follows:
	- Minimum size of the tree arrangement is 3.
	- And there exist a Tree-'i' with heights[i], where 0 < i < N-1.
		- heights[0] < heights[1] < heights[2] <...< heights[i] and
		-  heights[i] > heights[i+1] > heights[i+2] >...>heights[N-1] 

And return the length of the longest tree arrangement.
If there is no such arrangement, return 0.

Input Format:
-------------
Line-1: An integer N, number of elements.
Line-2: N space separated integers, value of the elements.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
8
4 2 5 7 4 2 3 6

1 1 2 3 1 1 2 3
1 2 1 3 2 1 1 1
Sample Output-1:
----------------
5

Explanation:
------------
The longest tree arrangement is : 2 5 7 4 2


Sample Input-2:
---------------
4
2 4 5 7

Sample Output-2:
----------------
0
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(getMaxIncreDecre(arr,n));
    }
    static int getMaxIncreDecre(int[] arr,int n){
        int[] inc = new int[n];
        int[] dec = new int[n];
        inc[0] = 1;
        dec[n-1] = 1;
        int ans=0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]) inc[i]=inc[i-1]+1;
            else inc[i]=1;
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]) dec[i]= dec[i+1]+1; 
            else dec[i]=1;
        }
        // System.out.println(Arrays.toString(inc));
        // System.out.println(Arrays.toString(dec));
        if(inc[n-1]==n || dec[0]==n) return 0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,inc[i]+dec[i]-1);
        }
        return ans;
    }
}