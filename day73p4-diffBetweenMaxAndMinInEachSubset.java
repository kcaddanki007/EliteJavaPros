/*There are several bricks with numbers printed on them, ranging from -100 to 100.
They were all lined up in a row. Your task is to calculate the sum of 
the differences between the greatest and smallest values in each contiguous 
group of bricks in the line.

Input Format:
-------------
Single line space separated integers, the values from -100 to 100.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 8 3 4

Sample Output-1:
----------------
26

Explanation:
------------
The contiguous groups of bricks are as follows:
[3],[8],[3],[4], diff = greatest - smallest is 0.
[3,8], diff = 8 - 3 = 5
[8,3], diff = 8 - 3 = 5
[3,4], diff = 4 - 3 = 1
[3,8,3], diff = 8 - 3 = 5
[8,3,4], diff = 8 - 3 = 5
[3,8,3,4], diff = 8 - 3 = 0
So the sum of all diffs is 5+5+1+5+5+5 = 26.


Sample Input-2:
---------------
-2 0 -2 4 -2

Sample Output-2:
----------------
48
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int[] arr = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(getDiffCount(arr,strs.length));
    }
    static int getDiffCount(int[] arr,int n){
        int count=0;
        for(int i=0;i<n;i++){
            int min = arr[i];
            int max = arr[i];
            for(int j=i+1;j<n;j++){
                min = Math.min(arr[j],min);
                max = Math.max(arr[j],max);
                count += (max-min);
            }
        }
        return count;
    }
}