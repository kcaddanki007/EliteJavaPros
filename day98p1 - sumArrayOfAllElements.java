/*Mr Madhav is playing a game, He played the game for N terms, the scores are 
given as list of integers as scores[], contains both +ve and -ve integers.

The game rules are as follows (i.e., game has negative points also ) :
 - Each term, the player has to start with 0 points.
 - The player has to play N terms and record the points earned or lost.
 - After N terms played, he wants to maxmize the gain or minimize the loss.
 - The amount is calculated as follows, for every 'i' in 0<=i<N :
    * step-1: Add all the points from index-'0' to index-'i+1' points
    * step-2: Add all the points from index-'i' to index-'N-1' points
    * Keep the maximum amount from the above two steps.

Your task is to return the maximum amount Mr Madhav gained or The minimum amount 
Mr Madhav lost.

Input Format:
-------------
Line-1: Comma separated integers, list[] of numbers.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
5,-9,-6,7,7,4

Sample Output-1:
----------------
18

Explanation: 
------------
When i=0: 5, 8 
When i=1: -4, 3
When i=2: -10, 12
When i=3: -3,18 
When i=4: 4, 11
When i=5: 8, 4  =>  So, Max is 18.


Sample Input-2:
---------------
-5,-4,-6,-7

Sample Output-2:
----------------
-4
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strarr = sc.nextLine().split(",");
        int[] arr = new int[strarr.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(strarr[i]);
        }
        System.out.println(getMinOrMax(arr));
    }
    static int getMinOrMax(int[] arr){
        int[] forward = new int[arr.length];
        int[] backward = new int[arr.length];
        int n = arr.length;
        forward[0] = arr[0];
        backward[n-1] = arr[n-1];
        for(int i=1;i<n;i++){
            forward[i]=arr[i]+forward[i-1];
            backward[n-i-1] = arr[n-i-1] + backward[n-i];
        }
        int fin = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            fin = Math.max(fin,Math.max(forward[i],backward[i]));
        }
        return fin;
    }
}